package gamejam.spacehunter;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import gamejam.spacehunter.Weapons.Weapon;
import gamejam.spacehunter.Weapons.WeaponFactory;
import gamejam.spacehunter.Weapons.WeaponTexture;
import gamejam.spacehunter.cards.CardFactory;
import gamejam.spacehunter.cards.CardTypeEnum;

import java.util.ArrayList;
import java.util.List;

public class Enemy extends AbstractShip {

    public static Enemy bigEnemy(ShipTexture ship, int x, int y){
        Enemy e = new Enemy();
        e.setName("Booette");
        e.setMaxHP(20);
        e.setHP(e.getMaxHP());
        e.setSpeed(2);

        e.setShipTexture(ship);

        e.setPosition(x, y);

        return e;
    }

    public static Enemy smallEnemy(ShipTexture ship, int x, int y){
        Enemy e = new Enemy();
        e.setName("Booette");
        e.setMaxHP(51);
        e.setHP(e.getMaxHP());
        e.setSpeed(4);

        e.setShipTexture(ship);

        e.setPosition(x, y);

        e.weaponArrayList.add(new Weapon(CardFactory.create(CardTypeEnum.Flashcannon), WeaponFactory.createTexture("flashCannon"), 0, 0));

        return e;
    }

    public Enemy(){
        this.MaxHP = 50;
        this.HP = 50;
        this.ID = AbstractShip.GetID();
        this.Initiative = 0;
        this.Iventory = new ArrayList<AbstractCard>();

        this.Name = "Noosey";
        this.Speed = 4;
        this.Attacking = false;
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
        setReadyToAttack(false);
        this.card = weaponArrayList.get(0).getEquippedCard();
        this.target = world.getPlayer();
        setAttacking(true);
    }

    @Override
    public void render(ShapeRenderer sr, SpriteBatch sb) {
        super.render(sr, sb);
        getShipTexture().render(sb, getPosition(), weaponArrayList, false);
    }
}
