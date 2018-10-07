package gamejam.spacehunter;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import gamejam.spacehunter.Weapons.Weapon;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractShip {
    protected BitmapFont font = new BitmapFont();
    protected BitmapFont font2 = new BitmapFont();
    protected float processATB = 500;
    protected float HP = 10;
    protected float MaxHP = 10;
    protected float Initiative = 1;
    protected float Speed = 1;
    protected float process = 0;
    protected List<AbstractCard> Iventory = new ArrayList<AbstractCard>();
    protected boolean Attacking = false;
    protected boolean readyToAttack = false;
    protected String Name = "Default";
    private static int IDCounter = 200;
    protected int ID = 0;
    private Vector2 position = new Vector2(0,0);
    protected World world;
    private ShipTexture shipTexture;
    public ArrayList<Weapon> weaponArrayList = new ArrayList<Weapon>();
    public AbstractCard card;
    public AbstractShip target;

    public static int GetID()
    {
        return IDCounter++;
    }

    public abstract void Shoot(AbstractCard card, AbstractShip target);

    public abstract void OnHit(AbstractCard card);

    public void updateProcess(){
        Initiative += getSpeed();
        if(Initiative >= processATB){
            readyToAttack = true;
            attack();
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

    public void setPosition(Vector2 v){
        position.set(v);
    }

    public void setPosition(float x, float y){
        position.set(x,y);
    }

    public Vector2 getPosition(){
        return position;
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

    public boolean isReadyToAttack() {
        return readyToAttack;
    }

    public void fireIfReady(){
        card.charge();
        if(card.fullyCharged()){
            Shoot(card,target);

        }
    }

    public void setReadyToAttack(boolean readyToAttack) {
        this.readyToAttack = readyToAttack;
    }

    public ShipTexture getShipTexture() {
        return shipTexture;
    }

    public void setShipTexture(ShipTexture shipTexture) {
        this.shipTexture = shipTexture;
    }

    public void render(ShapeRenderer sr, SpriteBatch sb){
        font.getData().setScale(10);
        font2.getData().setScale(10);
        font2.setColor(Color.CYAN);
        font.draw(sb, (int)((getInitiative()/processATB)*100) + "%", position.x, position.y);

        if(card != null){

            font2.draw(sb, (int)((card.currentTime/card.CastTime)*100) + "%", position.x + 500, position.y);
        }
        else{
            font2.draw(sb, "0%", position.x+ 500, position.y);
        }

        sb.end();
        sr.begin(ShapeRenderer.ShapeType.Filled);
        int HPWidth = 1000;
        int HPHeight = 50;

        sr.setColor(Color.RED);
        sr.rect(position.x + shipTexture.getTexture().getWidth()/2 - HPWidth/2, position.y + HPHeight + 50 + shipTexture.getTexture().getHeight(), HPWidth, HPHeight);

        sr.setColor(Color.GREEN);
        sr.rect(position.x + shipTexture.getTexture().getWidth()/2 - HPWidth/2, position.y + HPHeight + 50 + shipTexture.getTexture().getHeight(), HPWidth*getHP()/getMaxHP(), HPHeight);

        sr.end();
        sb.begin();
    }
}
