package gamejam.spacehunter.Weapons;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class WeaponFactory {
    public static WeaponTexture createTexture(String name){
        if (name.equals("doubleJimmy")){
            return makeWeaponTexture("DoubleJimmy.png", new Vector2(398,158));
        }else if (name.equals("bigBertha")){
            return makeWeaponTexture("BigBertha.png", new Vector2(383,252));
        }else if (name.equals("blaster")){
            return makeWeaponTexture("Blaster.png", new Vector2(243,102));
        }else if (name.equals("doubleBlaster")){
            return makeWeaponTexture("DoubleBlaster.png", new Vector2(398,158));
        }else if (name.equals("flashCannon")){
            return makeWeaponTexture("FlashCannon.png", new Vector2(487,145));
        }else if (name.equals("gatlingGun")){
            return makeWeaponTexture("Gatlinggun.png", new Vector2(550,171));
        }else if (name.equals("missile")){
            return makeWeaponTexture("Missile.png", new Vector2(235,147));
        }else if (name.equals("sniper")){
            return makeWeaponTexture("Sniper.png", new Vector2(702,232));
        }

        throw new IllegalArgumentException("weapon does not exist");
    }

    private static WeaponTexture makeWeaponTexture(String fileName, Vector2 connectionPoint){
        Texture texture = new Texture(Gdx.files.internal(fileName));
        return new WeaponTexture(texture, connectionPoint.set(connectionPoint.x, texture.getHeight()-connectionPoint.y));
    }
}
