public class PlayedCard extends Card{

    int playerIndex;

    public int getPlayerIndex() {
        return playerIndex;
    }

    public void setPlayerIndex(int playerIndex) {
        this.playerIndex = playerIndex;
    }

    public PlayedCard(String number, String sign, int power, int playerIndex) {
        super(number, sign, power);
        this.playerIndex = playerIndex;
    }
}
