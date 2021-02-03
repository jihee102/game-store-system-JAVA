import exceptions.GameException;
import games.*;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class GameAdmin {
    private ArrayList<Game> games = new ArrayList<>();

    public GameAdmin (){};

    public Game findGameByName(String name){
        for(Game game : games){
            if(game.getName().equals(name)){
                return game;
            }
        }
        return null;
    }

    public void addBoardGame(String gName, int gNrOfPlayers, String gPublisher) throws GameException{
        if(findGameByName(gName) != null){
            throw new GameException("Game already exists");
        }
        BoardGame boardGame = new BoardGame(gName,gNrOfPlayers,gPublisher);
        games.add(boardGame);
    }

    public void addCardGame(String gName, int gNrOfPlayers, int gNrOfCards) throws GameException{
        if(findGameByName(gName) != null){
            throw new GameException("Game already exists");
        }
        CardGame cardGame = new CardGame(gName,gNrOfPlayers,gNrOfCards);
        games.add(cardGame);
    }

    public void addBoardGameExpansion(String name, String eName, boolean eCanPlayedStandalone) throws GameException{
        Game g = findGameByName(name);
        if(g != null){
            if(g instanceof BoardGame){
                ((BoardGame) g).addExpansion(eName,eCanPlayedStandalone);
            }else{
                throw new GameException("Only board game can have expansion");
            }
        }else{
            throw new GameException("Game not found");
        }
    }

    public void loadFile(String name, String file) throws IOException,GameException {
        String jsonString = new String(Files.readAllBytes(Paths.get(file)));
        JSONArray jsonArray = new JSONArray(jsonString);
        for (int i = 0; i <jsonArray.length() ; i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            addBoardGameExpansion(name,jsonObject.getString("name"),jsonObject.getBoolean("canPlayedStandalone"));

        }
    }

    public String printGames(){
        String output = "";
        for(Game g :games){
            output+=g.toString()+"\n";
        }
        return output;
    }

}
