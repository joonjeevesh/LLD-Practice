package org.example.tictactoe.models;

import lombok.Builder;
import lombok.Getter;

@Getter
public class Cell {
    private Symbol symbol;

    private Position position;

    public Cell(Position position) {
        this.position = position;
        this.symbol = null;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }
}
