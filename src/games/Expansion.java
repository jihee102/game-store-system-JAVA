package games;

import org.json.JSONObject;

public class Expansion {
    private String expansionName;
    private boolean canPlayedStandalone;

    public Expansion(String eName, boolean eCanPlayedStandalone){
        this.expansionName = eName;
        this.canPlayedStandalone = eCanPlayedStandalone;
    }

    public Expansion(JSONObject jo){
        this.expansionName = jo.getString("name");
        this.canPlayedStandalone = jo.getBoolean("canPlayedStandalone");
    }

    public String getExpansionName() {
        return expansionName;
    }

    public boolean isCanPlayedStandalone() {
        return canPlayedStandalone;
    }

    @Override
    public String toString(){
        String output = expansionName;
        if(canPlayedStandalone){
            output += " (Can be played standalone)";
        }
        return output;
    }
}
