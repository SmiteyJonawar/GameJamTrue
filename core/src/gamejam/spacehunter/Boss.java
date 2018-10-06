package gamejam.spacehunter;

import gamejam.spacehunter.AbstractShip;

public class Boss extends Enemy {
    @Override
    public void Shoot(AbstractCard card, AbstractShip target) {
        target.OnHit(card);
    }

    @Override
    public void OnHit(AbstractCard card) {
        this.HP -= card.Damage;
    }
}
