package main;

public class Key {

    private Game firstGame;
    private Game secondGame;

    public Key(Game firstGame, Game secondGame) {
        this.firstGame = firstGame;
        this.secondGame = secondGame;
    }

    public Player rpsKeyWinner() {
        return new Game(firstGame.rpsGameWinner(), secondGame.rpsGameWinner()).rpsGameWinner();
    }

}
