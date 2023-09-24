package com.assignment.intuit.player.resource;

import com.assignment.intuit.player.entity.Player;
import com.assignment.intuit.player.entity.PlayerResponse;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

public interface PlayerResource {
    @RequestMapping(value = "/api/players",
            produces = MediaType.APPLICATION_JSON_VALUE,
            method = RequestMethod.GET)
    ResponseEntity<PlayerResponse> getPlayers();

    @RequestMapping(value = "/api/players/{playerID}",
            produces = MediaType.APPLICATION_JSON_VALUE,
            method = RequestMethod.GET)
    ResponseEntity<Player> getPlayerByID(@PathVariable String playerID);

    @RequestMapping(value = "/api/players/page",
            produces = MediaType.APPLICATION_JSON_VALUE,
            method = RequestMethod.GET)
    ResponseEntity<PlayerResponse> getPlayerPageWise( @RequestParam(name = "page", defaultValue = "1") int page,
                                                      @RequestParam(name = "pageSize", defaultValue = "10") int pageSize);
}
