package org.example.tictactoe.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public abstract class Player {
    protected Symbol symbol;

    public void play(Symbol[][] board, Position position) {
        board[position.getI()][position.getJ()] = this.symbol;
    }
}
