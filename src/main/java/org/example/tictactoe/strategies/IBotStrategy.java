package org.example.tictactoe.strategies;

import org.example.tictactoe.models.Board;
import org.example.tictactoe.models.Position;
import org.example.tictactoe.models.Symbol;

public interface IBotStrategy {
    public Position getPosition(Board board, Symbol symbol);
}
