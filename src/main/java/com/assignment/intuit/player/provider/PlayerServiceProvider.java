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

    /**
     * Get all player data
     * @return All Players data.
     */
    public PlayerResponse getPlayers() {
        logger.info("Fetching Player records");
        PlayerResponse output = playerRepository.getPlayers();
        return output;
    }

    /**
     *
     * @param playerID Player ID for which data needs to be fetched.
     * @return Player information
     */
    public Player getPlayerByID(String playerID) {
        logger.info("Fetching  Player record for palyer {}", playerID);
        Player player = playerRepository.getPlayerByID(playerID);
        return player;
    }

    /**
     *
     * @param page Page number
     * @param pageSize Split the data into pages using page size
     * @return All the player information for that range
     */
    public PlayerResponse getPlayerPageWise(int page, int pageSize) {
        logger.info("Fetching Player records for the given range");
        PlayerResponse output = playerRepository.getPlayerPageWise(page, pageSize);
        return output;
    }


}
