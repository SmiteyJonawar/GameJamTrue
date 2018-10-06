package gamejam.spacehunter;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import static com.badlogic.gdx.Input.Keys.NUM_1;

public class CombatScreen implements Screen {

    SpriteBatch batch;
    World world;
    boolean gameRunning = false;
    UIDrawer uiDrawer;

    public CombatScreen() {
        OrthographicCamera cam = new OrthographicCamera();
        cam.setToOrtho(false, 1280*4, 720*4);
        batch = new SpriteBatch();
        batch.setProjectionMatrix(cam.combined);
        world = new World();
        Mission.StartMissionOne(world);
        for (Enemy e : world.getEnemyList()) {
            e.setWorld(world);
        }
        System.out.println(world);
        System.out.println(world.getPlayer().weaponArrayList.size());
        gameRunning = true;
        uiDrawer = new UIDrawer(world);

    }


    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        if (world.getPlayer().readyToAttack && !world.getPlayer().isAttacking()) {
            if (world.getEnemyList().size() > 0) {
                if (Gdx.input.isKeyJustPressed(Input.Keys.NUM_1)) {
                    fireWeapon(0);
                }

                if (Gdx.input.isKeyJustPressed(Input.Keys.NUM_2)) {
                    fireWeapon(1);
                }

                if (Gdx.input.isKeyJustPressed(Input.Keys.NUM_3)) {
                    fireWeapon(2);
                }

                if (Gdx.input.isKeyJustPressed(Input.Keys.NUM_4)) {
                    fireWeapon(3);
                }
            }
        }  if (world.getPlayer().isAttacking()) {
            world.getPlayer().fireIfReady();

        }
        if (gameRunning && !world.getPlayer().readyToAttack) {

            world.getPlayer().updateProcess();
            for (Enemy e : world.getEnemyList()) {
                if (e.isReadyToAttack()) {
                    e.attack();
                } else {
                    e.updateProcess();
                }

            }

        }
        batch.begin();
        for (Enemy e: world.getEnemyList()) {
            e.render(batch);
        }
        world.getPlayer().render(batch);
        batch.end();
        updateEntities();
        drawEntities();
    }
    private void drawEntities(){
        batch.begin();
        world.getPlayer().render(batch);

        for (Enemy e : world.getEnemyList()) {
            e.render(batch);
            e.updateProcess();
        }

        world.getPlayer().render(batch);
        if (world.getPlayer().weaponArrayList.size() > 0) {
            uiDrawer.drawCards(batch);
        }
        batch.end();
    }



    private void fireWeapon(int i){
            System.out.println("Enemies: " + world.getEnemyList().size());
            System.out.println(world.getEnemyList().get(0).getHP());
            System.out.println(world.getPlayer().getName());
            world.getPlayer().fireWeapon(i, world.getEnemyList().get(0));
            System.out.println(world.getPlayer().weaponArrayList.get(i).getEquippedCard().Name + " fired.");
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
