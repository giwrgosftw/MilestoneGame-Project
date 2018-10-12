package milestonegameprojectv3;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

/**
 * * Collision listener that the main character win life.**
 */
public class WinLife implements CollisionListener {

    private MainCharacter mainCharacter;

    public WinLife(MainCharacter mainCharacter) {
        this.mainCharacter = mainCharacter;
    }

    @Override
    public void collide(CollisionEvent e) {

        if (e.getReportingBody() instanceof Potion && e.getOtherBody() == mainCharacter) {
            System.out.println("collision with potion!!");
            mainCharacter.incrementLiveCount();
            e.getReportingBody().destroy();
        }

    }
}





/**When bodies collide (or more precisely their solid fixtures collide), 
the physics engine will make them bounce and handle any friction. 
If you want something else to happen, you'll need to use a collision listener.
(etc the main character wins life when the body of the main character collides with a potion).
Whenever two bodies collide, each of them reports the collision to any object that is listening.
The CollisionEvent object contains data about the collision from the point of view of the body reporting it. 
The same collision will be reported by the other body with the same data, but from the opposite point of view.**/
