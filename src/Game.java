
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
        inGame.clear();
        inGame.addAll(getWinner);
        return inGame;
    }

    public static void appendCards(ArrayList<Integer> winnerList, ArrayList<Player> playerHand, Table table){
        int winner = winnerList.get(0);
        ArrayList<Card> aux = new ArrayList<Card>();
        for(int i=0;i<table.cards.size();i++)
            aux.add(new Card(table.cards.get(i).getNumber(),table.cards.get(i).getSign(),table.cards.get(i).getPower()));
        for(Player player : playerHand){
            if(player.getIndex()==winner){
                player.getHand().addAll(aux);
                break;}
        }
    }




    public static void startGame(int players, ArrayList<Card> deck) {
                //ArrayList<Player> playerHand = new ArrayList<Player>();
                //playerHand = PlayerHands.dealCards(deck,players);

                PlayerHands playerHand = new PlayerHands(PlayerHands.dealCards(deck,players));

                Table table = new Table(new ArrayList<PlayedCard>());

                for(int j = 0 ;j<5;j++) {
                    System.out.println("______________________________");
                    for(Player player : playerHand.player)
                        player.displayHand(player);

                    ArrayList<Integer> inGame = new ArrayList<>();
                    for (int i = 0; i < playerHand.player.size(); i++)
                        inGame.add(i);

                    table = Table.populateTable(playerHand.player, inGame);

                    ArrayList <PlayedCard> aux = new ArrayList<PlayedCard>();

                    getWinner(table, inGame);

                    while(inGame.size() > 1){//case war
                        aux.addAll(table.cards);
                        table.cards.clear();
                        System.out.println(inGame);
                        table = Table.populateTable(playerHand.player,inGame);
                        getWinner(table, inGame);
                    }
                    System.out.println(inGame);
                    //ArrayList<Integer> messi = new ArrayList<Integer>();
                    //messi = getWinner(table, test);
                    aux.addAll(table.cards);
                    table.setCards(aux);
                    appendCards(inGame,playerHand.player,table);


                    table.cards.clear();
                    aux.clear();
                }

            }

    }

