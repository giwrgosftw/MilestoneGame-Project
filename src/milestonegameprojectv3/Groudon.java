package milestonegameprojectv3;

import city.cs.engine.BodyImage;
import city.cs.engine.DynamicBody;
import city.cs.engine.PolygonShape;
import city.cs.engine.Shape;
import city.cs.engine.World;

/**
 * * A pokemon character called Groudon.*
 */
public class Groudon extends DynamicBody {

    private static final Shape GroudonShape = new PolygonShape(4.01f, 3.15f, -4.37f, 4.45f, -4.32f, -4.27f, 3.73f, -4.69f, 4.35f, 2.58f);
    private static final BodyImage image = new BodyImage("data/Groudon.gif", 10f);

    /**
     * Construct the enemy.** @param world the world in which this body exists.*
     */
    public Groudon(World world) {
        super(world, GroudonShape);
        addImage(image);
    }
}
