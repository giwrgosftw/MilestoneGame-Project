package milestonegameprojectv3;

import city.cs.engine.BodyImage;
import city.cs.engine.PolygonShape;
import city.cs.engine.Shape;
import city.cs.engine.StaticBody;
import city.cs.engine.World;

/**
 * * A rocket.**
 */
public class Rocket extends StaticBody {

    private static final Shape RocketShape = new PolygonShape(0.59f, 1.95f, -1.49f, -0.89f, -0.9f, -2.46f, 0.66f, -1.84f, 1.44f, 1.76f);
    private static final BodyImage image = new BodyImage("data/Rocket.gif", 5f);

    /**
     * Construct a rocket.* @param world the world in which this body exists. *
     */
    public Rocket(World world) {
        super(world, RocketShape);
        addImage(image);
    }

}
