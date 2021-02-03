package games;

public class CardGame extends Game {
    private int numberOfCards;

    public CardGame(String gName, int gNrOfPlayers, int gNrOfCards){
        super(gName, gNrOfPlayers);
        this.numberOfCards = gNrOfCards;
    }

    public int getNumberOfCards() {
        return numberOfCards;
    }

    @Override
    public String toString(){
        String output = "Cardgame: ";
        output+= super.toString()+", has "+numberOfCards+" cards";
        return output;
    }
}
