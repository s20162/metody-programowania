package pl.pjatk.gameplay.Service;

import pl.pjatk.gameplay.model.Player;

import org.springframework.stereotype.Service;
import pl.pjatk.gameplay.repository.PlayerRepository;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {
    private PlayerRepository playerRepository;
    private DamageService damageService;

    public PlayerService() {
        this.playerRepository = playerRepository;
        this.damageService = damageService;
    }

    public List<Player> findAll() {
        return playerRepository.findAll();
    }

    public Optional<Player> findByID(Long playerID){
        return playerRepository.findById(playerID);
    }

    public void deleteById(Long id) {
        playerRepository.deleteById(id);
    }

   public Player save(Player player) {
        return playerRepository.save(player);
   }

   public Player update(Player player) {
        if (playerRepository.findById(player.getId()).isEmpty()) {
            throw new RuntimeException();
        } else {
            return playerRepository.save(player);
        }
   }

    public Player attackPlayer(Long attackerId, Long defenderId) {
        Player attacker = findByID(attackerId).get();
        Player defender = findByID(defenderId).get();
        defender = damageService.attackPlayer(attacker, defender);
        return update(defender);
    }
}
