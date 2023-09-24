package com.assignment.intuit.player.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.opencsv.bean.CsvBindByName;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Player {
    @CsvBindByName(column = "playerID")
    @Id
    String playerID;

    @CsvBindByName(column = "birthYear")
    Integer birthYear;
    @CsvBindByName(column = "birthMonth")
    Integer birthMonth;
    @CsvBindByName(column = "birthDay")
    Integer birthDay;
    @CsvBindByName(column = "birthCountry")
    String birthCountry;
    @CsvBindByName(column = "birthState")
    String birthState;
    @CsvBindByName(column = "birthCity")
    String birthCity;
    @CsvBindByName(column = "deathYear")
    Integer deathYear;
    @CsvBindByName(column = "deathMonth")
    Integer deathMonth;
    @CsvBindByName(column = "deathDay")
    Integer deathDay;
    @CsvBindByName(column = "deathCountry")
    String deathCountry;
    @CsvBindByName(column = "deathState")
    String deathState;
    @CsvBindByName(column = "deathCity")
    String deathCity;
    @CsvBindByName(column = "nameFirst")
    String firstName;
    @CsvBindByName(column = "nameLast")
    String lastName;
    @CsvBindByName(column = "nameGiven")
    String givenName;
    @CsvBindByName(column = "weight")
    Integer weight;
    @CsvBindByName(column = "height")
    Integer height;
    @CsvBindByName(column = "bats")
    Character bats;
    @CsvBindByName(column = "throws")
    Character ballThrows;
    @CsvBindByName(column = "debut")
    String debut;
    @CsvBindByName(column = "finalGame")
    String finalGame;
    @CsvBindByName(column = "retroID")
    String retroID;
    @CsvBindByName(column = "bbrefID")
    String bbrefID;
}
