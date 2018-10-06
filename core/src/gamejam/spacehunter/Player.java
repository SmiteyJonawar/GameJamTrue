package gamejam.spacehunter;

import java.util.ArrayList;

public class Player extends AbstractShip{

    public float speedSonicOP = 25;
    public float notSoFast = 14;
    public float joji = 10;
    //public Dictionary<KeyCode, AbstractCard> Cards = new Dictionary<KeyCode, AbstractCard>();

    public Player(){
        this.MaxHP = 20;
        this.HP = 20;
        this.ID = AbstractShip.GetID();
        this.Initiative = 0;
        this.Iventory = new ArrayList<AbstractCard>();
        this.Name = "Space Slayer 69";
        this.Speed = 1;
        this.Attacking = false;

    }

    @Override
    public void Shoot(AbstractCard card, AbstractShip target) {
        this.HP -= card.Damage;
    }

    @Override
    public void OnHit(AbstractCard card) {

    }
}
