import java.util.LinkedList;

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

    public LinkedList<Integer> getWinners(){
        LinkedList<Integer> winnerIndex = new LinkedList<>();
        int max = getMax();

        for(PlayedCard pc : this.cards)
            if(pc.getPower()==max)
                winnerIndex.add(pc.index);
        return winnerIndex;
    }

    public void addCardsFromTable(Table table){
        this.cards.addAll(table.cards);
    }

    public void getCardsFromPlayers(PlayerList playerList,LinkedList<Integer> inGame){
        for(Integer i : inGame)
            addCardFromPlayer(playerList.getPlayerByIndex(i));
    }
}
