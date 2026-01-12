package org.example.snakesAndLadders.models;

import lombok.Builder;
import lombok.Getter;

import java.util.Map;

@Getter
@Builder
public class Board {
    private Cell[] cells;

    private int size;

    public static Board createBoard(int size, Map<Integer, Obstacle> startNumberToObstacleMap) {
        Cell[] cells = new Cell[size+1];

        for (int i = 1; i <= size; i++) {
            if(startNumberToObstacleMap.containsKey(i)) {
                cells[i] = new Cell(i, startNumberToObstacleMap.get(i));
            }
            else {
                cells[i] = new Cell(i);
            }
        }

        return Board.builder()
                .cells(cells)
                .size(size)
                .build();
    }

    public Cell getCell(int x) {
        return cells[x];
    }
}
