package gamejam.spacehunter;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import gamejam.spacehunter.Weapons.Weapon;
import gamejam.spacehunter.cards.CannonBlaze;
import gamejam.spacehunter.cards.LightShower;
import gamejam.spacehunter.cards.LightningBolt;
import gamejam.spacehunter.cards.Railgun;

import java.util.ArrayList;
import java.util.HashMap;

public class Player extends AbstractShip{


    public HashMap<Integer, AbstractCard> cards = new HashMap<Integer, AbstractCard>();
    public ArrayList<Weapon> weaponArrayList = new ArrayList<Weapon>();

    public Player(){

        this.MaxHP = 20;
        this.HP = 20;
        this.ID = AbstractShip.GetID();
        this.Initiative = 0;
        this.Iventory = new ArrayList<AbstractCard>();
        this.Name = "Space Slayer 69";
        this.Speed = 1;
        this.Attacking = false;
        fillInventory();
        texture = new Texture(Gdx.files.internal("HeroShip.png"));

        setWidth(texture.getWidth()/4);
        setHeight(texture.getHeight()/4);

        setPosX(100);
        setPosY(Gdx.graphics.getHeight()/2 - getHeight()/2);
        System.out.println(getPosY());
    }

    private void fillInventory(){
        cards.put(Keys.NUM_1, new Railgun());
        cards.put(Keys.NUM_2, new LightningBolt());
        cards.put(Keys.NUM_3, new LightShower());
        cards.put(Keys.NUM_4, new CannonBlaze());
    }

    public void fireWeapon(int card, AbstractShip target){
        Shoot(cards.get(card), target);
    }

    @Override
    public void Shoot(AbstractCard card, AbstractShip target) {
            target.setHP(target.getHP()-card.Damage);
    }

    @Override
    public void OnHit(AbstractCard card) {
        this.HP -= card.Damage;
    }

    @Override
    public void render(SpriteBatch sb) {
        {
            sb.draw(texture, this.getPosX() + getWidth(), this.getPosY(), -getWidth(), getHeight());
        }
    }
}
