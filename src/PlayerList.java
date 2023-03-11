import java.util.LinkedList;

public class PlayerList {

    LinkedList<Player> playerList = new LinkedList<>();

    public PlayerList(){
        this.playerList = new LinkedList<>();
    }

    public Player getPlayerByIndex(int index){
        for(Player player : this.playerList)
            if(player.getIndex()==index)
                return player;
        return null;
    }

    public void addPlayer(int index){
        this.playerList.add(new Player(index));
    }

    public int size(){
        return playerList.size();
    }

    public void displayHands(){
        for(Player player : playerList)
            player.displayPlayerHand();
    }

    public LinkedList<Integer> indexOfPlayersInGame(){
        LinkedList<Integer> inGame = new LinkedList<>();
        for(Player player : this.playerList){
            inGame.add(player.getIndex());
        }
        return inGame;
    }

    public void eliminatePlayers(LinkedList<Integer> inGame){
        for(int i=0;i<inGame.size();i++){
            if(getPlayerByIndex(inGame.get(i)).handIsEmpty()==true) {
                this.playerList.remove(getPlayerByIndex(inGame.get(i)));
                inGame.remove(i);
                i--;
            }
        }
    }
}
