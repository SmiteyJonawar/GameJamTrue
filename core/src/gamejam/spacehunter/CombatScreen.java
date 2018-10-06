package gamejam.spacehunter;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;
import java.util.List;

import static com.badlogic.gdx.Input.Keys.NUM_1;

public class CombatScreen implements Screen {

    SpriteBatch batch;
    World world;
    boolean gameRunning = false;
    Player player = new Player();

    public CombatScreen() {
        batch = new SpriteBatch();
        world = new World();
        Mission.StartMissionOne(world);
        System.out.println(world);
        gameRunning = true;
    }


    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        if (gameRunning) {
            if (world.getEnemyList().size() > 0) {
                if (Gdx.input.isKeyJustPressed(Input.Keys.NUM_1)) {
                    fireWeapon(NUM_1);
                }

                if (Gdx.input.isKeyJustPressed(Input.Keys.NUM_2)) {
                    fireWeapon(NUM_1);
                }

                if (Gdx.input.isKeyJustPressed(Input.Keys.NUM_3)) {
                    fireWeapon(NUM_1);
                }

                if (Gdx.input.isKeyJustPressed(Input.Keys.NUM_4)) {
                    fireWeapon(NUM_1);
                }
            }
            batch.begin();
            player.render(batch);

            for (Enemy e: world.getEnemyList()){
                e.render(batch);
            }
            batch.end();



            updateEntities();
        }
    }



    private void fireWeapon(int i){
            System.out.println("Enemies: " + world.getEnemyList().size());
            System.out.println(world.getEnemyList().get(0).getHP());
            System.out.println(world.getPlayer().getName());
            world.getPlayer().fireWeapon(i, world.getEnemyList().get(0));
            System.out.println("Railgun Fired");
            System.out.println(world.getEnemyList().get(0).getHP());
    }

    private void updateEntities(){
        for (int i = 0; i < world.getEnemyList().size(); i++){
            Enemy e = world.getEnemyList().get(i);
            if (world.getEnemyList().get(i).getHP() <= 0){
                world.getEnemyList().remove(e);
                System.out.println("Enemies: " + world.getEnemyList().size());
            }
        }
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
