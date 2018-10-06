package gamejam.spacehunter;

public class Mission {

    public static void StartMissionOne(World world){
        world.getEnemyList().add(new Enemy());
    }

    public static void StartMissionTwo(World world){
        world.getEnemyList().add(Enemy.bigEnemy());
        world.getEnemyList().add(new Enemy());
    }

    public static void StartMissionThree(World world){
        world.getEnemyList().add(Enemy.bigEnemy());
        world.getEnemyList().add(new Enemy());
        world.getEnemyList().add(new Enemy());
    }

    public static void StartMissionFour(World world){
        world.getEnemyList().add(Enemy.bigEnemy());
        world.getEnemyList().add(Enemy.bigEnemy());
        world.getEnemyList().add(new Boss());

    }
}
