package milestonegameprojectv3;

import city.cs.engine.*;

/**
 * * A blank.*
 */
public class Blank extends StaticBody {

    public Blank(World world) {
        super(world, new BoxShape(29f, 1f));
        addImage(new BodyImage("data/Blank.png", 3f));
    }
}
