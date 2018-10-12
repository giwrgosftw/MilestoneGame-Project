package milestonegameprojectv3;

import city.cs.engine.*;

public class Water extends StaticBody {

    /**
     * * Water.*
     */
    public Water(World world) {
        super(world, new BoxShape(6f, 1f));
        addImage(new BodyImage("data/Water.gif", 10f));
    }
}
