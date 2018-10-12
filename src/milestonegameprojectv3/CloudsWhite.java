package milestonegameprojectv3;

import city.cs.engine.BodyImage;
import city.cs.engine.PolygonShape;
import city.cs.engine.Shape;
import city.cs.engine.StaticBody;
import city.cs.engine.World;

/**
 * * A white cloud.**
 */
public class CloudsWhite extends StaticBody {

    private static final Shape CloudsWhiteShape = new PolygonShape(-3.79f, 1.75f, -2.37f, -1.37f, 1.37f, -1.98f, 3.8f, 0.05f, 3.61f, 1.79f, -3.34f, 2.62f);
    private static final BodyImage image = new BodyImage("data/CloudsWhite.gif", 5.7f);

    /**
     * Construct a white cloud.** @param world the world in which this body
     * exists.*
     */
    public CloudsWhite(World world) {
        super(world, CloudsWhiteShape);
        addImage(image);
    }
}
