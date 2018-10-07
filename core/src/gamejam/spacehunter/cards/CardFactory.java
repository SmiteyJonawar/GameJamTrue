package gamejam.spacehunter.cards;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import gamejam.spacehunter.AbstractCard;

public class CardFactory {

    public static AbstractCard create(CardTypeEnum type){
        AbstractCard aCard = new AbstractCard();
        switch (type) {
            case BigBertha:
                aCard.Damage = 15;
                aCard.CastTime = 0;
                aCard.Cooldown = 0;
                aCard.MultiHit = false;
                aCard.Name = type.toString();
                aCard.cardTexture = new Texture(Gdx.files.internal("SingleTemplate.png"));
                //aCard.weaponTexture = new Texture(Gdx.files.internal("BigBertha.png"));
                return aCard;
            case Blaster:
                aCard.Damage = 16;
                aCard.CastTime = 0;
                aCard.Cooldown = 0;
                aCard.MultiHit = false;
                aCard.Name = type.toString();
                aCard.cardTexture = new Texture(Gdx.files.internal("SingleTemplate.png"));
                //aCard.weaponTexture = new Texture(Gdx.files.internal("Blaster.png"));
                return aCard;
            case DoubleBlaster:
                aCard.Damage = 17;
                aCard.CastTime = 0;
                aCard.Cooldown = 0;
                aCard.MultiHit = false;
                aCard.Name = type.toString();
                aCard.cardTexture = new Texture(Gdx.files.internal("SingleTemplate.png"));
                //aCard.weaponTexture = new Texture(Gdx.files.internal("DoubleBlaster.png"));
                return aCard;
            case DoubleJimmy:
                aCard.Damage = 18;
                aCard.CastTime = 0;
                aCard.Cooldown = 0;
                aCard.MultiHit = false;
                aCard.Name = type.toString();
                aCard.cardTexture = new Texture(Gdx.files.internal("SingleTemplate.png"));
                //aCard.weaponTexture = new Texture(Gdx.files.internal("DoubleJimmy.png"));
                return aCard;
            case Flashcannon:
                aCard.Damage = 15;
                aCard.CastTime = 0;
                aCard.Cooldown = 0;
                aCard.MultiHit = false;
                aCard.Name = type.toString();
                aCard.cardTexture = new Texture(Gdx.files.internal("SingleTemplate.png"));
                //aCard.weaponTexture = new Texture(Gdx.files.internal("FlashCannon.png"));
                return aCard;
            case GattlingGun:
                aCard.Damage = 15;
                aCard.CastTime = 0;
                aCard.Cooldown = 0;
                aCard.MultiHit = false;
                aCard.Name = type.toString();
                aCard.cardTexture = new Texture(Gdx.files.internal("SingleTemplate.png"));
                //aCard.weaponTexture = new Texture(Gdx.files.internal("Gattlinggun.png"));
                return aCard;
            case Missle:
                aCard.Damage = 15;
                aCard.CastTime = 0;
                aCard.Cooldown = 0;
                aCard.MultiHit = false;
                aCard.Name = type.toString();
                aCard.cardTexture = new Texture(Gdx.files.internal("SingleTemplate.png"));
                //aCard.weaponTexture = new Texture(Gdx.files.internal("Missile.png"));
                return aCard;
            default:
                aCard.Damage = 15;
                aCard.CastTime = 0;
                aCard.Cooldown = 0;
                aCard.MultiHit = false;
                aCard.Name = "Sniper";
                aCard.cardTexture = new Texture(Gdx.files.internal("SingleTemplate.png"));
                //aCard.weaponTexture = new Texture(Gdx.files.internal("Sniper.png"));
                return aCard;
        }
    }
}
