package gamejam.spacehunter;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import gamejam.spacehunter.Weapons.Weapon;
import gamejam.spacehunter.Weapons.WeaponTexture;

import java.util.ArrayList;
import java.util.List;

public class ShipTexture {

    private Texture shipTexture;
    private List<Vector2> connectionPoints;

    private Vector2 workVector = new Vector2();

    public ShipTexture(Texture texture, List<Vector2> connectionPoints){
        shipTexture = texture;
        this.connectionPoints = connectionPoints;
    }

    public Texture getTexture(){
        return shipTexture;
    }

    public void render(SpriteBatch sb, Vector2 pos, ArrayList<Weapon> weaponTextures, boolean flipped){

        if (weaponTextures.size() > connectionPoints.size()){
            throw new IllegalArgumentException("More weapons than connection points!");
        }

        if (!flipped) {
            sb.draw(shipTexture, pos.x, pos.y);
        }else {
            sb.draw(shipTexture, pos.x + shipTexture.getWidth(), pos.y, -shipTexture.getWidth(), shipTexture.getHeight());
        }

        if (!flipped){
            for (int i = 0; i < weaponTextures.size(); i++) {
                WeaponTexture weaponTexture = weaponTextures.get(i).getWeaponTexture();
                weaponTexture.render(sb, workVector.set(pos).add(connectionPoints.get(i)), false);
            }
        }else {
            for (int i = 0; i < weaponTextures.size(); i++) {
                WeaponTexture weaponTexture = weaponTextures.get(i).getWeaponTexture();
                weaponTexture.render(sb, workVector.set(pos).add(connectionPoints.get(i)).add(shipTexture.getWidth() - connectionPoints.get(i).x * 2, 0), true);
            }
        }
    }

}
