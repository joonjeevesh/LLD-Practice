package org.example.tictactoe.strategies;

import org.example.tictactoe.models.Board;
import org.example.tictactoe.models.Symbol;

//if board size is n, symbol n times across any row/column/any of the 2 diagonals
public class StandardWinningStrategy implements IWinningStrategy{

    @Override
    public boolean check(Board board, Symbol symbol) {
        return false;
    }
}
