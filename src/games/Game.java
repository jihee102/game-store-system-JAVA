package games;

public abstract class Game {
    private int number;
    private static int count=1;
    private String name;
    private int numberOfPlayers;

    public Game(String gName, int gNrOfPlayers){
        this.number = count;
        count++;
        this.name = gName;
        this.numberOfPlayers = gNrOfPlayers;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    public int getNumberOfPlayers() {
        return numberOfPlayers;
    }

    @Override
    public String toString(){
        return number +". "+name +" (" +numberOfPlayers+" players)";
    }
}
