import exceptions.GameException;

import java.io.IOException;

public class Aplication {

    public static void main(String[] args) {
        GameAdmin admin = new GameAdmin();
        try{
            admin.addBoardGame("Flash Point", 6, "999 games");
            admin.addBoardGameExpansion("Flash Point", "Dangerous Waters", false);

            admin.addBoardGame("Ticket to Ride", 5, "Days of Wonder");
        } catch (GameException e) {
            System.out.println(e);
        }

        try {
            admin.loadFile("Ticket to Ride","expansions.json");
        } catch (GameException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        }

        try{
            admin.addCardGame("Poker", 4, 52);
            admin.addCardGame("Codenames", 8, 200);
        } catch (GameException e) {
            System.out.println(e);
        }

        System.out.println(admin.printGames());


    }
}
