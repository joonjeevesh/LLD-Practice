package org.example.tictactoe.factories;

import org.example.tictactoe.models.BotPlayer;
import org.example.tictactoe.models.HumanPlayer;

public class PlayerFactory {
    public static HumanPlayer.HumanPlayerBuilder createHumanPlayer() {
        return HumanPlayer.builder();
    }

    public static BotPlayer.BotPlayerBuilder createBotPlayer() {
        return BotPlayer.builder();
    }
}
