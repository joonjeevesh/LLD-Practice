package org.example.tictactoe.models;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import org.example.tictactoe.strategies.IWinningStrategy;
import java.util.List;
import java.util.Stack;

@Getter
public class Game {
    private Board board;
    private List<Player> players;
    private IWinningStrategy winningStrategy;
    @Getter(AccessLevel.NONE)
    private int totalMovesLeft;
    @Getter(AccessLevel.NONE)
    private Stack<Position> undoStack;

    @Builder
    public Game(List<Player> players, int boardSize, IWinningStrategy winningStrategy) {
        this.board = new Board(boardSize);
        this.players = players;
        this.winningStrategy = winningStrategy;
        this.totalMovesLeft = boardSize*boardSize;
        undoStack = new Stack<>();
    }

    //this method is used when bot player moves
    public Outcome move(Player player) {
        return move(player, null);
    }

    public Outcome move(Player player, Position position) {
        Position played = player.play(this.board, position);
        undoStack.push(played);
        this.totalMovesLeft--;
        return checkOutcome(player.getSymbol());
    }

    public Position undo() {
        Position lastPlayed = undoStack.pop();
        totalMovesLeft++;
        return lastPlayed;
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
