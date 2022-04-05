package com.test.coding.challenge.ports.in;

import com.test.coding.challenge.dto.Player;

import java.util.List;

public interface PlayerPort {
    Player getPlayerData(String playerId);
    List<Player> getPlayerList();
    void importFile();
    void savePlayer(Player player);
}
