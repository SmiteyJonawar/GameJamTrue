package gamejam.spacehunter;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractShip {
    public float HP = 10;
    public float MaxHP = 10;
    public float Initiative = 1;
    public float Speed = 1;
    public List<AbstractCard> Iventory = new ArrayList<AbstractCard>();
    public boolean Attacking = false;
    public String Name = "Default";
    private static int IDCounter = 200;
    public int ID = 0;

    public static int GetID()
    {
        return IDCounter++;
    }

    public abstract void Shoot(AbstractCard card, AbstractShip target);

    public abstract void OnHit(AbstractCard card);

}
