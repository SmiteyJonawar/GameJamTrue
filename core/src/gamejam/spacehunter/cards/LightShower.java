package gamejam.spacehunter.cards;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import gamejam.spacehunter.AbstractCard;

public class LightShower extends AbstractCard {
    public LightShower() {
        this.ID = AbstractCard.GetID();
        this.Cooldown = 0;
        this.CastTime = 0.75f;
        this.Damage = 10;
        this.Name = "Light Shower";
        this.MultiHit = true;
        cardTexture = new Texture(Gdx.files.internal("SingleTemplate.png"));
    }


}
