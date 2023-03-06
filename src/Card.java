import java.lang.reflect.Array;
import java.util.ArrayList;

public class Card {
    String number;
    String sign;

    int power;

    public String getNumber() {
        return number;
    }

    public String getSign() {
        return sign;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public Card(String number, String sign, int power){
        this.number = number;
        this.sign = sign;
        this.power = power;
    }

    public static ArrayList<Card> getDeck(){
        String[] signs = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] numbers = {"Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King", "Ace"  };
        ArrayList<Card> deck = new ArrayList<Card>();

        for(String sign: signs)
            for (int i=1;i<=13;i++){
                deck.add(new Card(numbers[i-1], sign, i));
            }
        return deck;
    }

}
