package main;

public class Tournament {

    private Key firstKey;
    private Key secondKey;

    public Tournament(Key firstKey, Key secondKey) {
        this.firstKey = firstKey;
        this.secondKey = secondKey;
    }

    public Player rpsTournamentWinner() {
        return new Game(firstKey.rpsKeyWinner(), secondKey.rpsKeyWinner()).rpsGameWinner();
    }

}
