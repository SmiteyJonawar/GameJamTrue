package gamejam.spacehunter.Weapons;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class WeaponFactory {
    public static WeaponTexture createTexture(String name){
        if (name.equals("doubleJimmy")){
            Texture texture = new Texture(Gdx.files.internal("DoubleJimmy.png"));
            return new WeaponTexture(texture, new Vector2(398,158));
        }

        throw new IllegalArgumentException("weapon does not exist");
    }
}
