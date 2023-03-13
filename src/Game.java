import java.util.LinkedHashMap;
import java.util.Set;

public class Game {

    public Game(){

    }

    public static void simulateRound(LinkedHashMap<Integer,Player> playerList,Table table,Set<Integer> inGame){
        Deck aux = new Deck();
        if(!table.cards.isEmpty()) {
            table.registerCards(aux);
            table.clearTable();
        }
        table.getCardsFromPlayers(playerList,inGame);
        System.out.println(table.getWinners());
        if(table.getWinners().size()>1){ // case war
            Set<Integer> warParticipants = table.getWinners();
            checkAndUpdatePlayersInGame(playerList,warParticipants);
            simulateRound(playerList,table,warParticipants);
        }else {
            table.registerCards(aux);
            playerList.get(table.getWinners().toArray()[0]).appendCards(aux);
            table.clearTable();
        }
    }

    public static Set<Integer> getIndexOfPlayersInGame(LinkedHashMap<Integer,Player> playerList){
                return playerList.keySet();
    }


    public static void checkAndUpdatePlayersInGame(LinkedHashMap<Integer,Player> playerList, Set<Integer> inGame) {
        Object[] inGameArray = inGame.toArray();
        for (Object o : inGameArray)
            if (playerList.get(o).handIsEmpty()) {
                playerList.remove(o);
                inGame.remove(o);
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

    public static void setCardsPower(Deck deck){
        for(Card card : deck.cards){
            switch (card.getNumber()){
                case "Two":
                    card.setPower(1);
                    break;
                case "Three":
                    card.setPower(2);
                    break;
                case "Four":
                    card.setPower(3);
                    break;
                case "Five":
                    card.setPower(4);
                    break;
                case "Six":
                    card.setPower(5);
                    break;
                case "Seven":
                    card.setPower(6);
                    break;
                case "Eight":
                    card.setPower(7);
                    break;
                case "Nine":
                    card.setPower(8);
                    break;
                case "Ten":
                    card.setPower(9);
                    break;
                case "Jack":
                    card.setPower(10);
                    break;
                case "Queen":
                    card.setPower(11);
                    break;
                case "King":
                    card.setPower(12);
                    break;
                case "Ace":
                    card.setPower(13);
                    break;
            }
        }
    }

    public static void startGame(int players){

        LinkedHashMap<Integer,Player> playerList = createPlayerList(players);

        Deck deck = Deck.createStandard52CardDeck();
        deck.shuffleDeck();
        setCardsPower(deck);

        dealCards(playerList,deck);

        displayHands(playerList);

        Table table = new Table();

    //    for(int i=0;i<10;i++){
    //        checkAndUpdatePlayersInGame(playerList,getIndexOfPlayersInGame(playerList));
    //        simulateRound(playerList,table,getIndexOfPlayersInGame(playerList));
    //        displayHands(playerList);
    //    }



        // long start = System.currentTimeMillis();
        // long end = start + 30 * 1000;

        // while (System.currentTimeMillis() < end) {
        //     checkAndUpdatePlayersInGame(playerList, getIndexOfPlayersInGame(playerList));
        //     displayHands(playerList);
        //     simulateRound(playerList,table,getIndexOfPlayersInGame(playerList));
        //     if(getIndexOfPlayersInGame(playerList).size()==1)
        //         break;
        // }

        System.out.println("@@@@@@@@@@@@@@@@@@END@@@@@@@@@@@@@@@@@@@@@");

    }
}
