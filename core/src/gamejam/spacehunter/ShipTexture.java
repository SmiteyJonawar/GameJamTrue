package gamejam.spacehunter;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import gamejam.spacehunter.Weapons.WeaponTexture;

import java.util.List;

public class ShipTexture {

    private Texture shipTexture;
    private List<Vector2> connectionPoints;

    private Vector2 workVector = new Vector2();

    public ShipTexture(Texture texture, List<Vector2> connectionPoints){
        shipTexture = texture;
        this.connectionPoints = connectionPoints;
    }

    public void render(SpriteBatch sb, Vector2 pos, List<WeaponTexture> weaponTextures, boolean flipped){

        if (weaponTextures.size() > connectionPoints.size()){
            throw new IllegalArgumentException("More weapons than connection points!");
        }

        if (flipped) {
            sb.draw(shipTexture, pos.x, pos.y, shipTexture.getWidth(), shipTexture.getHeight());
        }else {
            sb.draw(shipTexture, pos.x + shipTexture.getWidth(), pos.y, -shipTexture.getWidth(), shipTexture.getHeight());
        }

        for (int i = 0; i < weaponTextures.size(); i++) {
            WeaponTexture weaponTexture = weaponTextures.get(i);
            weaponTexture.render(sb, workVector.set(pos).add(connectionPoints.get(i)), flipped);
        }
    }

}
