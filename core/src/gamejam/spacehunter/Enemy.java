package gamejam.spacehunter;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;

public class Enemy extends AbstractShip {

    public static Enemy bigEnemy(Texture ship, int x, int y){
        Enemy e = new Enemy();
        e.setName("Booette");
        e.setMaxHP(20);
        e.setHP(e.getMaxHP());
        e.setSpeed(2);

        e.texture = ship;

        e.setPosX(x);
        e.setPosY(y);

        e.setWidth(ship.getWidth()/4);
        e.setHeight(ship.getHeight()/4);

        return e;
    }

    public static Enemy smallEnemy(Texture ship, int x, int y){
        Enemy e = new Enemy();
        e.setName("Booette");
        e.setMaxHP(5);
        e.setHP(e.getMaxHP());
        e.setSpeed(1);

        e.texture = ship;

        e.setPosX(x);
        e.setPosY(y);

        e.setWidth(ship.getWidth()/4);
        e.setHeight(ship.getHeight()/4);

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
    public void render(SpriteBatch sb) {
        sb.draw(texture, this.getPosX(), this.getPosY(), getWidth(), getHeight());
    }
}
