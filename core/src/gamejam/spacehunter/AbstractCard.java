package gamejam.spacehunter;

public class AbstractCard {
    public int ID;
    public float Damage;
    public float CastTime;
    public float Cooldown;
    public boolean MultiHit;
    public String Name;

    private static int IdCounter = 100;

    public static int GetID()
    {
        return IdCounter++;
    }
}
