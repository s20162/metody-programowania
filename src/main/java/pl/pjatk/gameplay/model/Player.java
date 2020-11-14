package pl.pjatk.gameplay.model;


;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Player {

    @Id
    @GeneratedValue
    private Long id;
    private String nickname;
    private int health;
    private int attack;

    public Player() {
    }

    public Player(Long Id, String nickname, int health, int attack) {
        this.id= Id;
        this.nickname= nickname;
        this.attack= attack;
        this.health= health;
    }
    public Player( String nickname, int health, int attack) {
        this.nickname= nickname;
        this.attack= attack;
        this.health= health;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }
}

