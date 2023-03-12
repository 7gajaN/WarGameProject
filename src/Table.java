import java.util.*;

public class Table {

    LinkedList<PlayedCard> cards;

    public Table(){
        cards = new LinkedList<>();
    }

    public LinkedList<PlayedCard> getCards() {
        return cards;
    }

    public void addCardFromPlayer(Player player){
       this.cards.addLast(new PlayedCard(player.hand.getTopCard(), player.index));
    }

    public void clearTable(){
        this.cards.clear();
    }

    public int getMax(){
        int max = 0;
        for(PlayedCard pc : this.cards)
            if(pc.getPower()>max)
                max=pc.getPower();

    return max;
    }

    public Set<Integer> getWinners(){
        Set<Integer> winnerIndex = new HashSet<Integer>();
        int max = getMax();

        for(PlayedCard pc : this.cards)
            if(pc.getPower()==max)
                winnerIndex.add(pc.index);
        return winnerIndex;
    }

    public void addCardsFromTable(Table table){
        this.cards.addAll(table.cards);
    }

    public void getCardsFromPlayers(LinkedHashMap<Integer,Player> playerList, Set<Integer> inGame){
        Object[] inGameArray = inGame.toArray();
        for(int i=0;i<inGameArray.length;i++)
            addCardFromPlayer(playerList.get(inGameArray[i]));
        }
    }

