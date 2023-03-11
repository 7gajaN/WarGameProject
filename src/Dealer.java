

public class Dealer {
    Deck dealerDeck;

    public Dealer(Deck dealerDeck){
        this.dealerDeck = dealerDeck;
    }

    public PlayerList dealCards(int nrPlayers){
        PlayerList playerList = new PlayerList();

        for(int i=0;i<nrPlayers;i++)
            playerList.addPlayer(i);

        int j=0;
        for(int i=0;i<52;i++){
            if(j==nrPlayers)
                j=0;
            playerList.getPlayerByIndex(j).getHand().addCardToTop(dealerDeck.getTopCard());
            j++;
        }
        return playerList;
    }
}
