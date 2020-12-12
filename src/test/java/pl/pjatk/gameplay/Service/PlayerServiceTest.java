package pl.pjatk.gameplay.Service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.pjatk.gameplay.model.Player;
import pl.pjatk.gameplay.repository.PlayerRepository;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class PlayerServiceTest {
    @Mock
    private DamageService damageService;

    @Mock
    private PlayerRepository playerRepository;

    @InjectMocks
    private PlayerService playerService;


    @Test
    void shouldFindAll() {
       //given
        when(playerRepository.findAll()).thenReturn(List.of(new Player()));
        //when
        List<Player> all = playerService.findAll();
        //then
        assertThat(all).hasSize(1);
    }

    @Test
    void shouldfindByID() {

        when(playerRepository.findById(1L)).thenReturn(Optional.of(new Player(1L,"A" ,100, 100)));
        Optional<Player> OP = playerService.findByID(1L);
        assertThat(OP.get().getId()).isEqualTo(1L);
    }


    @Test
    void shoulddeleteById() {

        playerService.deleteById(1L);
        playerService.deleteById(2L);
        verify(playerRepository, times(1)).deleteById(1L);

    }


    @Test
    void shouldsave() {
        when(playerRepository.save(any())).thenReturn(new Player(1L, "a", 100, 100));
        assertThat(playerService.save(any()).getId()).isEqualTo(1L);
    }

    @Test
    void shouldattackPlayer() {
        Player player1 = new Player(1L, "a", 1000, 100);
        Player player2 = new Player(2L, "b" , 1000, 100);

        when(damageService.attackPlayer(player1,player2)).thenReturn(player2);
        when(playerRepository.findById(1L)).thenReturn(Optional.of(player1));
        when(playerRepository.findById(2L)).thenReturn(Optional.of(player2));
        when(playerRepository.save(player2)).thenReturn(player2);

        playerService.attackPlayer(player1.getId(),player2.getId());

        assertThat(player2.getHealth()).isEqualTo(900);





    }
}