package milestonegameprojectv3;

import city.cs.engine.BodyImage;
import city.cs.engine.PolygonShape;
import city.cs.engine.Shape;
import city.cs.engine.StaticBody;
import city.cs.engine.World;

/**
 * * A pokemon character called Moltres.*
 */
public class Moltres extends StaticBody {

    private static final Shape MoltresShape = new PolygonShape(-0.1f, 2.76f, -3.32f, -0.43f, -0.28f, -3.36f, 3.93f, 0.84f, 0.48f, 2.74f);
    private static final BodyImage image = new BodyImage("data/Moltres.gif", 8f);

    /**
     * Construct the enemy.** @param world the world in which this body exists.*
     */
    public Moltres(World world) {
        super(world, MoltresShape);
        addImage(image);
    }
}
