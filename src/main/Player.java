package main;

public class Player {

    private String name;
    private Move move;

    public Player(String name, Move move) {
        this.name = name;
        this.move = move;

        if (this.move == null) {
            throw new NoSuchStrategyError();
        }
    }

    public String getName() {
        return this.name;
    }

    public Move getMove() {
        return this.move;
    }
}
