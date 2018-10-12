package milestonegameprojectv3;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

/**
 * * Collision listener that the main character loses life.**
 */
public class LoseLife implements CollisionListener {

    private MainCharacter mainCharacter;

    public LoseLife(MainCharacter mainCharacter) {
        this.mainCharacter = mainCharacter;
    }

    @Override
    public void collide(CollisionEvent e) {

        if (e.getReportingBody() instanceof PikachuWithGun && e.getOtherBody() == mainCharacter) {
            mainCharacter.LoseLifeSound();
            System.out.println("collision with PikachuWithGun!!");
            mainCharacter.decrementLiveCount();

            if (mainCharacter.getLiveCount() <= 0) {
                mainCharacter.destroy();
            }
        } else if (e.getReportingBody() instanceof LucarioWithGun && e.getOtherBody() == mainCharacter) {
            mainCharacter.LoseLifeSound();
            System.out.println("collision with LucarioWithGun!!");
            mainCharacter.decrementLiveCount();

            if (mainCharacter.getLiveCount() <= 0) {
                mainCharacter.destroy();
            }
        } else if (e.getReportingBody() instanceof Cloud && e.getOtherBody() == mainCharacter) {
            mainCharacter.LoseLifeSound();
            System.out.println("collision with Cloud!!");
            mainCharacter.decrementLiveCount();

            if (mainCharacter.getLiveCount() <= 0) {
                mainCharacter.destroy();
            }
        } else if (e.getReportingBody() instanceof Rocket && e.getOtherBody() == mainCharacter) {
            mainCharacter.LoseLifeSound();
            System.out.println("OH NO!YOU HAVE EXPLODED!!");
            mainCharacter.LiveCount = 0;
            mainCharacter.LifeZero();
            e.getReportingBody().destroy();
            mainCharacter.destroy();
        } else if (e.getReportingBody() instanceof Zaptos && e.getOtherBody() == mainCharacter) {
            mainCharacter.LoseLifeSound();
            System.out.println("collision with Zaptos!!");
            mainCharacter.decrementLiveCount();

            if (mainCharacter.getLiveCount() <= 0) {
                mainCharacter.destroy();
            }
        } else if (e.getReportingBody() instanceof Articuno && e.getOtherBody() == mainCharacter) {
            mainCharacter.LoseLifeSound();
            System.out.println("collision with Articuno!!");
            mainCharacter.decrementLiveCount();

            if (mainCharacter.getLiveCount() <= 0) {
                mainCharacter.destroy();
            }
        } else if (e.getReportingBody() instanceof Moltres && e.getOtherBody() == mainCharacter) {
            mainCharacter.LoseLifeSound();
            System.out.println("collision with Moltres!!");
            mainCharacter.decrementLiveCount();

            if (mainCharacter.getLiveCount() <= 0) {
                mainCharacter.destroy();
            }
        } else if (e.getReportingBody() instanceof Lugia && e.getOtherBody() == mainCharacter) {
            mainCharacter.LoseLifeSound();
            System.out.println("collision with Lugia!!");
            mainCharacter.decrementLiveCount();

            if (mainCharacter.getLiveCount() <= 0) {
                mainCharacter.destroy();
            }
        } else if (e.getReportingBody() instanceof Rayquaza && e.getOtherBody() == mainCharacter) {
            mainCharacter.LoseLifeSound();
            System.out.println("collision with Rayquaza!!");
            mainCharacter.decrementLiveCount();

            if (mainCharacter.getLiveCount() <= 0) {
                mainCharacter.destroy();
            }
        } else if (e.getReportingBody() instanceof Kyogre && e.getOtherBody() == mainCharacter) {
            mainCharacter.LoseLifeSound();
            System.out.println("collision with Kyogre!!");
            mainCharacter.decrementLiveCount();

            if (mainCharacter.getLiveCount() <= 0) {
                mainCharacter.destroy();
            }
        } else if (e.getReportingBody() instanceof Groudon && e.getOtherBody() == mainCharacter) {
            mainCharacter.LoseLifeSound();
            System.out.println("collision with Groudon!!");
            mainCharacter.decrementLiveCount();

            if (mainCharacter.getLiveCount() <= 0) {
                mainCharacter.destroy();
            }
        } else if (e.getReportingBody() instanceof Fireball && e.getOtherBody() == mainCharacter) {
            mainCharacter.LoseLifeSound();
            System.out.println("collision with Firaball!!");
            mainCharacter.decrementLiveCount();

            if (mainCharacter.getLiveCount() <= 0) {
                mainCharacter.destroy();
            }
        } else if (e.getReportingBody() instanceof Blank && e.getOtherBody() == mainCharacter) {
            mainCharacter.LoseLifeSound();
            mainCharacter.LiveCount = 0;
            mainCharacter.LifeZero();
            System.out.println("OH NO YOU FALL DOWN! YOU LOSE!!!");
            mainCharacter.destroy();

        } else if (e.getReportingBody() instanceof Water && e.getOtherBody() == mainCharacter) {
            mainCharacter.LoseLifeSound();
            mainCharacter.LiveCount = 0;
            mainCharacter.LifeZero();
            System.out.println("OH NO YOU FALL DOWN! YOU LOSE!!!");
            mainCharacter.destroy();
        }

    }
}

/**
 * When bodies collide (or more precisely their solid fixtures collide), the
 * physics engine will make them bounce and handle any friction. If you want
 * something else to happen, you'll need to use a collision listener. (etc the
 * main character loses life when the body of the main character collides with
 * an enemy). Whenever two bodies collide, each of them reports the collision to
 * any object that is listening. The CollisionEvent object contains data about
 * the collision from the point of view of the body reporting it. The same
 * collision will be reported by the other body with the same data, but from the
 * opposite point of view.*
 */
