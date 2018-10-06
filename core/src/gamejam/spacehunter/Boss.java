package gamejam.spacehunter;

public class Boss extends Enemy {

    public Boss(){
        Enemy e = new Enemy();
        e.setMaxHP(50);
        e.setHP(50);
        e.setSpeed(3);
        e.setName("Bowsette");
    }

    @Override
    public void Shoot(AbstractCard card, AbstractShip target) {
        target.OnHit(card);
    }

    @Override
    public void OnHit(AbstractCard card) {
        this.HP -= card.Damage;
    }
}
