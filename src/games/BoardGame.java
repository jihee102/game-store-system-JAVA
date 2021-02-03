package games;

import java.util.ArrayList;

public class BoardGame extends Game{
    private String publisher;
    private ArrayList<Expansion> expansions = new ArrayList<>();

    public BoardGame(String gName, int gNrOfPlayers, String gPublisher){
        super(gName,gNrOfPlayers);
        this.publisher = gPublisher;
    }

    public String getPublisher() {
        return publisher;
    }

    public void addExpansion(String eName, boolean eCanPlayedStandalone){
        Expansion expansion = new Expansion(eName,eCanPlayedStandalone);
        expansions.add(expansion);
    }

    @Override
    public String toString(){
        String output = "Boardgame: ";
        output+= super.toString()+ ", published by "+publisher+"\n";
        if(expansions.size() != 0){
            output+= "  Expansions: \n";
            for(Expansion ep : expansions){
                output+= "    "+ep+"\n";
            }
        }
        return output;
    }
}
