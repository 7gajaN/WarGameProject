import java.util.LinkedList;

public class Player {
    int index;
    Deck hand;

    public Deck getHand() {
        return hand;
    }

    public void setHand(Deck hand) {
        this.hand = hand;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
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

    public void appendCards(LinkedList<PlayedCard> cards){
        for(PlayedCard pc :cards)
            this.hand.addCardToBottom(new Card(pc.getNumber(),pc.getSign(),pc.getPower()));
    }

    public boolean handIsEmpty(){
        return this.hand.cards.isEmpty();
    }
}
