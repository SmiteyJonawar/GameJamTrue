package gamejam.spacehunter;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import gamejam.spacehunter.Weapons.Weapon;

import javax.smartcardio.Card;
import java.util.ArrayList;
import java.util.Collection;

public class UIDrawer {

    World world;

    public UIDrawer(World world){
        this.world = world;
    }

    public void drawCards(SpriteBatch batch){

        for (Weapon w: world.getPlayer().weaponArrayList) {
            batch.draw(w.getEquippedCard().texture, w.getPosX(), w.getPosY());
        }
    }
}
