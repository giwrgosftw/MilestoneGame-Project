package milestonegameprojectv3;

import city.cs.engine.*;
import java.awt.Color;
import org.jbox2d.common.Vec2;

/**
 * Level 3 of the game*
 */
public class Level3 extends MilestoneGameLevel {

    private static final int NUM_POKEBALLS = 6;
    Body fireball;
    Body rayquaza;
    Body kyogre;

    //inputs
    float vec2xCentre = 0.1f;
    float vec2yCentre = -8.5f;

    float vec2xLeftSide = -15f;
    float vec2yLeftSide = -8.5f;

    float vec2xRightSide = 16f;
    float vec2yRightSide = -8.5f;

    float PokeballLeftX = -14.7f;
    float PokeballLeftY = -8f;

    float PokeballRightX = 16f;
    float PokeballRightY = -8f;

    float PokeballCentreY = -8f;

    float PotionLeftX = -30f;
    float PotionLeftY = 0f;

    float PotionRightX = 30f;
    float PotionRightY = 5f;

    float YellowballX = 0;
    float YellowballY = 13.9f;

    float FireballX = 22f;
    float FireballY = 1.5f;

    float RayquazaX = 0f;
    float RayquazaY = 8.5f;

    float KyogreX = 0f;
    float KyogreY = -15.5f;

    float GroudonX = 28.5f;
    float GroudonY = 0f;

    float Boxwidth = 4f;
    float WaterX = -23.5f;
    float CloudX = -30.4f;

    /**
     * Populate the world.*
     */
    @Override
    public void populate(MilestoneGame milestoneGame) {
        super.populate(milestoneGame);

        //create the clouds
        for (int i = 0; i <= 19; i++) {
            Body cloud = new Cloud(this);
            cloud.setPosition(new Vec2(CloudX, 13f));
            cloud.addCollisionListener(new LoseLife(getPlayer()));

            CloudX = CloudX + 3.2f;
        }

        //create Rayquaza
        this.rayquaza = new Rayquaza(this);
        rayquaza.setPosition(new Vec2(RayquazaX, RayquazaY));
        rayquaza.addCollisionListener(new LoseLife(getPlayer()));

        //create Fireball
        this.fireball = new Fireball(this);
        fireball.setPosition(new Vec2(FireballX, FireballY));
        fireball.addCollisionListener(new LoseLife(getPlayer()));

        //create Kyogre
        this.kyogre = new Kyogre(this);
        kyogre.setPosition(new Vec2(KyogreX, KyogreY));
        kyogre.addCollisionListener(new LoseLife(getPlayer()));

        //create Groudon
        Body groudon = new Groudon(this);
        groudon.setPosition(new Vec2(GroudonX, GroudonY));
        groudon.addCollisionListener(new LoseLife(getPlayer()));

        //create the pokeballsCentre
        for (int i = 0; i <= 1; i++) {
            Body pokeball = new Pokeball(this);
            pokeball.setPosition(new Vec2(0, PokeballCentreY));
            pokeball.addCollisionListener(new PickThePokeball(getPlayer()));

            PokeballCentreY = PokeballCentreY + 5.5f;
        }

        //create the pokeballsLeftSide
        for (int i = 0; i <= 1; i++) {
            Body pokeball = new Pokeball(this);
            pokeball.setPosition(new Vec2(PokeballLeftX, PokeballLeftY));
            pokeball.addCollisionListener(new PickThePokeball(getPlayer()));

            PokeballLeftX = PokeballLeftX + 1.5f;
            PokeballLeftY = PokeballLeftY + 6;
        }

        //create the pokeballsRightSide
        for (int i = 0; i <= 1; i++) {
            Body pokeball = new Pokeball(this);
            pokeball.setPosition(new Vec2(PokeballRightX, PokeballRightY));
            pokeball.addCollisionListener(new PickThePokeball(getPlayer()));

            PokeballRightX = PokeballRightX - 2f;
            PokeballRightY = PokeballRightY + 6;
        }

        //create the potionLeftSide
        Body potionLeft = new Potion(this);
        potionLeft.setPosition(new Vec2(PotionLeftX, PotionLeftY));
        potionLeft.addCollisionListener(new WinLife(getPlayer()));

        //create the potionRightSide
        Body potionRight = new Potion(this);
        potionRight.setPosition(new Vec2(PotionRightX, PotionRightY));
        potionRight.addCollisionListener(new WinLife(getPlayer()));

        //create platforms to the left side
        for (int i = 0; i <= 1; i++) {
            Shape platformLeftShape = new BoxShape(Boxwidth, 0.6f);
            Body platformLeft = new StaticBody(this, platformLeftShape);
            platformLeft.setPosition(new Vec2(vec2xLeftSide, vec2yLeftSide));

            vec2xLeftSide = vec2xLeftSide + 2;
            vec2yLeftSide = vec2yLeftSide + 5.7f;

            Boxwidth = Boxwidth - 1f;
        }

        //create platforms to the right side
        Boxwidth = 4f;
        for (int i = 0; i <= 1; i++) {
            Shape platformRightShape = new BoxShape(Boxwidth, 0.6f);
            Body platformRight = new StaticBody(this, platformRightShape);
            platformRight.setPosition(new Vec2(vec2xRightSide, vec2yRightSide));

            vec2xRightSide = vec2xRightSide - 2;
            vec2yRightSide = vec2yRightSide + 5.7f;

            Boxwidth = Boxwidth - 1f;
        }
        //create platforms to the more left side
        Shape platformLeft1Shape = new BoxShape(3, 0.6f);
        Body platformLeft1 = new StaticBody(this, platformLeft1Shape);
        platformLeft1.setPosition(new Vec2(-30f, 0));

        //create platforms to the more right side
        Shape platformRight1Shape = new BoxShape(3, 0.6f);
        Body platformRight1 = new StaticBody(this, platformRight1Shape);
        platformRight1.setPosition(new Vec2(30f, 5));

        Shape platformRight2Shape = new BoxShape(5, 0.6f);
        Body platformRight2 = new StaticBody(this, platformRight2Shape);
        platformRight2.setPosition(new Vec2(28.5f, -5));
        platformRight2.setFillColor(Color.red);

        //create platforms to the centre
        for (int i = 0; i <= 1; i++) {
            Shape platformCentreShape = new BoxShape(4, 0.6f);
            Body platformCentre = new StaticBody(this, platformCentreShape);
            platformCentre.setPosition(new Vec2(vec2xCentre, vec2yCentre));

            if (i == 2) {
                vec2yCentre = vec2yCentre + 5.3f;
            } else {
                vec2yCentre = vec2yCentre + 5.7f;
            }
        }

        //Create the ground
        Shape shapeLeftGround = new BoxShape(3, 7f);
        Body groundLeft = new StaticBody(this, shapeLeftGround);
        groundLeft.setPosition(new Vec2(-32.5f, -21f));

        Shape shapeRightGround = new BoxShape(3, 7f);
        Body groundRight = new StaticBody(this, shapeRightGround);
        groundRight.setPosition(new Vec2(32.5f, -21f));

        for (int i = 1; i <= 5; i++) {
            Body water = new Water(this);
            water.setPosition(new Vec2(WaterX, -15.5f));
            water.addCollisionListener(new LoseLife(getPlayer()));

            WaterX = WaterX + 11.75f;
        }

        //create bounds
        Shape BoundLeftShape = new BoxShape(0.5f, 17.5f);
        Body BoundLeft = new StaticBody(this, BoundLeftShape);
        BoundLeft.setPosition(new Vec2(-35f, 3.5f));
        BoundLeft.rotate(0);

        Shape BoundRightShape = new BoxShape(0.5f, 17.5f);
        Body BoundRight = new StaticBody(this, BoundRightShape);
        BoundRight.setPosition(new Vec2(35f, 3.5f));
        BoundRight.rotate(0);
    }

    @Override
    public Vec2 startPosition() {
        return new Vec2(-32.5f, -10);
    }

    @Override
    public Vec2 NextLevelPosition() {
        return new Vec2(31.7f, -12f);
    }

    @Override
    public boolean isCompleted() {
        return getPlayer().getPokeballCount() >= NUM_POKEBALLS;
    }

    Body getFireball() {
        return this.fireball;
    }

    Body getRayquaza() {
        return this.rayquaza;
    }

    Body getKyogre() {
        return this.kyogre;
    }

}
