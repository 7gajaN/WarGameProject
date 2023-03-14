import java.util.LinkedList;
import java.util.Collections;

public class Deck {
    LinkedList<Card> cards;

    public Deck(){
        this.cards = new LinkedList<>();
    }

    public Card getTopCard(){
        Card aux = this.cards.getLast();
        this.cards.removeLast();
        return aux;
    }

    public void addCardToTop(Card card){
        this.cards.addLast(card);
    }

    public void addCardToBottom(Card card){
        this.cards.addFirst(card);
    }

    public static Deck createStandard52CardDeck(){
        Deck deck = new Deck();

        for(Card.Numbers number : Card.Numbers.values())
            for(Card.Signs sign : Card.Signs.values())
                deck.addCardToBottom(new Card(number,sign));


        return deck;
    }

    public void shuffleDeck(){
        Collections.shuffle(this.cards);
    }

    public void displayDeck(){
        for(Card card : this.cards)
            System.out.print(card.getNumber() + " of "+ card.getSign()+ " // ");
    }

    public int getDeckSize(){
        return this.cards.size();
    }

}
