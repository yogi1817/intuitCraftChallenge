package com.test.coding.challenge.adapters;

import com.test.coding.challenge.dto.Player;
import com.test.coding.challenge.entities.PlayerEntity;
import com.test.coding.challenge.ports.in.PlayerPort;
import com.test.coding.challenge.repository.PlayerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class PlayerAdapter implements PlayerPort {

    private final PlayerRepository playerRepository;
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");
    private SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public Player getPlayerData(String playerId) {
        return playerRepository.findByPlayerId(playerId).convertToPlayer();
    }

    @Override
    public List<Player> getPlayerList() {
        return playerRepository.findAll().stream()
                .map(it -> it.convertToPlayer())
                .collect(Collectors.toList());
    }

    @Override
    public void importFile(){

        boolean flag = true;
        LocalDate deathDate = null;
        LocalDate birthDate = null;
        try (BufferedReader br = new BufferedReader(new FileReader("Player.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                if(flag){
                    flag = false;
                    continue;
                }

                String[] stringArray = line.split(",");
                if(!"".equals(stringArray[7]) &&  !"".equals(stringArray[8])
                        && !"".equals(stringArray[9])){
                    deathDate = LocalDate.of(Integer.parseInt(stringArray[7]), Integer.parseInt(stringArray[8]),
                            Integer.parseInt(stringArray[9]));
                }else{
                    deathDate = null;
                }

                if(!"".equals(stringArray[1]) &&  !"".equals(stringArray[2])
                        && !"".equals(stringArray[3])){
                    birthDate = LocalDate.of(Integer.parseInt(stringArray[1]),
                            Integer.parseInt(stringArray[2]), Integer.parseInt(stringArray[3]));
                }else{
                    birthDate = null;
                }
                playerRepository.save(PlayerEntity.builder()
                    .playerId(stringArray[0])
                    .birthDate(birthDate)
                    .birthCountry(stringArray[4])
                    .birthState(stringArray[5])
                    .birthCity(stringArray[6])
                    .deathDate(deathDate)
                    .deathCity(stringArray[10])
                    .deathState(stringArray[11])
                    .deathCity(stringArray[12])
                    .firstName(stringArray[13])
                    .lastName(stringArray[14])
                    .givenName(stringArray[15])
                    .weight("".equals(stringArray[16])?-1:Integer.parseInt(stringArray[16]))
                    .height("".equals(stringArray[17])?-1:Integer.parseInt(stringArray[17]))
                    .bats(stringArray[18])
                    .throwsHand(stringArray[19])
                    .debut(formatDate(stringArray[20]))
                    .finalGame(formatDate(stringArray[21]))
                    .retroId(stringArray[22])
                    .bbrefId(stringArray[23])
                    .build());
            }
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void savePlayer(Player player) {
        PlayerEntity playerEntity = new PlayerEntity();
        playerEntity.setPlayerId(player.getPlayerID());
        playerEntity.setBats(player.getBats());

        playerRepository.save(playerEntity);
    }

    private LocalDate formatDate(String s) {
        Date date = new Date();
        try {
            date = simpleDateFormat.parse(s);
        } catch (ParseException e) {
            try{
                date = simpleDateFormat2.parse(s);
            } catch (ParseException parseException) {
                return null;
            }
        }
        return Instant.ofEpochMilli(date.getTime())
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
    }
}
