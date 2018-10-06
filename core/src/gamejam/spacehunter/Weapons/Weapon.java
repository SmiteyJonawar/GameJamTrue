package gamejam.spacehunter.Weapons;

import gamejam.spacehunter.AbstractCard;

public class Weapon {
    private AbstractCard equippedCard;
    private float posX;
    private float posY;

    public Weapon(AbstractCard card, float x, float y){
        this.posX = x;
        this.posY = y;
        this.equippedCard = card;
    }

    public AbstractCard getEquippedCard() {
        return equippedCard;
    }

    public void setEquippedCard(AbstractCard equippedCard) {
        this.equippedCard = equippedCard;
    }

    public float getPosX() {
        return posX;
    }

    public void setPosX(float posX) {
        this.posX = posX;
    }

    public float getPosY() {
        return posY;
    }

    public void setPosY(float posY) {
        this.posY = posY;
    }
}
