package org.example.tictactoe.models;

import lombok.Builder;
import org.example.tictactoe.factories.BotStrategyFactory;
import org.example.tictactoe.strategies.IBotStrategy;

public class BotPlayer extends Player{
    private IBotStrategy botStrategy;
    private DifficultyLevel level;

    @Builder
    public BotPlayer(Symbol symbol, DifficultyLevel level) {
        super(symbol);
        this.level = level;
        this.botStrategy = BotStrategyFactory.getBotStrategy(level);
    }

    @Override
    public Position play(Board board, Position position) {
        position = botStrategy.getPosition(board, this.symbol);
        return super.play(board, position);
    }
}
