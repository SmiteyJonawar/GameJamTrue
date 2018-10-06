package gamejam.spacehunter;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;

public class ShipFactory {

    public static ShipTexture createShip(String name){
        if (name.equals("simpleUnit")){
            final Texture texture = new Texture(Gdx.files.internal("SimpleUnit.png"));
            return new ShipTexture(texture, new ArrayList<Vector2>(){{
                add(new Vector2(125,texture.getHeight()-99));
            }});
        }else if (name.equals("heroShip")){
            final Texture texture = new Texture(Gdx.files.internal("HeroShip.png"));
            return new ShipTexture(texture, new ArrayList<Vector2>(){{
                add(new Vector2(493,texture.getHeight()-348));
                add(new Vector2(1352,texture.getHeight()-396));
            }});
        }else if (name.equals("motherShip")){
            final Texture texture = new Texture(Gdx.files.internal("Mothership.png"));
            return new ShipTexture(texture, new ArrayList<Vector2>(){{
                add(new Vector2(610,texture.getHeight()-156));
                add(new Vector2(380,texture.getHeight()-753));
                add(new Vector2(639,texture.getHeight()-1156));
            }});
        }else if (name.equals("finalBoss")){
            final Texture texture = new Texture(Gdx.files.internal("FinalBoss.png"));
            return new ShipTexture(texture, new ArrayList<Vector2>(){{
                add(new Vector2(238,texture.getHeight()-128));
                add(new Vector2(694,texture.getHeight()-129));
                add(new Vector2(694,texture.getHeight()-528));
                add(new Vector2(899,texture.getHeight()-312));
            }});
        }

        throw new IllegalArgumentException("Ship does not exist!");
    }

}
