package gamejam.spacehunter;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import gamejam.spacehunter.Weapons.Weapon;

public class UIDrawer {

    World world;
    BitmapFont font;

    public UIDrawer(World world){
        this.world = world;
        font = new BitmapFont();
        font.setColor(Color.BLACK);
        font.getData().setScale(4);
    }

    public void drawCards(SpriteBatch batch){
        for (Weapon w: world.getPlayer().weaponArrayList) {
            renderCard(batch, w);
        }
    }

    public void renderCard(SpriteBatch batch, Weapon weapon){
        Texture cardTexture =  weapon.getEquippedCard().cardTexture;
        Texture wTexture = weapon.getWeaponTexture().getTexture();
        batch.draw(cardTexture, weapon.getPosX(), weapon.getPosY(), 0.5f*cardTexture.getWidth(), 0.5f*cardTexture.getHeight());

        int boxWidth = 420;
        int boxHeight = 220;

        float widthRatio = weapon.getWeaponTexture().getTexture().getWidth()/(float)boxWidth;
        float heightRatio = weapon.getWeaponTexture().getTexture().getHeight()/(float)boxHeight;

        int finalWidth;
        int finalHeight;
        if (widthRatio > heightRatio){
            finalWidth = (int) (weapon.getWeaponTexture().getTexture().getWidth()/widthRatio);
            finalHeight = (int) (weapon.getWeaponTexture().getTexture().getHeight()/widthRatio);
        }else{
            finalWidth = (int) (weapon.getWeaponTexture().getTexture().getWidth()/heightRatio);
            finalHeight = (int) (weapon.getWeaponTexture().getTexture().getHeight()/heightRatio);
        }

        batch.draw(wTexture, weapon.getPosX()+60, weapon.getPosY()+55,
                finalWidth, finalHeight);


        font.draw(batch, weapon.getEquippedCard().Name, weapon.getPosX()+(1092/6)-100, weapon.getPosY()+(700));
        font.draw(batch, weapon.getEquippedCard().Damage+"", weapon.getPosX()+(1092/6)-60, weapon.getPosY()+(585));
        font.draw(batch, weapon.getEquippedCard().CastTime+"", weapon.getPosX()+(1092/6)-60, weapon.getPosY()+(485));
        font.draw(batch, weapon.getEquippedCard().Cooldown+"", weapon.getPosX()+(1092/6)-60, weapon.getPosY()+(385));
    }
}
