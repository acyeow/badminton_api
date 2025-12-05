package com.acyeow.badmintonapi.player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/player")
public class PlayerController {
    private final PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping
    public List<Player> getPlayers(
            @RequestParam(required = false) String country,
            @RequestParam(required = false) String name
    ) {
        if (country != null) {
            return playerService.getPlayersByCountry(country);
        } else if (name != null) {
            return playerService.getPlayersByName(name);
        } else {
            return playerService.getPlayers();
        }
    }
}
