package com.assignment.intuit.player.datasource;

import com.assignment.intuit.player.entity.Player;
import com.assignment.intuit.player.entity.PlayerResponse;
import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;

@Repository
public class PlayerRepository {
    private static final String CSV_PATH = "src/main/java/com/assignment/intuit/player/datasource/player.csv";
    private final Logger logger = LoggerFactory.getLogger(PlayerRepository.class);

    //Ideally the call here has to go to database and fetch the records. Since we are using CSV file we are reading the data here
    public PlayerResponse getPlayers() {
        PlayerResponse output = new PlayerResponse();
        List<Player> players;
        try {

            Path myPath = Paths.get(CSV_PATH);
            BufferedReader br = Files.newBufferedReader(myPath, StandardCharsets.UTF_8);

            HeaderColumnNameMappingStrategy<Player> strategy = new HeaderColumnNameMappingStrategy<>();
            strategy.setType(Player.class);

            CsvToBean<Player> csvToBean = new CsvToBeanBuilder<Player>(br).withMappingStrategy(strategy).withIgnoreLeadingWhiteSpace(true).build();

            players = csvToBean.parse();
            output.setPlayerList(players);
            output.setErrorList(null);
            logger.info("Successfully processed {} players data.", players.size());


        } catch (FileNotFoundException e) {
            logger.error("Players CSV File not found.");
            output.setErrorList(List.of("Players CSV File not found."));
        } catch (IOException e) {
            logger.error("Exception in processing the CSV file.");
            output.setErrorList(List.of("Players CSV File not found."));
        }
        return output;
    }

    public Player getPlayerByID(String playerID) {
        Player output = null;
        try {
            CSVReader reader = new CSVReader(new FileReader(CSV_PATH));
            // Create a CsvToBean object to map CSV records to the Player class
            CsvToBean<Player> csvToBean = new CsvToBeanBuilder<Player>(reader).withType(Player.class).build();

            List<Player> players = csvToBean.parse();

            // Find the matching Player object based on the playerID
            Player matchingPlayer = null;
            for (Player player : players) {
                if (Objects.equals(player.getPlayerID(), playerID)) {
                    matchingPlayer = player;
                    break;
                }
            }

            // Close the CSV reader
            reader.close();
            if (matchingPlayer != null) {
                output = matchingPlayer;
            }
        } catch (IOException e) {
            logger.error("Exception in processing the CSV file.");
        }
        return output;
    }

    public PlayerResponse getPlayerPageWise (int page, int pageSize){
        PlayerResponse playerResponse = new PlayerResponse();
        List<Player> pageOfPlayers = null;
        try {
            CSVReader reader = new CSVReader(new FileReader(CSV_PATH));
            // Create a CsvToBean object to map CSV records to the Player class
            CsvToBean<Player> csvToBean = new CsvToBeanBuilder<Player>(reader).withType(Player.class).build();

            List<Player> players = csvToBean.parse();

            // Calculate the starting index and ending index for the current page
            int startIndex = (page - 1) * pageSize;
            int endIndex = Math.min(startIndex + pageSize, players.size());

            // Slice the list to get the players for the current page
            pageOfPlayers= players.subList(startIndex, endIndex);

            // Close the CSV reader
            reader.close();
        } catch (IOException e) {
            logger.error("Exception in processing the CSV file.");
        }
        playerResponse.setPlayerList(pageOfPlayers);
        return playerResponse;
    }

}
