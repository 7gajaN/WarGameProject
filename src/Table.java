import java.util.*;

public class Table {

    HashMap<Integer,Card> cards;

    public Table(){
        cards = new LinkedHashMap<>();
    }

    public HashMap<Integer,Card> getCards() {
        return cards;
    }

    public void addCardFromPlayer(Player player){
       this.cards.put(player.index, player.hand.getTopCard());
    }

    public void clearTable(){
        this.cards.clear();
    }

    public int getMax(){
        final int[] max = {0};
        this.cards.forEach((i,pc)->{
            if(pc.getPower()> max[0])
                max[0] =pc.getPower();
        });

    return max[0];
    }

    public Set<Integer> getWinners(){
        Set<Integer> winnerIndex = new HashSet<Integer>();
        int max = getMax();

        this.cards.forEach((i,pc)->{
            if(pc.getPower()==max)
                winnerIndex.add(i);
        });
        return winnerIndex;
    }

    public void addCardsFromTable(Table table){
        this.cards.putAll(table.cards);
    }

    public void getCardsFromPlayers(LinkedHashMap<Integer,Player> playerList, Set<Integer> inGame){
        Object[] inGameArray = inGame.toArray();
        for(int i=0;i<inGameArray.length;i++)
            addCardFromPlayer(playerList.get(inGameArray[i]));
        }
    }

