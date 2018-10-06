package gamejam.spacehunter;

import java.util.ArrayList;

public class World {
    private Player player;
    private ArrayList<Enemy> enemyList;

    public World(){
        player = new Player();
        enemyList = new ArrayList<Enemy>();
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public ArrayList<Enemy> getEnemyList() {
        return enemyList;
    }

    public void setEnemyList(ArrayList<Enemy> enemyList) {
        this.enemyList = enemyList;
    }
}
