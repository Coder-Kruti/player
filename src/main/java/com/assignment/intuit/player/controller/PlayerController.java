package com.assignment.intuit.player.controller;

import com.assignment.intuit.player.entity.Player;
import com.assignment.intuit.player.entity.PlayerResponse;
import com.assignment.intuit.player.provider.PlayerServiceProvider;
import com.assignment.intuit.player.resource.PlayerResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class PlayerController implements PlayerResource {
    private final Logger logger = LoggerFactory.getLogger(PlayerController.class);
    @Autowired
    PlayerServiceProvider playerServiceProvider;

    PlayerController(PlayerServiceProvider playerServiceProvider) {
        this.playerServiceProvider = playerServiceProvider;
    }

    @Override
    public ResponseEntity<PlayerResponse> getPlayers() {
        PlayerResponse response = playerServiceProvider.getPlayers();
        if (response != null && !response.getPlayerList().isEmpty()) {
            logger.info("We found {} players records.", response.getPlayerList().size());
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else if (response != null && !response.getErrorList().isEmpty()) {
            logger.info("Error in processing given CSV file");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            logger.info("We do not have any player data");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @Override
    public ResponseEntity<Player> getPlayerByID(String playerID) {
        Player response = playerServiceProvider.getPlayerByID(playerID);
        if (response != null) {
            logger.info("We found the requested Player data.");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            logger.info("We do not have the requested Player data.");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @Override
    public ResponseEntity<PlayerResponse> getPlayerPageWise(int page, int pageSize) {
        PlayerResponse response = playerServiceProvider.getPlayerPageWise(page,pageSize);
        if (response.getPlayerList() != null) {
            logger.info("We found the requested Player data.");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            logger.info("We do not have the requested Player data.");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
}
