package gamejam.spacehunter;

import java.util.ArrayList;

public class Enemy extends AbstractShip {

    public Enemy(){
        this.MaxHP = 5;
        this.HP = 5;
        this.ID = AbstractShip.GetID();
        this.Initiative = 0;
        this.Iventory = new ArrayList<AbstractCard>();
        this.Name = "Noosey";
        this.Speed = 1;
        this.Attacking = false;
    }

    @Override
    public void Shoot(AbstractCard card, AbstractShip target) {
        target.OnHit(card);
    }

    @Override
    public void OnHit(AbstractCard card) {
        this.HP -= card.Damage;
    }
}
