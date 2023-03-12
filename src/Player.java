import java.util.HashMap;
import java.util.LinkedList;

public class Player {
    int index;
    Deck hand;

    public Deck getHand() {
        return hand;
    }


    public int getIndex() {
        return index;
    }

    public Player(int index){
        this.index = index;
        hand = new Deck();
    }

    public void displayPlayerHand(){
        System.out.print("Player " + this.index + " [ ");
        for(Card card : this.getHand().cards)
            System.out.print(card.getNumber() + " of " + card.getSign() + " // ");
        System.out.println();
    }

    public void appendCards(HashMap<Integer,Card> cards){
        cards.forEach((i,pc)->{
            this.hand.addCardToBottom(pc);
        });
    }

    public boolean handIsEmpty(){
        return this.hand.cards.isEmpty();
    }
}
