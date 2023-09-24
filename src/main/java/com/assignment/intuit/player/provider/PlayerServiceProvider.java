package com.assignment.intuit.player.provider;

import com.assignment.intuit.player.datasource.PlayerRepository;
import com.assignment.intuit.player.entity.Player;
import com.assignment.intuit.player.entity.PlayerResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class PlayerServiceProvider {
    PlayerRepository playerRepository;

    public PlayerServiceProvider(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    private final Logger logger = LoggerFactory.getLogger(PlayerServiceProvider.class);

    public PlayerResponse getPlayers() {
        logger.info("Processing Player records");
        PlayerResponse output = playerRepository.getPlayers();
        return output;
    }

    public Player getPlayerByID(String playerID) {
        Player player = playerRepository.getPlayerByID(playerID);
        return player;
    }

    public PlayerResponse getPlayerPageWise(int page, int pageSize) {
        logger.info("Processing Player records");
        PlayerResponse output = playerRepository.getPlayerPageWise(page, pageSize);
        return output;
    }


}
