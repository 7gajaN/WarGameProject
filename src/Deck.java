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

    public void createDeck(){
        String[] signs = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] numbers = {"Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King", "Ace"  };

        for(String sign: signs)
            for (int i=1;i<=13;i++){
                this.cards.add(new Card(numbers[i-1], sign));
            }
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
