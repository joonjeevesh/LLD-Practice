package org.example.tictactoe.factories;

import org.example.tictactoe.models.DifficultyLevel;
import org.example.tictactoe.strategies.EasyBot;
import org.example.tictactoe.strategies.HardBot;
import org.example.tictactoe.strategies.IBotStrategy;
import org.example.tictactoe.strategies.MediumBot;

public class BotStrategyFactory {
    public static IBotStrategy getBotStrategy(DifficultyLevel level) {
        switch (level) {
            case EASY:
                return new EasyBot();
            case MEDIUM:
                return new MediumBot();
            case HARD:
                return new HardBot();
        }
        throw new IllegalArgumentException("level undefined");
    }
}
