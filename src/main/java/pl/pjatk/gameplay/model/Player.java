package pl.pjatk.gameplay.model;

public class Player {
    private int id;
    private String nickname;
    private int health;
    private int attack;

    public Player() {

    }

    public Player(int attack) {
        this.attack = attack;
    }

    public Player(int id, String nick, int hp, int ap){
        this.id= id;
        nickname=nick;
        health= hp;
        attack= ap;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", nickname='" + nickname + '\'' +
                ", health=" + health +
                ", attack=" + attack +
                '}';
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public int getAttack() {
        return attack;
    }
}
