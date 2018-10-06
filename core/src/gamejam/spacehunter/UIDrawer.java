package gamejam.spacehunter;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import gamejam.spacehunter.Weapons.Weapon;

public class UIDrawer {

    World world;

    public UIDrawer(World world){
        this.world = world;
    }

    public void drawCards(SpriteBatch batch){
        BitmapFont font = new BitmapFont();
        font.setColor(Color.BLACK);
        font.getData().setScale(4);;
        for (Weapon w: world.getPlayer().weaponArrayList) {
            Texture texture =  w.getEquippedCard().cardTexture;
            Texture wTexture = w.getEquippedCard().weaponTexture;
            batch.draw(texture, w.getPosX(), w.getPosY(), 0.5f*texture.getWidth(), 0.5f*texture.getHeight());
            batch.draw(wTexture, w.getPosX()+wTexture.getWidth()/2, w.getPosY()+(wTexture.getHeight()/2),
                    wTexture.getWidth(), wTexture.getHeight());
            font.draw(batch, w.getEquippedCard().Name, w.getPosX()+(1092/6)-100, w.getPosY()+(700));
            font.draw(batch, w.getEquippedCard().Damage+"", w.getPosX()+(1092/6)-60, w.getPosY()+(585));
            font.draw(batch, w.getEquippedCard().CastTime+"", w.getPosX()+(1092/6)-60, w.getPosY()+(485));
            font.draw(batch, w.getEquippedCard().Cooldown+"", w.getPosX()+(1092/6)-60, w.getPosY()+(385));
        }
       font.dispose();
    }
}
