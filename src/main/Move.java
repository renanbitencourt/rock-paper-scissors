package main;

public enum Move {

    ROCK("R", "S"),
    PAPER("P", "R"),
    SCISSORS("S", "P");

    private String value;
    private String wins;

    Move(String value, String wins) {
        this.value = value;
        this.wins = wins;
    }

    public String toValue() {
        return this.value;
    }

    public boolean wins(Move move) {
        return this.wins.equalsIgnoreCase(move.toValue());
    }

    public boolean tiesWith(Move move) {
        return this.value.equalsIgnoreCase(move.toValue());
    }

}
