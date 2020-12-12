package service;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.pjatk.gameplay.Service.DamageService;
import pl.pjatk.gameplay.model.Player;

import static org.assertj.core.api.Assertions.assertThat;

public class DamageServiceTest {

    private DamageService damageService = new DamageService();
    private Player player;

    @BeforeEach
    void creatingPlayer() {
       player = new Player("my nickname", 500, 50);
    }


    @Test
    void shouldHealPlayer(){
        //given
        //Player player = new Player("my nickname", 500, 50);

        //when
        damageService.heal(player);

        //then
        assertThat(player.getHealth()).isEqualTo(600);

    }

    @Test
    void shouldHealPlayerLess(){
        //given
        player.setHealth(140);

        //when
        damageService.heal(player);

        //then
        assertThat(player.getHealth()).isEqualTo(340);

    }
}
