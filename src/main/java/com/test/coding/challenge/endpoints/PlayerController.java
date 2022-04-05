package com.test.coding.challenge.endpoints;

import com.test.coding.challenge.api.ChallangeApiDelegate;
import com.test.coding.challenge.dto.Player;
import com.test.coding.challenge.ports.in.PlayerPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor
public class PlayerController implements ChallangeApiDelegate {

    private final PlayerPort playerPort;

    @Override
    public ResponseEntity<List<Player>> getPlayerList() {
        return ResponseEntity.ok(playerPort.getPlayerList());
    }

    @Override
    public ResponseEntity<Player> getUniquePlayer(String playerID) {
        return ResponseEntity.ok(playerPort.getPlayerData(playerID));
    }

    @Override
    public ResponseEntity<Void> loadData() {
        playerPort.importFile();
        return ChallangeApiDelegate.super.loadData();
    }

    @Override
    public ResponseEntity<Void> apiPlayerPost(Player player) {
        playerPort.savePlayer(player);
        return ChallangeApiDelegate.super.apiPlayerPost(player);
    }
}
