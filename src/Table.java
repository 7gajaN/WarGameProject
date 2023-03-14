import java.util.*;

public class Table {

    CardComparator cardComparator = new CardComparator();

    TreeMap<Card,Player> cards; 

    Deck cardsInOrder;

    public Table(){
        cards = new TreeMap<Card,Player>(cardComparator);
        cardsInOrder = new Deck();
    }

    public TreeMap<Card,Player> getCards() {
        return cards;
    }

    public void addCardFromPlayer(Player player){
        Card card = player.hand.getTopCard();
       this.cards.put(card,player);
       this.cardsInOrder.addCardToBottom(card);
    }

    public void clearTable(){
        this.cards.clear();
    }


    public LinkedList<Player> getWinningPlayers(){
        Set cardSet = new TreeSet(cardComparator);
        cardSet.addAll(this.cards.keySet());
        Iterator<Card> itr = cardSet.iterator();
        Card topCard = itr.next();

        while(itr.hasNext())
            if(!topCard.getNumber().equals(itr.next().getNumber()))
                itr.remove();

        LinkedList<Player> winnersList = new LinkedList<>();
        itr = cardSet.iterator();

        while(itr.hasNext()){
            winnersList.add(this.cards.get(itr.next()));
        }

        return winnersList;
    }

    public void getCardFromPlayerList(LinkedList<Player> playerList){
        for(Player player : playerList)
            addCardFromPlayer(player);
    }

    public void giveCardsToPlayer(Player player){
        player.appendCards(cardsInOrder);
    }


    }

