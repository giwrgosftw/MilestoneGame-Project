package milestonegameprojectv3;

import city.cs.engine.BodyImage;
import city.cs.engine.PolygonShape;
import city.cs.engine.Shape;
import city.cs.engine.StaticBody;
import city.cs.engine.World;

/**
 * * A pokemon character called Articuno.*
 */
public class Articuno extends StaticBody {

    private static final Shape ArticunoShape = new PolygonShape(-0.24f, 3.01f, -3.93f, 2.37f, 0.04f, -3.36f, 3.84f, 2.24f, 0.29f, 3.05f);
    private static final BodyImage image = new BodyImage("data/Articuno.gif", 9f);

    /**
     * Construct the enemy.** @param world the world in which this body exists.*
     */
    public Articuno(World world) {
        super(world, ArticunoShape);
        addImage(image);
    }
}
