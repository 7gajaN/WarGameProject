
import java.util.ArrayList;

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
    public static void displayTable(ArrayList<Card> table){
        for(Card card : table)
            System.out.print(card.getNumber() + " of " + card.getSign() + " , ");
    }

    public static ArrayList<Integer> getWinner(Table table, ArrayList<Integer> inGame){
        int max = 0;
        ArrayList<Integer> getWinner = new ArrayList<Integer>();
        for(PlayedCard card : table.cards){
            if(card.getPower()>max)
                max = card.getPower();
        }
        for(PlayedCard card : table.cards){
            if(card.getPower()==max)
                getWinner.add(card.getPlayerIndex());
        }
        return getWinner;
    }




    public static void startGame(int players, ArrayList<Card> deck) {


            }

    }

