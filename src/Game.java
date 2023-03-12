import java.lang.reflect.Array;
import java.util.LinkedHashMap;
import java.util.Set;

public class Game {

    public Game(){

    }

    public static void simulateRound(LinkedHashMap<Integer,Player> playerList,Table table,Set<Integer> inGame, Table aux){
        table.getCardsFromPlayers(playerList,inGame);
        aux.addCardsFromTable(table);
        System.out.println(table.getWinners());
        if(table.getWinners().size()>1){
            Set<Integer> warParticipants = table.getWinners();
            checkAndUpdatePlayersInGame(playerList,warParticipants);
            table.clearTable();
            simulateRound(playerList,table,warParticipants,aux);
            aux.addCardsFromTable(table);
        }else {
            playerList.get(table.getWinners().toArray()[0]).appendCards(aux.getCards());
            table.clearTable();
            aux.clearTable();
        }
    }

    public static Set<Integer> getIndexOfPlayersInGame(LinkedHashMap<Integer,Player> playerList){
                return playerList.keySet();
    }


    public static void checkAndUpdatePlayersInGame(LinkedHashMap<Integer,Player> playerList, Set<Integer> inGame) {
        Object[] inGameArray = inGame.toArray();
        for(int i=0;i<inGameArray.length;i++)
            if(playerList.get(inGameArray[i]).handIsEmpty()){
                playerList.remove(inGameArray[i]);
                inGame.remove(inGameArray[i]);
            }
    }

    public static LinkedHashMap<Integer,Player> createPlayerList(int nrPlayers){
        LinkedHashMap<Integer,Player> playerList = new LinkedHashMap<>();
        for(int i=0;i<nrPlayers;i++)
            playerList.put(i,new Player(i));
        return playerList;
    }

    public static void displayHands(LinkedHashMap<Integer,Player> playerList){
        playerList.forEach((i,player)->{
            player.displayPlayerHand();
        });
    }

    public static void dealCards(LinkedHashMap<Integer,Player> playerList,Deck deck){
        int j=0;
        int deckSize = deck.getDeckSize();
        for(int i=0;i< deckSize;i++){
            if(j==playerList.size())
                j=0;
            playerList.get(j).getHand().addCardToTop(deck.getTopCard());
            j++;
        }
    }

    public static void startGame(int players){

        LinkedHashMap<Integer,Player> playerList = createPlayerList(players);

        Deck deck = new Deck();
        deck.createDeck();
        deck.shuffleDeck();

        dealCards(playerList,deck);

        displayHands(playerList);


        Table table = new Table();
        Table aux = new Table();

        for(int i=0;i<10;i++){
            checkAndUpdatePlayersInGame(playerList,getIndexOfPlayersInGame(playerList));
            simulateRound(playerList,table,getIndexOfPlayersInGame(playerList),aux);
            displayHands(playerList);
        }



//        long start = System.currentTimeMillis();
//        long end = start + 30 * 1000;
//
//        while (System.currentTimeMillis() < end) {
//            checkAndUpdatePlayersInGame(playerList, getIndexOfPlayersInGame(playerList));
//            displayHands(playerList);
//            simulateRound(playerList,table,getIndexOfPlayersInGame(playerList),aux);
//            if(getIndexOfPlayersInGame(playerList).size()==1)
//                break;
//        }

        System.out.println("@@@@@@@@@@@@@@@@@@END@@@@@@@@@@@@@@@@@@@@@");

    }
}
