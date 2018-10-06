package gamejam.spacehunter;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import gamejam.spacehunter.Weapons.Weapon;
import gamejam.spacehunter.Weapons.WeaponTexture;
import gamejam.spacehunter.cards.CannonBlaze;
import gamejam.spacehunter.cards.LightShower;
import gamejam.spacehunter.cards.LightningBolt;
import gamejam.spacehunter.cards.Railgun;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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

        setShipTexture(ShipFactory.createShip("heroShip"));

        setPosition(100, Gdx.graphics.getHeight()*2 - getShipTexture().getTexture().getHeight()/2);

        createWeapons();
    }

    private void createWeapons(){
        weaponArrayList.add(new Weapon(new Railgun(), Gdx.graphics.getWidth()/6, Gdx.graphics.getHeight()/4));
        weaponArrayList.add(new Weapon(new LightShower(), 2*Gdx.graphics.getWidth()/6, Gdx.graphics.getHeight()/4));
        weaponArrayList.add(new Weapon(new LightningBolt(), 3*Gdx.graphics.getWidth()/6, Gdx.graphics.getHeight()/4));
        weaponArrayList.add(new Weapon(new CannonBlaze(), 4*Gdx.graphics.getWidth()/6, Gdx.graphics.getHeight()/4));
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
    public void attack() {

    }

    List<WeaponTexture> empty = new ArrayList<WeaponTexture>();
    @Override
    public void render(SpriteBatch sb) {
        getShipTexture().render(sb, getPosition(), empty, true);
    }
}
