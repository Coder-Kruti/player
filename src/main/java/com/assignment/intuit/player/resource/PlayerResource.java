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
    /**
     * Returns all the players in the given CSV file
     * @return List of Players information.
     */
    @RequestMapping(value = "/api/players",
            produces = MediaType.APPLICATION_JSON_VALUE,
            method = RequestMethod.GET)
    ResponseEntity<PlayerResponse> getPlayers();

    /**
     * Fetch the return object based on given playerID
     * @param playerID -  For which Player information to be fetched. It is read as path parameter.
     * @return Player information from CSV
     */
    @RequestMapping(value = "/api/players/{playerID}",
            produces = MediaType.APPLICATION_JSON_VALUE,
            method = RequestMethod.GET)
    ResponseEntity<Player> getPlayerByID(@PathVariable String playerID);

    /**
     * Paginate the data and fetch the data as per given page number and size
     * @param page Page Number for which the data needs to be fetched. It is read as path parameter.
     * @param pageSize Page size to split the data in CSV.  It is read as path parameter.
     * @return List of players and errors if any.
     */

    @RequestMapping(value = "/api/players/page",
            produces = MediaType.APPLICATION_JSON_VALUE,
            method = RequestMethod.GET)
    ResponseEntity<PlayerResponse> getPlayerPageWise(@RequestParam(name = "page", defaultValue = "1") int page,
                                                     @RequestParam(name = "pageSize", defaultValue = "10") int pageSize);
}
