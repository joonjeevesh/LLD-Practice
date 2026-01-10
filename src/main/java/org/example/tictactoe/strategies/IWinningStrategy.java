package org.example.tictactoe.strategies;

import org.example.tictactoe.models.Board;
import org.example.tictactoe.models.Symbol;

public interface IWinningStrategy {
    public boolean check(Board board, Symbol symbol);
}
