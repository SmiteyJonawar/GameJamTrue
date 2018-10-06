package gamejam.spacehunter.cards;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
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
        cardTexture = new Texture(Gdx.files.internal("SingleTemplate.png"));

    }
}
