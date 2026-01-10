package org.example.tictactoe.models;

import lombok.Getter;

@Getter
public class Board {
    private Cell[][] cells;

    public Board(int boardSize) {
        cells = new Cell[boardSize][boardSize];
        for(int i=0;i<boardSize;i++) {
            for(int j=0;j<boardSize;j++) {
                cells[i][j] = new Cell(new Position(i,j));
            }
        }
    }

    public Cell getCell(Position position) {
        return cells[position.getI()][position.getJ()];
    }
}
