package gamejam.spacehunter.cards;

import gamejam.spacehunter.AbstractCard;

public class Railgun extends AbstractCard {

    public Railgun()
    {
        this.ID = AbstractCard.GetID();
        this.Cooldown = 0;
        this.CastTime = 0.65f;
        this.Damage = 15;
        this.Name = "Railgun";
        this.MultiHit = false;
    }
}
