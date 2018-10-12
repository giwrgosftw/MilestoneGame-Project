package milestonegameprojectv3;

import city.cs.engine.BodyImage;
import city.cs.engine.PolygonShape;
import city.cs.engine.Shape;
import city.cs.engine.StaticBody;
import city.cs.engine.World;

/**
 * * A pokemon character called Rayquaza.*
 */
public class Rayquaza extends StaticBody {

    private static final Shape RayquazaShape = new PolygonShape(0.75f, 5.55f, -5.4f, -1.1f, -5.36f, -4.28f, 5.12f, -4.42f, 1.83f, 6.02f);
    private static final BodyImage image = new BodyImage("data/Rayquaza.gif", 13f);

    public Rayquaza(World world) {
        super(world, RayquazaShape);
        addImage(image);
    }

}
