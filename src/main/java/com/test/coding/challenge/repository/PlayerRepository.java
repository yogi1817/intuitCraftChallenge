package com.test.coding.challenge.repository;

import com.test.coding.challenge.entities.PlayerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerRepository extends JpaRepository<PlayerEntity, Long> {
    PlayerEntity findByPlayerId(String playerId);
    List<PlayerEntity> findAll();
}
