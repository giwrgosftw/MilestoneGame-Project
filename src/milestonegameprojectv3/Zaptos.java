package milestonegameprojectv3;

import city.cs.engine.BodyImage;
import city.cs.engine.PolygonShape;
import city.cs.engine.Shape;
import city.cs.engine.StaticBody;
import city.cs.engine.World;

/**
 * * A pokemon character called Zaptos.*
 */
public class Zaptos extends StaticBody {

    private static final Shape ZaptopsShape = new PolygonShape(-0.27f, 1.98f, -2.68f, 1.6f, -2.17f, -1.33f, 0.08f, -2.29f, 2.61f, 1.54f, -0.14f, 1.97f);
    private static final BodyImage image = new BodyImage("data/Zaptos.gif", 8f);

    /**
     * Construct the enemy.** @param world the world in which this body exists.*
     */
    public Zaptos(World world) {
        super(world, ZaptopsShape);
        addImage(image);
    }
}
