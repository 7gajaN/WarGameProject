import java.util.LinkedHashMap;
import java.util.LinkedList;

public class Dealer {
    Deck dealerDeck;

    public Dealer(Deck dealerDeck){
        this.dealerDeck = dealerDeck;
    }

    public void dealCards(LinkedHashMap<Integer,Player> playerList){

        int j=0;
        int deckSize = dealerDeck.getDeckSize();
        for(int i=0;i< deckSize;i++){
            if(j==playerList.size())
                j=0;
            playerList.get(j).getHand().addCardToTop(dealerDeck.getTopCard());
            j++;
        }
    }
}
