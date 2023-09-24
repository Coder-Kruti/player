package com.assignment.intuit.player.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlayerResponse {
    List<Player> playerList;

    List<String> errorList;

}
