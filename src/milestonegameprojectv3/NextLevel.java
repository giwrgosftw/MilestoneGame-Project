/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package milestonegameprojectv3;

import city.cs.engine.*;

public class NextLevel extends StaticBody {

    /**
     * Initialise a new level. @param world The world.*
     */
    public NextLevel(World world) {
        super(world, new BoxShape(2.25f, 1.25f));
        addImage(new BodyImage("data/NextLevel.png", 3f));
    }
}

/**
 * if the current level is complete the game is advanced to the next level. *
 */
