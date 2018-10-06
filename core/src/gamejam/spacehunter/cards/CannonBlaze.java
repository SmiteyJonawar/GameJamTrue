package gamejam.spacehunter.cards;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
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
        cardTexture = new Texture(Gdx.files.internal("SingleTemplate.png"));
    }
}
