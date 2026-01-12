package org.example.snakesAndLadders.models;

import lombok.Getter;

@Getter
public class Cell {
    private int number;

    private Obstacle obstacle;

    public Cell(int number) {
        this.number = number;
    }

    public Cell(int number, Obstacle obstacle) {
        this.number = number;
        this.obstacle = obstacle;
    }
}
