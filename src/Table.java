import java.util.ArrayList;

public class Table {

    ArrayList<PlayedCard> cards;

    public ArrayList<PlayedCard> getCards() {
        return cards;
    }

    public void setCards(ArrayList<PlayedCard> cards) {
        this.cards = cards;
    }

    public Table(ArrayList<PlayedCard> cards){
        this.cards = cards;
    }

    public static Table populateTable(ArrayList<Player> playerHands, ArrayList<Integer> inGame){
       ArrayList<PlayedCard> cards = new ArrayList<PlayedCard>();
       for(int i=0;i<inGame.size();i++) {
           for(Player player : playerHands){
               if(player.getIndex()==inGame.get(i))
               {
                   cards.add(new PlayedCard(player.getHand().get(0).number,player.getHand().get(0).sign,player.getHand().get(0).power,inGame.get(i)));
                   player.getHand().remove(0);
               }
           }
       }

       Table table = new Table(cards);

       return table;
    }

}
