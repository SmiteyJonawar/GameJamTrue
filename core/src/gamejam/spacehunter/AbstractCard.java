package gamejam.spacehunter;

import com.badlogic.gdx.graphics.Texture;

public class AbstractCard {
    public int ID;
    public float Damage;
    public float CastTime;
    public float Cooldown;
    public boolean MultiHit;
    public String Name;
    public Texture texture;

    private static int IdCounter = 100;

    public static int GetID()
    {
        return IdCounter++;
    }
}
