public class PlayedCard extends Card {
    int index;
    public PlayedCard(Card card, int index){
        super(card.getNumber(), card.getSign(), card.getPower());
        this.index = index;
    }

}
