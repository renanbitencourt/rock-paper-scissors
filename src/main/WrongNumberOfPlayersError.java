package main;

public class WrongNumberOfPlayersError extends RuntimeException {

    public WrongNumberOfPlayersError() {
        super("The game must have two players!");
    }

}
