package gamejam.spacehunter.cards;

import gamejam.spacehunter.AbstractCard;

public class CannonBlaze extends AbstractCard {

    public CannonBlaze()
    {
        this.ID = AbstractCard.GetID();
        this.Cooldown = 0;
        this.CastTime = 1.0f;
        this.Damage = 35;
        this.Name = "Cannon Blaze";
        this.MultiHit = false;
    }
}
