package com.assignment.intuit.player;

import com.assignment.intuit.player.datasource.PlayerRepository;
import com.assignment.intuit.player.entity.Player;
import com.assignment.intuit.player.entity.PlayerResponse;
import com.assignment.intuit.player.provider.PlayerServiceProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.mock;


@ExtendWith(MockitoExtension.class)
public class PlayerServiceProviderTest {

    public static PlayerServiceProvider playerServiceProvider;

    public static PlayerRepository playerRepositoryMock;

    @BeforeEach
    public void setup() {
        Player player = new Player();
        player.setPlayerID("test1");
        player.setFirstName("player1");
        PlayerResponse playerResponse = new PlayerResponse(List.of(player), null);
        playerRepositoryMock = mock(PlayerRepository.class);
        lenient().when(playerRepositoryMock.getPlayers()).thenReturn(playerResponse);
        lenient().when(playerRepositoryMock.getPlayerByID("test1")).thenReturn(player);

        playerServiceProvider = new PlayerServiceProvider(playerRepositoryMock);
    }

    @Test
    public void testGetAllPlayersValid() {
        PlayerResponse playerResponse = playerServiceProvider.getPlayers();
        //verify if you get the same object.
        assertEquals(1, playerResponse.getPlayerList().size());
        assertEquals("test1", playerResponse.getPlayerList().get(0).getPlayerID());
    }

    @Test
    public void testGetPlayerByIDValid() {
        Player player = playerServiceProvider.getPlayerByID("test1");
        //verify if you get the same object.
        assertEquals("test1", player.getPlayerID());
    }
}
