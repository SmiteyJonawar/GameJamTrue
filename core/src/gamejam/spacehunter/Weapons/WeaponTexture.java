package gamejam.spacehunter.Weapons;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class WeaponTexture {

    private Texture weaponTexture;
    private Vector2 connectionPoint;

    public WeaponTexture(Texture texture, Vector2 connectionPoint){
        weaponTexture = texture;
        connectionPoint.set(connectionPoint);
    }

    public void render(SpriteBatch batch, Vector2 connectionPoint){

    }
}
