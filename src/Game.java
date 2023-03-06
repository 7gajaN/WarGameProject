import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Game {

    public static boolean isMultiple(int num1, int num2) {
        if (num1 % num2 == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static void displayHands(ArrayList<ArrayList<Card>> hands, int players){
        for(int i=0; i< players; i++){
            System.out.print("Player " + (i+1) + " has: [");
            for(Card card : hands.get(i))
                System.out.print(card.getNumber() + " of " + card.getSign() + " , ");
            System.out.println();
        }
    }

    public static int getWinner(ArrayList<Card> cards, int players){
        int max = 0;
        int maxIndex = 0;

            for(int i=0;i<players;i++)
                if( max < cards.get(i).getPower()) {
                    max = cards.get(i).getPower();
                            maxIndex = i;
                }
            return maxIndex;
    }

    static ArrayList<ArrayList<Card>> playerHand = new ArrayList<ArrayList<Card>>();
    public static void startGame(int players, ArrayList<Card> deck) {
            int playerIndex = 0;
            int cardCounter = 0;

            playerHand.add(new ArrayList<Card>());

            for(Card card : deck){
                cardCounter = cardCounter + 1;
                playerHand.get(playerIndex).add(card);
                if(isMultiple(cardCounter, 52/players)){
                    playerHand.add(new ArrayList<Card>());
                    playerIndex = playerIndex + 1;
                } // have to fix extra index when 52%players != 0
            }

            ArrayList<Card> table = new ArrayList<Card>();
            while (players > 1){
                    table.clear();
                    for(int i=0;i<players;i++){
                        if(playerHand.get(i).isEmpty()){
                            playerHand.remove(i);
                            players = players - 1;
                            System.out.println("player out");
                            displayHands(playerHand, players);

                        }
                    }
                    displayHands(playerHand, players);
                    for(int i=0;i<players;i++)
                    {table.add(playerHand.get(i).get(0));
                        playerHand.get(i).remove(0);}
                    System.out.println(getWinner(table,players));
                    playerHand.get(getWinner(table,players)).addAll(table);
            }

    }
}
