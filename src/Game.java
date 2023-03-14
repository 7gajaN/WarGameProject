import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Set;

public class Game {

    public Game(){

    }
    
    public static class CardComparator implements Comparator<Card>{
    
        public double getNumberValue(Card card){
            switch(card.getNumber()){
                case Two:
                    return 1;
                case Three:
                    return 2;
                case Four:
                    return 3;
                case Five:
                    return 4;
                case Six:
                    return 5;
                case Seven:
                    return 6;
                case Eight:
                    return 7;
                case Nine:
                    return 8;
                case Ten:
                    return 9;
                case Jack:
                    return 10;
                case Queen:
                    return 11;
                case King:
                    return 12;
                case Ace:
                    return 13;
            }
            return 0;
        }
    
        public double getSignValue(Card card){
            switch(card.getSign()){
                case Hearts:
                    return 0.1;
                case Spades:
                    return 0.2;
                case Diamonds:
                    return 0.3;
                case Clubs:
                    return 0.4;
            }
            return 0;
        }
        
    
        @Override
        public int compare(Card card1, Card card2) {
            return Double.compare(getNumberValue(card2) + getSignValue(card2),getNumberValue(card1) + getSignValue(card1));
        } 
    }

    public static void simulateRound(LinkedHashMap<Integer,Player> playerList){
        Table table = new Table();

        table.getCardFromPlayerList(getInGamePlayerList(playerList));

        System.out.println(table.getWinningPlayers());

        while(table.getWinningPlayers().size()>1){
            LinkedList<Player> warPlayerList = new LinkedList<>();
            warPlayerList.addAll(table.getWinningPlayers());
            table.clearTable();

            table.getCardFromPlayerList(warPlayerList);
            
        }
        table.giveCardsToPlayer(table.getWinningPlayers().get(0));
        

        displayHands(playerList);

    }

    public static Set<Integer> getIndexOfPlayersInGame(LinkedHashMap<Integer,Player> playerList){
                return playerList.keySet();
    }


    public static void checkAndUpdatePlayersInGame(LinkedHashMap<Integer,Player> playerList) {
        
            Object[] playerIndexArray = playerList.keySet().toArray();

            for(int i=0;i<playerIndexArray.length;i++)
            {
                if(playerList.get(playerIndexArray[i]).handIsEmpty())
                    playerList.remove(playerIndexArray[i]);
            }

        }

    public static LinkedHashMap<Integer,Player> createPlayerList(int nrPlayers){
        LinkedHashMap<Integer,Player> playerList = new LinkedHashMap<>();
        for(int i=0;i<nrPlayers;i++)
            playerList.put(i,new Player(i));
        return playerList;
    }

    public static LinkedList<Player> getInGamePlayerList(LinkedHashMap<Integer,Player> playerMap){
        LinkedList<Player> playerList = new LinkedList<>();
        playerMap.forEach((i,player)->{
            playerList.add(player);
        });

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

        Deck deck = Deck.createStandard52CardDeck();
        deck.shuffleDeck();

        dealCards(playerList,deck);

        displayHands(playerList);

    //     for(int i=0;i<10;i++){

    //     System.out.println("_______________________________");
    //     checkAndUpdatePlayersInGame(playerList);
    //     simulateRound(playerList);
        

    // }




        long start = System.currentTimeMillis();
        long end = start + 5 * 1000;

        while (System.currentTimeMillis() < end) {
            System.out.println("_______________________________");
            checkAndUpdatePlayersInGame(playerList);
            simulateRound(playerList);
            if(getIndexOfPlayersInGame(playerList).size()==1)
                break;
        }

        System.out.println("@@@@@@@@@@@@@@@@@@END@@@@@@@@@@@@@@@@@@@@@");

    }

}
