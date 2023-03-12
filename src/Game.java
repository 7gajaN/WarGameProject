import java.util.LinkedList;

public class Game {

    public Game(){

    }

    public static void simulateRound(PlayerList playerList,Table table,LinkedList<Integer> inGame, Table aux){
        table.getCardsFromPlayers(playerList,inGame);
        aux.addCardsFromTable(table);
        System.out.println(table.getWinners());
        if(table.getWinners().size()>1){
            LinkedList<Integer> warParticipants = table.getWinners();
            playerList.eliminatePlayers(warParticipants);
            table.clearTable();
            simulateRound(playerList,table,warParticipants,aux);
            aux.addCardsFromTable(table);
        }else {
            playerList.getPlayerByIndex(table.getWinners().get(0)).appendCards(aux.getCards());
            table.clearTable();
            aux.clearTable();
        }
    }

    public static void startGame(int players){
        Deck deck = new Deck();

        deck.createDeck();

        deck.shuffleDeck();

        deck.displayDeck();

        Dealer dealer = new Dealer(deck);

        PlayerList playerList = dealer.dealCards(players);

        Table table = new Table();
        Table aux = new Table();

        long start = System.currentTimeMillis();
        long end = start + 30 * 1000;

        while (System.currentTimeMillis() < end) {
            playerList.eliminatePlayers(playerList.indexOfPlayersInGame());
            playerList.displayHands();
            simulateRound(playerList,table,playerList.indexOfPlayersInGame(),aux);
            if(playerList.indexOfPlayersInGame().size()==1)
                break;
        }

        System.out.println("@@@@@@@@@@@@@@@@@@END@@@@@@@@@@@@@@@@@@@@@");

    }
}
