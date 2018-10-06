package gamejam.spacehunter;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;

public class ShipFactory {

    public static ShipTexture createShip(String name){
        if (name.equals("simpleUnit")){
            Texture texture = new Texture(Gdx.files.internal("SimpleUnit.png"));
            return new ShipTexture(texture, new ArrayList<Vector2>(){{
                add(new Vector2(125,99));
            }});
        }else if (name.equals("heroShip")){
            Texture texture = new Texture(Gdx.files.internal("HeroShip.png"));
            return new ShipTexture(texture, new ArrayList<Vector2>(){{
                add(new Vector2(493,348));
                add(new Vector2(1352,396));
            }});
        }

        throw new IllegalArgumentException("Ship does not exist!");
    }

}
