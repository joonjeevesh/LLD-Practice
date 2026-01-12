package org.example.snakesAndLadders.models;

import org.example.snakesAndLadders.enums.PlayerStatus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeaderBoard {
    private int totalPiecesPerPlayer;
    private Map<Player, Integer> playerToPiecesReachedMap = new HashMap<>();

    private Map<Integer, List<Player>> piecesReachedToPlayersMap = new HashMap<>();

    public LeaderBoard(List<Player> players, int piecesPerPlayer) {
        this.totalPiecesPerPlayer = piecesPerPlayer;
        piecesReachedToPlayersMap.put(0, new ArrayList<>(players));
        for(int i=1;i<=piecesPerPlayer;i++) {
            piecesReachedToPlayersMap.put(i, new ArrayList<>());
        }

        for (Player player: players) {
            playerToPiecesReachedMap.put(player, 0);
        }
    }

    public int increasePlayerPiecesReachedByOne(Player player) {
        int piecesReachedCountForPlayer = playerToPiecesReachedMap.get(player);
        piecesReachedToPlayersMap.get(piecesReachedCountForPlayer).remove(player);

        piecesReachedCountForPlayer++;

        playerToPiecesReachedMap.put(player, piecesReachedCountForPlayer);
        piecesReachedToPlayersMap.get(piecesReachedCountForPlayer).add(player);
        return piecesReachedCountForPlayer;
    }

    public int countPlayersWon() {
        return piecesReachedToPlayersMap.get(totalPiecesPerPlayer).size();
    }

    public List<PlayerRanking> getLeaderBoard() {
        List<PlayerRanking> rankingList= new ArrayList<>();
        int rank = 1;
        for(int i=totalPiecesPerPlayer;i>=0;i--) {
            for (Player player: piecesReachedToPlayersMap.get(i)) {
                rankingList.add(PlayerRanking.builder()
                                .playerName(player.getName())
                                .rank(rank)
                                .build());
                rank++;
            }
        }
        return rankingList;
    }
}
