import java.util.ArrayList;

public class PlayerHands {

    public static boolean isMultiple(int a, int b) {
        if (a % b == 0) {
            return true;
        } else {
            return false;
        }
    }
    ArrayList<Player> player;

    public ArrayList<Player> getPlayer() {
        return player;
    }

    public void setPlayer(ArrayList<Player> player) {
        this.player = player;
    }

    public PlayerHands(ArrayList<Player> player){
        this.player = player;
    }

    public static void dealCards(ArrayList<Card>deck,int players){
        ArrayList<Player> playerHand = new ArrayList<Player>();
        for(int i=0;i<players;i++){
            playerHand.add(new Player(i,new ArrayList<Card>()));
        }

        int cardCounter = 0;
        int playerIndex = 0;
    try {
        while (cardCounter <= 51 - 52 % players) {
            for (Card card : deck) {
                cardCounter++;
                playerHand.get(playerIndex).getHand().add(card);
                if (isMultiple(cardCounter, 52 / players)) {
                    playerIndex++;
                }
            }
        }
    }catch (Exception e){

    }

        for(Player player : playerHand)
            player.displayHand(player);

        ArrayList<Integer> test = new ArrayList<>();
        for(int i=0;i<playerHand.size();i++)
            test.add(i);


        System.out.println(Game.getWinner(Table.populateTable(playerHand,test),test));

    }
}
