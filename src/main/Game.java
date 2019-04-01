package main;

public class Game {

    private Player playerOne;
    private Player playerTwo;

    public Game(Player playerOne, Player playerTwo) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;

        if (playerOne == null || playerTwo == null) {
            throw new WrongNumberOfPlayersError();
        }
    }

    public Player rpsGameWinner() {
        Move firstPlayerMove = playerOne.getMove();
        Move secondPlayerMove = playerTwo.getMove();

        return firstPlayerMove.tiesWith(secondPlayerMove) || firstPlayerMove.wins(secondPlayerMove)
                ? playerOne : playerTwo;
    }

}
