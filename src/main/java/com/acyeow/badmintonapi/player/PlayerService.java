package com.acyeow.badmintonapi.player;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class PlayerService {
    private PlayerRepository playerRepository;

    @Autowired
    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public List<Player> getPlayers() {
        return playerRepository.findAll();
    }

    public List<Player> getPlayersByCountry(String country) {
        return playerRepository.findAll().stream()
                .filter(player -> country.equalsIgnoreCase(player.getCountry()))
                .collect(Collectors.toList());
    }

    public List<Player> getPlayersByName(String playerName) {
        return playerRepository.findAll().stream()
                .filter(player -> player.getName().toLowerCase().contains(playerName.toLowerCase()))
                .collect(Collectors.toList());
    }

    public Player addPlayer(Player player) {
        return playerRepository.save(player);
    }

    public Player updatePlayer(Player updatedPlayer) {
        Optional<Player> existingPlayer = playerRepository.findByName(updatedPlayer.getName());

        if (existingPlayer.isPresent()) {
            Player playerToUpdate = existingPlayer.get();
            playerToUpdate.setRank(updatedPlayer.getRank());
            playerToUpdate.setName(updatedPlayer.getName());
            playerToUpdate.setCountry(updatedPlayer.getCountry());
            playerToUpdate.setPoints(updatedPlayer.getPoints());
            playerToUpdate.setTournaments(updatedPlayer.getTournaments());
            playerToUpdate.setLastUpdate(updatedPlayer.getLastUpdate());
            playerToUpdate.setRankChange(updatedPlayer.getRankChange());

            playerRepository.save(playerToUpdate);
            return playerToUpdate;
        }
        return null;
    }

    @Transactional
    public void deletePlayer(String playerName) {
        playerRepository.deleteByName(playerName);
    }
}
