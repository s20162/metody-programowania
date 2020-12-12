package pl.pjatk.gameplay;


import org.springframework.web.bind.annotation.*;
import pl.pjatk.gameplay.Service.PlayerService;
import org.springframework.http.ResponseEntity;
import pl.pjatk.gameplay.model.Player;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/player")
public class PlayerController {

    private PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping
    public ResponseEntity<List<Player>> findAll(){
        return ResponseEntity.ok(playerService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Player> findByID(@PathVariable Long id) {
        Optional<Player> optionalPlayer = playerService.findByID(id);

        if(optionalPlayer.isPresent()){
            return ResponseEntity.ok(optionalPlayer.get());
        } else {
           return ResponseEntity.notFound().build();
        }
    }


    @PostMapping
    public ResponseEntity<Player> save(@RequestBody Player player) {
        return ResponseEntity.ok(playerService.save(player));
    }

    @DeleteMapping ("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        playerService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Player> update(@RequestBody Player player) {
        return ResponseEntity.ok(playerService.update(player));
    }

    @GetMapping("/attack/{​​​​attackerId}​​​​/{​​​​defenderId}​​​​")
    public ResponseEntity<Player> attackPlayer(@PathVariable Long attackerId, @PathVariable Long defenderId) {
        return ResponseEntity.ok(playerService.attackPlayer(attackerId, defenderId));
    }
}
