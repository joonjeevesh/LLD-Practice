package org.example.snakesAndLadders.models;

import lombok.Builder;
import lombok.Getter;
import org.example.snakesAndLadders.enums.PlayerStatus;
import org.example.snakesAndLadders.utility.Random4DigitNumber;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
public class Player {
    private int id;

    private String name;

    private PlayerStatus playerStatus;

    private List<Piece> pieces = new ArrayList<>();

    @Builder
    public Player(String name, PlayerStatus playerStatus, List<Piece> pieces) {
        this.name = name;
        this.playerStatus = playerStatus;
        this.pieces = pieces;
        this.id = Random4DigitNumber.get();
    }

    public static Player getPlayer(String name, int piecesPerPlayer, Color color, Cell initialCell) {
        return Player.builder()
                .name(name)
                .playerStatus(PlayerStatus.PLAYING)
                .pieces(Piece.getPieces(color, piecesPerPlayer, initialCell))
                .build();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // Reference equality check
        if (o == null || getClass() != o.getClass()) return false; // Null and type check
        Player player = (Player) o;
        // Field comparison using Objects.equals for null-safety
        return this.id == player.getId();
    }

    @Override
    public int hashCode() {
        // Generates hash code based on relevant fields
        return Objects.hash(id);
    }

    public void setPlayerStatus(PlayerStatus playerStatus) {
        this.playerStatus = playerStatus;
    }
}
