package org.example.snakesAndLadders;

import org.example.snakesAndLadders.enums.ObstacleType;
import org.example.snakesAndLadders.enums.PieceStatus;
import org.example.snakesAndLadders.enums.PlayerStatus;
import org.example.snakesAndLadders.models.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class GameTest {

    private Game game;

    @Before
    public void setup() {
        this.game = Game.createGame(10, 6, 2,
                Arrays.asList(new PlayerRequest("Jebo", Color.BLACK), new PlayerRequest("Bob", Color.WHITE)),
                Arrays.asList(new Obstacle(2, 10, ObstacleType.LADDER)));
    }

    @Test
    public void pieceStatusCheck() {
        game.move(game.getPlayers().get(0), game.getPlayers().get(0).getPieces().get(0), 1);
        Assert.assertEquals("Piece should have climbed ladder and reached", game.getPlayers().get(0).getPieces().get(0).getStatus(), PieceStatus.REACHED);
    }

    @Test
    public void playerStatusCheck() {
        game.move(game.getPlayers().get(0), game.getPlayers().get(0).getPieces().get(0), 1);
        PlayerStatus status = game.move(game.getPlayers().get(0), game.getPlayers().get(0).getPieces().get(1), 1);
        Assert.assertEquals("Player should have WON", status, PlayerStatus.WON);
    }
}
