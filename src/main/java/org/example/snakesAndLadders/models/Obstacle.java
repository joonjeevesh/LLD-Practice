package org.example.snakesAndLadders.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.example.snakesAndLadders.enums.ObstacleType;

@Getter
@AllArgsConstructor
@Builder
public class Obstacle {
    private int start;

    private int end;

    private ObstacleType type;
}
