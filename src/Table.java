import java.util.ArrayList;

public class Table {

    ArrayList<PlayedCard> cards;


    public Table(ArrayList<PlayedCard> cards){
        this.cards = cards;
    }

    public static Table populateTable(ArrayList<Player> playerHands, ArrayList<Integer> inGame){
       ArrayList<PlayedCard> cards = new ArrayList<PlayedCard>();
       for(int i=0;i<inGame.size();i++) {
           cards.add(new PlayedCard(playerHands.get(inGame.get(i)).getHand().get(0).number, playerHands.get(inGame.get(i)).getHand().get(0).sign, playerHands.get(inGame.get(i)).getHand().get(0).power, playerHands.get(inGame.get(i)).getIndex()));
           playerHands.get(i).getHand().remove(0);
       }

       Table table = new Table(cards);

       return table;
    }

}
