package org.example.tictactoe.models;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import org.example.tictactoe.strategies.IWinningStrategy;

import java.util.List;

@Getter
public class Game {
    private Symbol[][] board;
    private List<Player> players;
    private IWinningStrategy winningStrategy;
    @Getter(AccessLevel.NONE)
    private int totalMovesLeft;

    @Builder
    public Game(List<Player> players, int boardSize, IWinningStrategy winningStrategy) {
        this.board = new Symbol[boardSize][boardSize];
        this.players = players;
        this.winningStrategy = winningStrategy;
        this.totalMovesLeft = boardSize*boardSize;
    }

    //this method is used when bot player moves
    public Outcome move(Player player) {
        return move(player, null);
    }

    public Outcome move(Player player, Position position) {
        player.play(this.board, position);
        this.totalMovesLeft--;
        return checkOutcome(player.getSymbol());
    }

    private Outcome checkOutcome(Symbol symbol) {
        if(winningStrategy.check(this.board, symbol)) {
            return Outcome.WIN;
        }

        if(this.totalMovesLeft == 0) {
            return Outcome.DRAW;
        }

        return Outcome.NONE;
    }
}
