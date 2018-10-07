package gamejam.spacehunter;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import gamejam.spacehunter.Weapons.Weapon;
import gamejam.spacehunter.Weapons.WeaponFactory;
import gamejam.spacehunter.Weapons.WeaponTexture;
import gamejam.spacehunter.cards.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Player extends AbstractShip{

    public HashMap<Integer, AbstractCard> cards = new HashMap<Integer, AbstractCard>();

    public Player(){

        this.MaxHP = 200;
        this.HP = 200;
        this.ID = AbstractShip.GetID();
        this.Initiative = 0;
        this.Iventory = new ArrayList<AbstractCard>();
        this.Name = "Space Slayer 69";
        this.Speed = 3;
        this.Attacking = false;

        setShipTexture(ShipFactory.createShip("heroShip"));

        setPosition(100, Gdx.graphics.getHeight()*2 - getShipTexture().getTexture().getHeight()/2);

        createWeapons();
    }

    private void createWeapons(){
        weaponArrayList.add(new Weapon(CardFactory.create(CardTypeEnum.Missle), WeaponFactory.createTexture("doubleJimmy"), 4*Gdx.graphics.getWidth()/6, 100));
        weaponArrayList.add(new Weapon(CardFactory.create(CardTypeEnum.Blaster), WeaponFactory.createTexture("doubleJimmy"), 4*2*Gdx.graphics.getWidth()/6, 100));
        //weaponArrayList.add(new Weapon(CardFactory.create(CardTypeEnum.DoubleBlaster), WeaponFactory.createTexture("doubleJimmy"), 4*3*Gdx.graphics.getWidth()/6, 100));
        //weaponArrayList.add(new Weapon(CardFactory.create(CardTypeEnum.DoubleJimmy), WeaponFactory.createTexture("doubleJimmy"), 16*Gdx.graphics.getWidth()/6, 100));
    }

    public void fireWeapon(int weapon, AbstractShip target){
        this.card = weaponArrayList.get(weapon).getEquippedCard();
        this.target = target;
        readyToAttack = false;
        setAttacking(true);
    }

    @Override
    public void Shoot(AbstractCard card, AbstractShip target) {
        target.setHP(target.getHP()-card.Damage);
        setInitiative(0);
        readyToAttack = false;
        setAttacking(false);
    }

    @Override
    public void OnHit(AbstractCard card) {
        this.HP -= card.Damage;
    }

    @Override
    public void attack() {

    }

    @Override
    public void render(ShapeRenderer sr, SpriteBatch sb) {
        super.render(sr, sb);
        getShipTexture().render(sb, getPosition(), weaponArrayList, true);
    }
}
