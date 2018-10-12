package milestonegameprojectv3;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 * A level of the game.
 */
public abstract class MilestoneGameLevel extends World {

    private MainCharacter player;

    public MainCharacter getPlayer() {
        return player;
    }

    /**
     * Populate the world of this level. Child classes should this method with
     * additional bodies.*
     */
    public void populate(MilestoneGame milestoneGame) {
        player = new MainCharacter(this, milestoneGame);
        player.setPosition(startPosition());

        NextLevel nextLevel = new NextLevel(this); //Το πρώτο NextLevel είναι "τύπος μεταβλητής" (ανεξάρτητο από τα επόμενα 2 που μπορείς να τα ονομάσεις όπως θες)
        nextLevel.setPosition(NextLevelPosition());
        nextLevel.addCollisionListener(new NextLevelListener(milestoneGame));
    }

    /**
     * The initial position of the player.
     */
    public abstract Vec2 startPosition();

    /**
     * The position of the exit door.
     */
    public abstract Vec2 NextLevelPosition();

    /**
     * Is this level complete?
     */
    public abstract boolean isCompleted();

}
