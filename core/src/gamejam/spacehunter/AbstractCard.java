package gamejam.spacehunter;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class AbstractCard {
    public int ID;
    public float Damage;
    public float CastTime;
    public float Cooldown;
    public boolean MultiHit;
    public String Name;
    public Texture texture;
    public TextureRegion tr;

    private static int IdCounter = 100;

    public static int GetID()
    {
        return IdCounter++;
    }

    protected TextureRegion makeTextureRegion() {
        TextureRegion tr = new TextureRegion(texture, 0, 0, texture.getWidth(), texture.getHeight());
        //tr.flip(false, true);
        return tr;
    }

}
