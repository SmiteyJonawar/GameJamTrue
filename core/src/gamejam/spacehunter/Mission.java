package gamejam.spacehunter;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class Mission {

    public static void StartMissionOne(World world){
        world.getEnemyList().add(Enemy.smallEnemy(ShipFactory.createShip("simpleUnit"), 4000, 1360));
    }

    public static void StartMissionTwo(World world){
        //world.getEnemyList().add(Enemy.bigEnemy());
        //world.getEnemyList().add(new Enemy());
    }

    public static void StartMissionThree(World world){
        //world.getEnemyList().add(Enemy.bigEnemy());
        //world.getEnemyList().add(new Enemy());
        //world.getEnemyList().add(new Enemy());
    }

    public static void StartMissionFour(World world){
        //world.getEnemyList().add(Enemy.bigEnemy());
        //world.getEnemyList().add(Enemy.bigEnemy());

        world.getEnemyList().add(Enemy.bigEnemy(ShipFactory.createShip("finalBoss"), 4000, 1360));

    }
}
