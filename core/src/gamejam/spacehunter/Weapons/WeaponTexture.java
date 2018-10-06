package gamejam.spacehunter.Weapons;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class WeaponTexture {

    private Texture weaponTexture;
    private Vector2 connectionPoint = new Vector2();

    public WeaponTexture(Texture texture, Vector2 connectionPoint){
        weaponTexture = texture;
        this.connectionPoint.set(connectionPoint);
    }

    public void render(SpriteBatch sb, Vector2 connectionPoint, boolean flipped){
        if (!flipped) {
            sb.draw(weaponTexture, connectionPoint.x - this.connectionPoint.x, connectionPoint.y - this.connectionPoint.y,
                    weaponTexture.getWidth(), weaponTexture.getHeight());
        }else{
            sb.draw(weaponTexture, connectionPoint.x - this.connectionPoint.x + weaponTexture.getWidth(), connectionPoint.y - this.connectionPoint.y,
                    -weaponTexture.getWidth(), weaponTexture.getHeight());
        }
    }
}
