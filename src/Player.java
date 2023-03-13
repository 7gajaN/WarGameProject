

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

    public void appendCards(Deck cards){
        for(int i=cards.cards.size()-1;i>=0;i--)
            this.hand.addCardToBottom(cards.cards.get(i));
    }

    public boolean handIsEmpty(){
        return this.hand.cards.isEmpty();
    }
}
