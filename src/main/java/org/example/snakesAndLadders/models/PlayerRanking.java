package org.example.snakesAndLadders.models;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PlayerRanking {
    private String playerName;

    private int rank;
}
