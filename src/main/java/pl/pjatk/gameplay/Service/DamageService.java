package pl.pjatk.gameplay.Service;


import org.springframework.stereotype.Service;
import pl.pjatk.gameplay.model.Player;

@Service
public class DamageService {

    public Player attackPlayer(Player attacker, Player defender){
        defender.setHealth(defender.getHealth() - attacker.getAttack());
        return defender;
    }
}