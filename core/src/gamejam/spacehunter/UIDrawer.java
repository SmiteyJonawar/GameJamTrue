package gamejam.spacehunter;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import gamejam.spacehunter.Weapons.Weapon;

public class UIDrawer {

    World world;

    public UIDrawer(World world){
        this.world = world;
    }

    public void drawCards(SpriteBatch batch){

        for (Weapon w: world.getPlayer().weaponArrayList) {
            Texture texture =  w.getEquippedCard().texture;
            batch.draw(w.getEquippedCard().tr, w.getPosX(), w.getPosY(), 0.5f*texture.getWidth(), 0.5f*texture.getHeight());
        }
    }
}
