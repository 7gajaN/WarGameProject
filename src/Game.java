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
    public static void displayTable(ArrayList<Card> table){
        for(Card card : table)
            System.out.print(card.getNumber() + " of " + card.getSign() + " , ");
    }

    public static ArrayList<Integer> getWinner(ArrayList<Card> cards, ArrayList<Integer> inGame){
        int max = 0;
        ArrayList<Card> cardsAux  = new ArrayList<Card>();
        cardsAux.addAll(cards);
            for(int i=0;i<inGame.size();i++)
                if( max < cardsAux.get(i).getPower()) {
                    max = cardsAux.get(i).getPower();
                }
            int j=0;
            while(j<inGame.size()){
                if(cardsAux.get(j).getPower() != max){
                    inGame.remove(j);
                    cardsAux.remove(j);
                }
                else
                    j++;
            }
            return inGame;
    }

    public static void checkPlayers(ArrayList<ArrayList<Card>> playerHand,int players){
        for(int i=0; i<= players; i++)
            if(playerHand.get(i).isEmpty()){
                playerHand.remove(i);
                players--;
                i--;
            }
    }

    public static void startWar(ArrayList<ArrayList<Card>> playerHand,int players){
        ArrayList<Card> table = new ArrayList<Card>();
        ArrayList<Card> aux = new ArrayList<Card>();
        ArrayList<Integer> inGame = new ArrayList<Integer>();

        while (playerHand.size()>1){
            inGame.clear();
            table.clear();
            aux.clear();
            for(int i=0; i<= players; i++)
                if(playerHand.get(i).isEmpty()){
                    playerHand.remove(i);
                    players--;
                    i--;
                } //if its an exterior method it doesnt work???
            displayHands(playerHand,players);
            for(int i=0;i<players;i++){
                table.add(playerHand.get(i).get(0));
                playerHand.get(i).remove(0);
                inGame.add(i);
            }

            for(Card card : table){
                aux.add(card);
            }

            getWinner(table,inGame);
            System.out.println(inGame);

            while (inGame.size()>1){
                System.out.println("@@@@@@@@@@@@@WAR@@@@@@@@@@@@@@@@@@@");
                for(Card card : table){
                    aux.add(card);
                }
                table.clear();
                for(Integer i : inGame) {
                    table.add(playerHand.get(i).get(0));
                    playerHand.get(i).remove(0);
                }
                displayTable(table);
                System.out.println(inGame);
                System.out.println(getWinner(table,inGame));
                aux.addAll(table);
            }
            if(inGame.size() == 1){
                playerHand.get(getWinner(table,inGame).get(0)).addAll(aux);
            }
        }
        }

    public static ArrayList<ArrayList<Card>> playerHand = new ArrayList<ArrayList<Card>>();
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


            startWar(playerHand,players);
//            while (players > 1){
//                    table.clear();
//                    for(int i=0;i<players;i++){
//                        if(playerHand.get(i).isEmpty()){
//                            playerHand.remove(i);
//                            players = players - 1;
//                            System.out.println("player out");
//                            displayHands(playerHand, players);
//
//                        }
//                    }
//                    displayHands(playerHand, players);
//                    for(int i=0;i<players;i++)
//                    {table.add(playerHand.get(i).get(0));
//                        playerHand.get(i).remove(0);}
//                    System.out.println(getWinner(table,players));
//                    playerHand.get(getWinner(table,players).get(0)).addAll(table);
            }

    }

