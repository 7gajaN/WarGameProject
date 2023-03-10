
import java.util.ArrayList;

public class Game {

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

    public static void checkPlayerHand(PlayerHands playerHands,ArrayList<Integer> inGame){
        for(int i=0;i<inGame.size();i++)
            for(Player p : playerHands.player)
                if(p.getIndex()==inGame.get(i))
                    if(p.getHand().isEmpty()) {
                        inGame.remove(i);
                    }
    }


    public static void startGame(int players, ArrayList<Card> deck) {

                PlayerHands playerHand = new PlayerHands(PlayerHands.dealCards(deck,players));

                Table table = new Table(new ArrayList<PlayedCard>());

                long start = System.currentTimeMillis();
                long end = start + 30 * 1000;

        while (System.currentTimeMillis() < end) {
            if (playerHand.player.size() > 1) {
                System.out.println("______________________________");
                playerHand.removeUser(playerHand);
                for (Player player : playerHand.player) {
                    System.out.print("Player " + player.getIndex() + " [ ");
                    player.displayHand(player);
                }

                ArrayList<Integer> inGame = new ArrayList<>();
                for (Player p : playerHand.player)
                    inGame.add(p.getIndex());

                table = Table.populateTable(playerHand.player, inGame);

                ArrayList<PlayedCard> aux = new ArrayList<PlayedCard>();

                getWinner(table, inGame);

                while (inGame.size() > 1) {//case war
                    aux.addAll(table.cards);
                    table.cards.clear();
                    System.out.println(inGame);
                    checkPlayerHand(playerHand,inGame);
                    table = Table.populateTable(playerHand.player, inGame);
                    getWinner(table, inGame);
                }
                System.out.println(inGame);
                aux.addAll(table.cards);
                table.setCards(aux);
                appendCards(inGame, playerHand.player, table);


                table.cards.clear();
                aux.clear();
            }else break;
        }

        System.out.println("@@@@@@@@@@@@@@@@@@@@@END@@@@@@@@@@@@@@@@@@@@");

            }

    }

