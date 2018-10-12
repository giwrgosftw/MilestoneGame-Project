/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package milestonegameprojectv3;

import city.cs.engine.BodyImage;
import city.cs.engine.PolygonShape;
import city.cs.engine.Shape;
import city.cs.engine.StaticBody;
import city.cs.engine.World;

/**
 * * A pokemon character called Lugia.**
 */
public class Lugia extends StaticBody {

    private static final Shape LugiaShape = new PolygonShape(-0.96f, 1.4f, -1.34f, -0.47f, 1.43f, -0.72f, 2.51f, 1.21f, -0.76f, 1.4f);
    private static final BodyImage image = new BodyImage("data/Lugia.gif", 8f);

    /**
     * Construct the enemy.** @param world the world in which this body exists.*
     */
    public Lugia(World world) {
        super(world, LugiaShape);
        addImage(image);
    }
}
