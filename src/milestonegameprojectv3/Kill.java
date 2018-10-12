package milestonegameprojectv3;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

public class Kill implements CollisionListener {

    private Fireblast fireBlast;

    public Kill(Fireblast fireBlast) {
        this.fireBlast = fireBlast;
    }

    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof PikachuWithGun) {
            e.getOtherBody().destroy();
            e.getReportingBody().destroy();
        } else if (e.getOtherBody() instanceof LucarioWithGun) {
            e.getOtherBody().destroy();
            e.getReportingBody().destroy();
        } else if (e.getOtherBody() instanceof Lugia) {
            e.getOtherBody().destroy();
            e.getReportingBody().destroy();
        } else if (!(e.getOtherBody() instanceof MainCharacter));
        e.getReportingBody().destroy();
    }

}

/**
 * When bodies collide (or more precisely their solid fixtures collide), the
 * physics engine will make them bounce and handle any friction. If you want
 * something else to happen, you'll need to use a collision listener. (etc the
 * fireblast kills the enemies when the body of the fireblast collides with an
 * enemy or fireblast destroy itself if it does not hit an enemy). Whenever two
 * bodies collide, each of them reports the collision to any object that is
 * listening. The CollisionEvent object contains data about the collision from
 * the point of view of the body reporting it. The same collision will be
 * reported by the other body with the same data, but from the opposite point of
 * view.*
 */
