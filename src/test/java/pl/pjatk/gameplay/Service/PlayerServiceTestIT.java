package pl.pjatk.gameplay.Service;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.pjatk.gameplay.model.Player;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;


@SpringBootTest
public class PlayerServiceTestIT {

    @Autowired
    private PlayerService playerService;

    @BeforeEach
    void cleanUp() {
        playerService.deleteAll();
    }

    @Test
    void shouldNotFindAll() {
        List<Player> all = playerService.findAll();
        assertThat(all).isEmpty();

    }
    @Test
    void shouldFindAllPlayers() {
        playerService.save(new Player("adam", 100, 10));
        List<Player> all = playerService.findAll();
        assertThat(all).isNotEmpty();
    }
     @Test
    void shouldSavePlayer() {
        Player player = playerService.save(new Player("adam", 100, 10));
        assertThat(player.getId()).isPositive();
     }
     @Test
    void shouldFindByID() {
        Player player = playerService.save(new Player("25", 24, 4));
        assertThat(playerService.findByID(player.getId())).isNotEmpty();
     }

     @Test
    void shouldAttackPlayer() {
        Player attacker = playerService.save(new Player("25", 24, 4));
        Player defender = playerService.save(new Player("26", 24, 4));
        playerService.attackPlayer(attacker.getId(), defender.getId());
         Optional<Player> updatedPlayer = playerService.findByID(defender.getId());
         assertThat(updatedPlayer.get().getHealth()).isEqualTo(20);
     }
     @Test
    void shouldThrowExeptionOnFindByID() {
        assertThatExceptionOfType(RuntimeException.class).isThrownBy(() -> playerService.findByID(10L));
     }



















}
