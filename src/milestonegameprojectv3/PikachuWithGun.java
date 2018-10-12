package milestonegameprojectv3;

import city.cs.engine.BodyImage;
import city.cs.engine.PolygonShape;
import city.cs.engine.Shape;
import city.cs.engine.StaticBody;
import city.cs.engine.World;

/**
 * * A pokemon character called Pikachu.**
 */
public class PikachuWithGun extends StaticBody {

    private static final Shape PikachuWithGunShape = new PolygonShape(-0.25f, 0.91f, -2.35f, 0.85f, -2.92f, -0.72f, -0.57f, -1.03f, 1.28f, -1.05f, 1.28f, 0.91f);
    private static final BodyImage image = new BodyImage("data/PikachuWithGun.gif", 5.5f);

    public PikachuWithGun(World world) {
        super(world, PikachuWithGunShape);
        addImage(image);
    }
}
