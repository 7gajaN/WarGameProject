import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        ArrayList<Card> deck = Card.getDeck();

        Collections.shuffle(deck);

        Game.startGame(8,deck);


    }
}
