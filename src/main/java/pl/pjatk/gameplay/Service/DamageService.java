package pl.pjatk.gameplay.Service;


import org.springframework.stereotype.Service;
import pl.pjatk.gameplay.model.Player;

@Service
public class DamageService {

    public Player attackPlayer(Player attacker, Player defender) {
        defender.setHealth(defender.getHealth() - attacker.getAttack());
        return defender;
    }

    public Player heal(Player player) {
        if (player.getHealth() > 150) {
            player.setHealth(player.getHealth() + 100);
        } else {
            player.setHealth(player.getHealth() + 200);
        }
        return player;
    }

    public Player buffAP(Player player) {
        if (player.getAttack() > 150) {
            player.setAttack(player.getAttack() + 100);
        } else {
            player.setAttack(player.getAttack() + 200);
        }
        return player;
    }

    public Player criticalAttack(Player attacker, Player defender) {
        if (defender.getHealth() < attacker.getHealth()) {
            defender.setHealth(defender.getHealth() - (attacker.getAttack()) * 2);
        } else {
            defender.setHealth(defender.getHealth() - (attacker.getAttack()) * 3);
        }
        return defender;
    }

    public Player debuffAP(Player player) {
        if (player.getAttack() > 150) {
            player.setAttack(player.getAttack() - 30);
        } else {
            player.setAttack(player.getAttack() - 15);
        }
        return player;
    }
}