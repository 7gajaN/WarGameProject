import java.util.Comparator;

public class CardComparator implements Comparator<Card>{
    
    public double getNumberValue(Card card){
        switch(card.getNumber()){
            case Two:
                return 1;
            case Three:
                return 2;
            case Four:
                return 3;
            case Five:
                return 4;
            case Six:
                return 5;
            case Seven:
                return 6;
            case Eight:
                return 7;
            case Nine:
                return 8;
            case Ten:
                return 9;
            case Jack:
                return 10;
            case Queen:
                return 11;
            case King:
                return 12;
            case Ace:
                return 13;
        }
        return 0;
    }

    public double getSignValue(Card card){
        switch(card.getSign()){
            case Hearts:
                return 0.1;
            case Spades:
                return 0.2;
            case Diamonds:
                return 0.3;
            case Clubs:
                return 0.4;
        }
        return 0;
    }
    

    @Override
    public int compare(Card card1, Card card2) {
        return Double.compare(getNumberValue(card2) + getSignValue(card2),getNumberValue(card1) + getSignValue(card1));
    } 
}