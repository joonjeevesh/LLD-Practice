package org.example.snakesAndLadders.models;

import lombok.Builder;
import lombok.Getter;
import org.example.snakesAndLadders.enums.PieceStatus;
import org.example.snakesAndLadders.enums.PlayerStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Getter
@Builder
public class Game {
    private Board board;

    private Dice dice;

    private List<Player> players;

    private LeaderBoard leaderBoard;

    public static Game createGame(int size, int maxFaceValue, int piecesPerPlayer,
                                  List<PlayerRequest> players, List<Obstacle> obstacles) {
        Board board = Board.createBoard(size, obstacles.stream().collect(Collectors.toMap(Obstacle::getStart, Function.identity())));
        List<Player> playerList = new ArrayList<>();
        for (PlayerRequest request: players) {
            playerList.add(Player.getPlayer(request.getName(), piecesPerPlayer, request.getColor(), board.getCell(1)));
        }
        return Game.builder()
                .board(board)
                .dice(new Dice(maxFaceValue))
                .players(playerList)
                .leaderBoard(new LeaderBoard(playerList, piecesPerPlayer))
                .build();
    }

    public int roll() {
        return this.dice.roll();
    }

    public PlayerStatus move(Player player, Piece piece, int diceRoll) {
        PieceStatus pieceStatus = piece.move(this.board, diceRoll);
        PlayerStatus playerStatus = player.getPlayerStatus();

        if(pieceStatus == PieceStatus.REACHED) {
            int piecesReachedForPlayer = leaderBoard.increasePlayerPiecesReachedByOne(player);
            playerStatus = player.updatePlayerStatus(piecesReachedForPlayer);
        }

        return playerStatus;
    }

    public void unlockPiece(Player player, Piece piece) {
        piece.unlock();
    }
}
