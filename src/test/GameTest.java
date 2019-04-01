package test;

import main.*;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static main.Move.PAPER;
import static main.Move.ROCK;
import static main.Move.SCISSORS;
import static org.junit.Assert.assertThat;

public class GameTest {

    @Test(expected = NoSuchStrategyError.class)
    public void whenMoveIsNotValidThenRaiseError() {
        Game game = new Game(
                new Player("Jeff", ROCK),
                new Player("Richard", null)
        );

        game.rpsGameWinner();
    }

    @Test(expected = WrongNumberOfPlayersError.class)
    public void whenNumberOfPlayersIsInvalidThenRaiseError() {
        Game game = new Game(
                new Player("Jeff", ROCK),
                null
        );

        game.rpsGameWinner();
    }

    @Test
    public void whenFirstPlayersMoveIsRockAndSecondPlayersMoveIsScissorsThenReturnFirstPlayer() {
        Game game = new Game(
                        new Player("Richard", ROCK),
                        new Player("Alan", SCISSORS)
        );

        assertThat(game.rpsGameWinner().getName(), CoreMatchers.equalTo("Richard"));
    }

    @Test
    public void whenFirstPlayersMoveIsPaperAndSecondPlayersMoveIsScissorsThenReturnSecondPlayer() {
        Game game = new Game(
                new Player("Richard", PAPER),
                new Player("Alan", SCISSORS)
        );

        assertThat(game.rpsGameWinner().getName(), CoreMatchers.equalTo("Alan"));
    }

    @Test
    public void whenFirstPlayersMoveIsPaperAndSecondPlayersMoveIsRockThenReturnFirstPlayer() {
        Game game = new Game(
                new Player("Richard", PAPER),
                new Player("Alan", ROCK)
        );

        assertThat(game.rpsGameWinner().getName(), CoreMatchers.equalTo("Richard"));
    }

    @Test
    public void whenFirstPlayersMoveIsEqualToSecondPlayersMoveThenReturnFirstPlayer() {
        Game game = new Game(
                new Player("Richard", ROCK),
                new Player("Alan", ROCK)
        );

        assertThat(game.rpsGameWinner().getName(), CoreMatchers.equalTo("Richard"));
    }

    @Test
    public void tournamentHappyDay() {
        Game game = new Game(
                new Player("Armando", PAPER),
                new Player("Dave", SCISSORS)
        );

        Game game2 = new Game(
                new Player("Richard", ROCK),
                new Player("Michael", SCISSORS)
        );

        Game game3 = new Game(
                new Player("Allen", SCISSORS),
                new Player("Omer", PAPER)
        );

        Game game4 = new Game(
                new Player("David E.", ROCK),
                new Player("Richard X.", PAPER)
        );

        Key key = new Key(game, game2);
        Key key2 = new Key(game3, game4);

        Tournament tournament = new Tournament(key, key2);
        assertThat(tournament.rpsTournamentWinner().getName(), CoreMatchers.equalTo("Richard"));
    }

}