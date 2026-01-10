package org.example.tictactoe.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public abstract class Player {
    protected Symbol symbol;

    public Position play(Board board, Position position) {
        board.getCell(position).setSymbol(this.symbol);
        return position;
    }
}
