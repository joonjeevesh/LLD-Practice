package org.example.tictactoe;

import org.example.tictactoe.factories.PlayerFactory;
import org.example.tictactoe.models.*;
import org.example.tictactoe.strategies.StandardWinningStrategy;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class TicTacToeTest {
    private Game game;
    private Player humanPlayer;

    @Before
    public void setup() {
        this.humanPlayer = PlayerFactory.createHumanPlayer()
                .symbol(Symbol.O)
                .profile(HumanProfile.builder()
                        .id(1)
                        .name("Jeevesh")
                        .email("jeevesh@j.com")
                        .photo(new byte[1000])
                        .build())
                .build();

        Player botPlayer = PlayerFactory.createBotPlayer()
                .symbol(Symbol.X)
                .level(DifficultyLevel.MEDIUM)
                .build();

        this.game = Game.builder()
                .boardSize(3)
                .players(List.of(humanPlayer, botPlayer))
                .winningStrategy(new StandardWinningStrategy())
                .build();
    }

    @Test
    public void boardSizeIsCorrect() {
        assertEquals("Board size mismatch", 3, this.game.getBoard().getCells().length);
    }

    @Test
    public void playerMovesCorrectly() {
        game.move(humanPlayer, new Position(1, 1));
        assertEquals("Player does not move as expected", game.getBoard().getCells()[1][1].getSymbol(), humanPlayer.getSymbol());
    }

    @Test
    public void undoStack() {
        Position toPlay = new Position(1, 1);
        game.move(humanPlayer, toPlay);
        assertEquals("Undo works as expected", game.undo(), toPlay);
    }
}