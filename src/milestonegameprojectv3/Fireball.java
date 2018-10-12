package milestonegameprojectv3;

import city.cs.engine.BodyImage;
import city.cs.engine.CircleShape;
import city.cs.engine.Shape;
import city.cs.engine.StaticBody;
import city.cs.engine.World;

/**
 * * A fireball.**
 */
public class Fireball extends StaticBody {

    private static final float radius = 0.5f;
    private static final Shape FireballShape = new CircleShape(radius);
    private static final BodyImage fireballImage = new BodyImage("data/Fireball.png", 7f * radius);

    /**
     * Construct a fireball.* @param world the world in which this body exists.*
     */
    public Fireball(World world) {
        super(world, FireballShape);
        addImage(fireballImage);
    }
}
