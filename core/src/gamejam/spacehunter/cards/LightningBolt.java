package gamejam.spacehunter.cards;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import gamejam.spacehunter.AbstractCard;

public class LightningBolt extends AbstractCard {
    public LightningBolt()
    {
        this.ID = AbstractCard.GetID();
        this.Cooldown = 0;
        this.CastTime = 0.50f;
        this.Damage = 20;
        this.Name = "Lightning Bolt";
        this.MultiHit = false;
        texture = new Texture(Gdx.files.internal("SingleTemplate.png"));
    }

}
