package com.test.coding.challenge.entities;

import com.test.coding.challenge.dto.Player;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "player", uniqueConstraints = @UniqueConstraint(columnNames = "player_id"))
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Builder(toBuilder = true)
@AllArgsConstructor
public class PlayerEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false, columnDefinition = "serial")
    private Long id;

    @Column(name = "player_id")
    private String playerId;
    private LocalDate birthDate;
    private String birthCountry;
    private String birthState;
    private String birthCity;
    private LocalDate deathDate;
    private String deathCountry;
    private String deathState;
    private String deathCity;
    private String firstName;
    private String lastName;
    private String givenName;
    private int weight;
    private int height;
    private String bats;
    private String throwsHand;
    private LocalDate debut;
    private LocalDate finalGame;
    private String retroId;
    private String bbrefId;

    public Player convertToPlayer(){
        Player player = new Player();
        player.setPlayerID(this.playerId);
        player.setBirthDate(this.birthDate!=null?this.birthDate.toString():null);
        player.setBirthCountry(this.birthCountry);
        player.setBirthState(this.birthState);
        player.setBirthCity(this.birthCity);
        player.setDeathDate(this.deathDate!=null?this.deathDate.toString():null);
        player.setDeathCountry(this.deathCountry);
        player.setDeathState(this.deathState);
        player.setDeathCity(this.deathCity);
        player.setFirstName(this.firstName);
        player.setLastName(this.lastName);
        player.setNameGiven(this.givenName);
        player.setWeight(this.weight+"");
        player.setHeight(this.height+"");
        player.setBats(this.bats);
        player.setThrowsHand(this.throwsHand);
        player.setDebut(this.debut!=null?this.debut.toString():null);
        player.setFinalGame(this.finalGame!=null?this.finalGame.toString():null);
        player.setRetroID(this.retroId);
        player.setBbrefID(this.bbrefId);
        return player;
    }
}
