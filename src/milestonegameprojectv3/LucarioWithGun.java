package milestonegameprojectv3;

import city.cs.engine.BodyImage;
import city.cs.engine.PolygonShape;
import city.cs.engine.Shape;
import city.cs.engine.StaticBody;
import city.cs.engine.World;

/**
 * * A pokemon character called Lucario.**
 */
public class LucarioWithGun extends StaticBody {

    private static final Shape LucarioWithGunShape = new PolygonShape(-4.63f, 0.85f, -4.68f, -1.76f, -2.27f, -1.78f, 3.53f, -0.47f, 3.51f, 0.77f, -4.39f, 0.85f);
    private static final BodyImage image = new BodyImage("data/LucarioWithGun.gif", 3.6f);

    /**
     * Construct the enemy.** @param world the world in which this body exists.*
     */
    public LucarioWithGun(World world) {
        super(world, LucarioWithGunShape);
        addImage(image);
    }
}
