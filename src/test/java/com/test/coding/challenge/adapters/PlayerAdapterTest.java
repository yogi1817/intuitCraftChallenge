package com.test.coding.challenge.adapters;

import com.test.coding.challenge.dto.Player;
import com.test.coding.challenge.entities.PlayerEntity;
import com.test.coding.challenge.repository.PlayerRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class PlayerAdapterTest {

    @Mock
    private PlayerRepository playerRepository;

    private PlayerAdapter playerAdapter;

    @BeforeEach
    public void setup(){
        playerAdapter = new PlayerAdapter(playerRepository);
    }

    @Test
    void getPlayerList() {
        Mockito.doReturn(List.of(
                        PlayerEntity.builder().playerId("1234").build(),
                        PlayerEntity.builder().playerId("4567").build()
                ))
                .when(playerRepository)
                .findAll();

        Player player1 = new Player();
        player1.setPlayerID("1234");
        player1.setWeight(0+"");
        player1.setHeight(0+"");

        Player player2 = new Player();
        player2.setPlayerID("4567");
        player2.setWeight(0+"");
        player2.setHeight(0+"");

        Assertions.assertEquals(playerAdapter.getPlayerList(),
                List.of(player1, player2));
    }
}
