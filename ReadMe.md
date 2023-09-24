# Player Microservice

The microservice is developed based on given requirements.

## Assignment:
#### Create a microservice which serves the contents of player.csv through REST API.



The service should expose two REST endpoints:

`GET /api/players - returns the list of all players.`

`GET /api/players/{playerID} - returns a single player by ID.`

After implementing the basic functionality consider the following (as time allows): testing, edge cases, optimizations, deployment.

 
## Assumptions made: 
1. As per the specified requirements, the GET API logic has been implemented to work with CSV data as instructed. 


# Deliverables: 

1. `GET /api/players - returns the list of all players.`
    Sample Response when two records are there: 
    ```json
   {
    "playerList": [
        {
            "playerID": "aardsda01",
            "birthYear": 1981,
            "birthMonth": 12,
            "birthDay": 27,
            "birthCountry": "USA",
            "birthState": "CO",
            "birthCity": "Denver",
            "deathCountry": "",
            "deathState": "",
            "deathCity": "",
            "firstName": "David",
            "lastName": "Aardsma",
            "givenName": "David Allan",
            "weight": 215,
            "height": 75,
            "bats": "R",
            "ballThrows": "R",
            "debut": "2004-04-06",
            "finalGame": "2015-08-23",
            "retroID": "aardd001",
            "bbrefID": "aardsda01"
        },
        {
            "playerID": "aaronha01",
            "birthYear": 1934,
            "birthMonth": 2,
            "birthDay": 5,
            "birthCountry": "USA",
            "birthState": "AL",
            "birthCity": "Mobile",
            "deathCountry": "",
            "deathState": "",
            "deathCity": "",
            "firstName": "Hank",
            "lastName": "Aaron",
            "givenName": "Henry Louis",
            "weight": 180,
            "height": 72,
            "bats": "R",
            "ballThrows": "R",
            "debut": "1954-04-13",
            "finalGame": "1976-10-03",
            "retroID": "aaroh101",
            "bbrefID": "aaronha01"
        }
    ],
    "errorList": null
    }
   ```
playerList: will have list of all players. 
errorList : will have errors( it is made thinking the usage of api in future so that if one record fails , rest should be able to read)

2. `GET /api/players - returns the list of all players.`
Sample response :
```json
{
  "playerID": "aardsda01",
  "birthYear": 1981,
  "birthMonth": 12,
  "birthDay": 27,
  "birthCountry": "USA",
  "birthState": "CO",
  "birthCity": "Denver",
  "deathCountry": "",
  "deathState": "",
  "deathCity": "",
  "firstName": "David",
  "lastName": "Aardsma",
  "givenName": "David Allan",
  "weight": 215,
  "height": 75,
  "bats": "R",
  "ballThrows": "R",
  "debut": "2004-04-06",
  "finalGame": "2015-08-23",
  "retroID": "aardd001",
  "bbrefID": "aardsda01"
}
```

It Returns the exact data of the requested player ID, if not present it will return 404 Not found.

3. `GET /api/players/page?page={pageNumber}&pageSize={pageSize}` - returns the list of all players. by dividing the data into page size segments and returns players in a particular page. (This is an optimised API for 1 Get all players API. As Pagination will most likely be used in real time scenario)
Sample Response when page size is 3 and page number is 5: 
```json
{
  "playerList": [
    {
      "playerID": "abbotda01",
      "birthYear": 1862,
      "birthMonth": 3,
      "birthDay": 16,
      "birthCountry": "USA",
      "birthState": "OH",
      "birthCity": "Portage",
      "deathYear": 1930,
      "deathMonth": 2,
      "deathDay": 13,
      "deathCountry": "USA",
      "deathState": "MI",
      "deathCity": "Ottawa Lake",
      "firstName": "Dan",
      "lastName": "Abbott",
      "givenName": "Leander Franklin",
      "weight": 190,
      "height": 71,
      "bats": "R",
      "ballThrows": "R",
      "debut": "1890-04-19",
      "finalGame": "1890-05-23",
      "retroID": "abbod101",
      "bbrefID": "abbotda01"
    },
    {
      "playerID": "abbotfr01",
      "birthYear": 1874,
      "birthMonth": 10,
      "birthDay": 22,
      "birthCountry": "USA",
      "birthState": "OH",
      "birthCity": "Versailles",
      "deathYear": 1935,
      "deathMonth": 6,
      "deathDay": 11,
      "deathCountry": "USA",
      "deathState": "CA",
      "deathCity": "Los Angeles",
      "firstName": "Fred",
      "lastName": "Abbott",
      "givenName": "Harry Frederick",
      "weight": 180,
      "height": 70,
      "bats": "R",
      "ballThrows": "R",
      "debut": "1903-04-25",
      "finalGame": "1905-09-20",
      "retroID": "abbof101",
      "bbrefID": "abbotfr01"
    },
    {
      "playerID": "abbotgl01",
      "birthYear": 1951,
      "birthMonth": 2,
      "birthDay": 16,
      "birthCountry": "USA",
      "birthState": "AR",
      "birthCity": "Little Rock",
      "deathCountry": "",
      "deathState": "",
      "deathCity": "",
      "firstName": "Glenn",
      "lastName": "Abbott",
      "givenName": "William Glenn",
      "weight": 200,
      "height": 78,
      "bats": "R",
      "ballThrows": "R",
      "debut": "1973-07-29",
      "finalGame": "1984-08-08",
      "retroID": "abbog001",
      "bbrefID": "abbotgl01"
    },
    {
      "playerID": "abbotje01",
      "birthYear": 1972,
      "birthMonth": 8,
      "birthDay": 17,
      "birthCountry": "USA",
      "birthState": "GA",
      "birthCity": "Atlanta",
      "deathCountry": "",
      "deathState": "",
      "deathCity": "",
      "firstName": "Jeff",
      "lastName": "Abbott",
      "givenName": "Jeffrey William",
      "weight": 190,
      "height": 74,
      "bats": "R",
      "ballThrows": "L",
      "debut": "1997-06-10",
      "finalGame": "2001-09-29",
      "retroID": "abboj002",
      "bbrefID": "abbotje01"
    },
    {
      "playerID": "abbotji01",
      "birthYear": 1967,
      "birthMonth": 9,
      "birthDay": 19,
      "birthCountry": "USA",
      "birthState": "MI",
      "birthCity": "Flint",
      "deathCountry": "",
      "deathState": "",
      "deathCity": "",
      "firstName": "Jim",
      "lastName": "Abbott",
      "givenName": "James Anthony",
      "weight": 200,
      "height": 75,
      "bats": "L",
      "ballThrows": "L",
      "debut": "1989-04-08",
      "finalGame": "1999-07-21",
      "retroID": "abboj001",
      "bbrefID": "abbotji01"
    }
  ],
  "errorList": null
}
```

# Scope for further enhancement: 

1. The Birth Date and Death Date in the JSON response can be enhanced for readability if required by the specification.
2. Using MySQL with JPA for data storage and retrieval can offer easier and more efficient management compared to CSV, especially for large datasets. 
3. If one record has invalid data, process others, and list only the error data along with its index for focused handling. 
4. Due to time constraints, some tasks like deployment and code analysis were skipped, and they can be optimized later.
