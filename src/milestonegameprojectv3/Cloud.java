package milestonegameprojectv3;

import city.cs.engine.BodyImage;
import city.cs.engine.PolygonShape;
import city.cs.engine.Shape;
import city.cs.engine.StaticBody;
import city.cs.engine.World;

/**
 * * A cloud.**
 */
public class Cloud extends StaticBody {

    private static final Shape CloudShape = new PolygonShape(0.58f, 3.91f, -3.05f, 3.0f, -3.04f, 1.17f, -0.53f, -2.72f, 3.09f, 1.14f, 3.09f, 2.07f, 0.95f, 3.9f);
    private static final BodyImage image = new BodyImage("data/Cloud.gif", 7.8f);

    /**
     * Construct a cloud.** @param world the world in which this body exists.*
     */
    public Cloud(World world) {
        super(world, CloudShape);
        addImage(image);
    }
}
