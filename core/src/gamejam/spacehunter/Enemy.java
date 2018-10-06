package gamejam.spacehunter;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import gamejam.spacehunter.Weapons.WeaponTexture;

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
        e.setMaxHP(5);
        e.setHP(e.getMaxHP());
        e.setSpeed(1);

        e.setShipTexture(ship);

        e.setPosition(x, y);

        return e;
    }

    public Enemy(){
        this.MaxHP = 5;
        this.HP = 5;
        this.ID = AbstractShip.GetID();
        this.Initiative = 0;
        this.Iventory = new ArrayList<AbstractCard>();
        this.Name = "Noosey";
        this.Speed = 1;
        this.Attacking = false;
    }

    @Override
    public void Shoot(AbstractCard card, AbstractShip target) {
        target.OnHit(card);
    }

    @Override
    public void OnHit(AbstractCard card) {
        this.HP -= card.Damage;
    }

    @Override
    public void attack() {
        if(!Iventory.isEmpty()){
            Shoot(Iventory.get(0),world.getPlayer());
        }
    }

    List<WeaponTexture> empty = new ArrayList<WeaponTexture>();

    @Override
    public void render(SpriteBatch sb) {
        getShipTexture().render(sb, getPosition(), empty, false);
    }
}
