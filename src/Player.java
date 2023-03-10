import java.util.ArrayList;

public class Player {
    int index;
    ArrayList<Card> hand;

    public int getIndex() {
        return index;
    }

    public ArrayList<Card> getHand() {
        return hand;
    }

    public void setHand(ArrayList<Card> hand) {
        this.hand = hand;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public void displayHand(Player player){
        for(Card card : player.hand)
            System.out.print(card.getNumber() + " of " + card.getSign() + " // ");
        System.out.println();
    }

    public Player(int index, ArrayList<Card> hand){
        this.index = index;
        this.hand = hand;

    }

}
