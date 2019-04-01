package main;

public class NoSuchStrategyError extends RuntimeException {

    public NoSuchStrategyError() {
        super("The move is invalid!");
    }

}
