package org.example.snakesAndLadders.models;


import lombok.Getter;
import org.example.snakesAndLadders.enums.PieceStatus;
import org.example.snakesAndLadders.utility.Random4DigitNumber;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Piece {
    private int id;
    private Color color;

    private Cell positionedAt;

    private PieceStatus status;

    public Piece(Color color, Cell initialCell) {
        this.id = Random4DigitNumber.get();
        this.color = color;
        this.positionedAt = initialCell;
        this.status = PieceStatus.LOCKED;
    }

    public static List<Piece> getPieces(Color color, int pieces, Cell initialCell) {
        List<Piece> piecesList = new ArrayList<>();
        for (int i=0;i<pieces;i++) {
            piecesList.add(new Piece(color, initialCell));
        }
        return piecesList;
    }

    public void unlock() {
        this.status = PieceStatus.MOVING;
    }

    public PieceStatus move(Board board, int diceRoll) {
        positionedAt = board.getCell(positionedAt.getNumber() + diceRoll);
        if(positionedAt.getObstacle()!=null) {
            positionedAt = board.getCell(positionedAt.getObstacle().getEnd());
        }

        if(positionedAt.getNumber() == board.getSize()) {
            this.status = PieceStatus.REACHED;
        }

        return this.status;
    }
}
