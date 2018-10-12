package milestonegameprojectv3;

import city.cs.engine.BodyImage;
import city.cs.engine.PolygonShape;
import city.cs.engine.Shape;
import city.cs.engine.StaticBody;
import city.cs.engine.World;

/**
 * * A pokemon character called Kyogre.*
 */
public class Kyogre extends StaticBody {

    private static final Shape KyogreShape = new PolygonShape(-0.39f, 1.72f, -6.89f, -0.17f, -0.3f, -1.39f, 6.85f, -0.13f, 0.26f, 1.72f);
    private static final BodyImage image = new BodyImage("data/Kyogre.gif", 15f);

    /**
     * Construct the enemy.** @param world the world in which this body exists.*
     */
    public Kyogre(World world) {
        super(world, KyogreShape);
        addImage(image);
    }
}
