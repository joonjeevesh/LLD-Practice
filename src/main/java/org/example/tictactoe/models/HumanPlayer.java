package org.example.tictactoe.models;

import lombok.Builder;
import lombok.Getter;

@Getter
public class HumanPlayer extends Player{
    private HumanProfile profile;

    @Builder
    public HumanPlayer(Symbol symbol, HumanProfile profile) {
        super(symbol);
        this.profile = profile;
    }
}
