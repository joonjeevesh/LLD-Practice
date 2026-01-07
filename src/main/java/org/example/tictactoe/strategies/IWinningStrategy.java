package org.example.tictactoe.strategies;

import org.example.tictactoe.models.Symbol;

public interface IWinningStrategy {
    public boolean check(Symbol[][] board, Symbol symbol);
}
