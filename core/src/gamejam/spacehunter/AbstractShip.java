package gamejam.spacehunter;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractShip {
    protected float processATB = 100;
    protected float HP = 10;
    protected float MaxHP = 10;
    protected float Initiative = 1;
    protected float Speed = 1;
    protected float process = 0;
    protected List<AbstractCard> Iventory = new ArrayList<AbstractCard>();
    protected boolean Attacking = false;
    protected String Name = "Default";
    private static int IDCounter = 200;
    protected int ID = 0;
    private float posX;
    private float posY;
    private int height;
    private int width;
    protected World world;
    public Texture texture;

    public static int GetID()
    {
        return IDCounter++;
    }

    public abstract void Shoot(AbstractCard card, AbstractShip target);

    public abstract void OnHit(AbstractCard card);

    public void updateProcess(){
        Initiative += getSpeed();
        if(Initiative >= processATB){
            Attacking = true;
        }
    }

    public abstract void attack();

    public float getHP() {
        return HP;
    }

    public void setHP(float HP) {
        this.HP = HP;
    }

    public float getMaxHP() {
        return MaxHP;
    }

    public void setMaxHP(float maxHP) {
        MaxHP = maxHP;
    }

    public float getInitiative() {
        return Initiative;
    }

    public void setInitiative(float initiative) {
        Initiative = initiative;
    }

    public float getSpeed() {
        return Speed;
    }

    public void setSpeed(float speed) {
        Speed = speed;
    }

    public List<AbstractCard> getIventory() {
        return Iventory;
    }

    public void setIventory(List<AbstractCard> iventory) {
        Iventory = iventory;
    }

    public boolean isAttacking() {
        return Attacking;
    }

    public void setAttacking(boolean attacking) {
        Attacking = attacking;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
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

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public float getProcess() {
        return process;
    }

    public void setProcess(float process) {
        this.process = process;
    }

    public float getProcessATB() {
        return processATB;
    }

    public void setWorld(World world) {
        this.world = world;
    }

    public abstract  void render(SpriteBatch sb);
}
