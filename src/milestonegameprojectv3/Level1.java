package milestonegameprojectv3;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 * Level 1 of the game*
 */
public class Level1 extends MilestoneGameLevel {

    private static final int NUM_POKEBALLS = 7;

    //inputs
    float PikachuWithGunX = 26f;
    float PikachuWithGunY = -1.1f;

    float PikachuWithGunRightX = 16f;
    float PikachuWithGunRightY = -12.9f;

    float LucarioWithGunX = -22.5f;
    float LucarioWithGunY = -0.4f;

    float LucarioWithGunLeftX = -13f;
    float LucarioWithGunLeftY = -12.2f;

    float PokeballLeftX = -14.7f;
    float PokeballLeftY = -8f;

    float PokeballRightX = 16f;
    float PokeballRightY = -8f;

    float PokeballCentreY = -8f;

    float CloudWhiteX = -30f;

    float RocketX = -7.5f;

    float Boxwidth = 4f;

    float PotionLeftX = -28.0f;
    float PotionLeftY = -5.5f;

    float PotionRightX = 28.0f;
    float PotionRightY = -5.5f;

    //Platform's inputs
    float vec2xCentre = 0.1f;
    float vec2yCentre = -8.5f;

    float vec2xLeftSide = -15f;
    float vec2yLeftSide = -8.5f;

    float vec2xRightSide = 16f;
    float vec2yRightSide = -8.5f;

    float vec2xMoreLeftSide = -28.0f;
    float vec2yMoreLeftSide = -8.5f;

    float vec2xMoreRightSide = 28.0f;
    float vec2yMoreRightSide = -8.5f;
    //end of platfrom's inputs

    /**
     * Populate the world.*
     */
    @Override
    public void populate(MilestoneGame milestoneGame) {
        super.populate(milestoneGame);

        //create the EnemiesMoreRightSide
        for (int i = 0; i <= 1; i++) {
            Body pikachuWithGun = new PikachuWithGun(this);
            pikachuWithGun.setPosition(new Vec2(PikachuWithGunX, PikachuWithGunY));
            pikachuWithGun.addCollisionListener(new LoseLife(getPlayer()));

            PikachuWithGunX = PikachuWithGunX - 2;
            PikachuWithGunY = PikachuWithGunY + 5.7f;
        }

        //create the EnemiesRightSide
        Body pikachuWithGun = new PikachuWithGun(this);
        pikachuWithGun.setPosition(new Vec2(PikachuWithGunRightX, PikachuWithGunRightY));
        pikachuWithGun.addCollisionListener(new LoseLife(getPlayer()));

        //create the EnemiesMoreLeftSide
        for (int i = 0; i <= 1; i++) {
            Body lucarioWithGun = new LucarioWithGun(this);
            lucarioWithGun.setPosition(new Vec2(LucarioWithGunX, LucarioWithGunY));
            lucarioWithGun.addCollisionListener(new LoseLife(getPlayer()));

            LucarioWithGunX = LucarioWithGunX + 2;
            LucarioWithGunY = LucarioWithGunY + 5.7f;
        }

        //create the EnemiesLeftSide
        Body lucarioWithGun = new LucarioWithGun(this);
        lucarioWithGun.setPosition(new Vec2(LucarioWithGunLeftX, LucarioWithGunLeftY));
        lucarioWithGun.addCollisionListener(new LoseLife(getPlayer()));

        //create the Whiteclouds
        for (int i = 0; i <= 12; i++) {
            Body cloudsWhite = new CloudsWhite(this);
            cloudsWhite.setPosition(new Vec2(CloudWhiteX, 14.2f));
            cloudsWhite.addCollisionListener(new LoseLife(getPlayer()));

            CloudWhiteX = CloudWhiteX + 5f;
        }

        //create the rockets
        for (int i = 0; i <= 1; i++) {
            Body rocket = new Rocket(this);
            rocket.setPosition(new Vec2(RocketX, 11f));
            rocket.addCollisionListener(new LoseLife(getPlayer()));
            RocketX = RocketX + 16;
            this.addStepListener(new StepAdapterRocket(rocket));
        }

        //create the potionLeftSide
        Body potionLeft = new Potion(this);
        potionLeft.setPosition(new Vec2(PotionLeftX, PotionLeftY));
        potionLeft.addCollisionListener(new WinLife(getPlayer()));

        //create the potionRightSide
        Body potionRight = new Potion(this);
        potionRight.setPosition(new Vec2(PotionRightX, PotionRightY));
        potionRight.addCollisionListener(new WinLife(getPlayer()));

        //////////////////////////  CREATE POKEBALLS ///////////////////////////
        //create the pokeballsCentre
        for (int i = 0; i <= 2; i++) {
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

        //create bounds
        Shape BoundLeftShape = new BoxShape(0.5f, 17.5f);
        Body BoundLeft = new StaticBody(this, BoundLeftShape);
        BoundLeft.setPosition(new Vec2(-34.6f, 3.5f));
        BoundLeft.rotate(0);

        Shape BoundRightShape = new BoxShape(0.5f, 17.5f);
        Body BoundRight = new StaticBody(this, BoundRightShape);
        BoundRight.setPosition(new Vec2(34.65f, 3.5f));
        BoundRight.rotate(0);

        //create the ground
        Shape shapeLeftGround = new BoxShape(18, 6.5f);
        Body groundLeft = new StaticBody(this, shapeLeftGround);
        groundLeft.setPosition(new Vec2(-27.5f, -20.5f));

        Body blankLeft = new Blank(this);
        blankLeft.setPosition(new Vec2(0f, -25.5f));
        blankLeft.addCollisionListener(new LoseLife(getPlayer()));

        Shape shapeCentreGround = new BoxShape(6, 6.5f);
        Body groundCentre = new StaticBody(this, shapeCentreGround);
        groundCentre.setPosition(new Vec2(0.5f, -20.5f));

        Shape shapeRightGround = new BoxShape(17, 6.5f);
        Body groundRight = new StaticBody(this, shapeRightGround);
        groundRight.setPosition(new Vec2(27.5f, -20.5f));

        ////////////////////////// CREATE PLATFORMS ////////////////////////////
        //create platforms to the centre
        for (int i = 0; i <= 2; i++) {
            Shape platformCentreShape = new BoxShape(4, 0.6f);
            Body platformCentre = new StaticBody(this, platformCentreShape);
            platformCentre.setPosition(new Vec2(vec2xCentre, vec2yCentre));

            if (i == 2) {
                vec2yCentre = vec2yCentre + 5.3f;
            } else {
                vec2yCentre = vec2yCentre + 5.7f;
            }
        }

        //create platforms to the left side
        for (int i = 0; i <= 1; i++) {
            Shape platformLeftShape = new BoxShape(Boxwidth, 0.6f);
            Body platformLeft = new StaticBody(this, platformLeftShape);
            platformLeft.setPosition(new Vec2(vec2xLeftSide, vec2yLeftSide));

            vec2xLeftSide = vec2xLeftSide + 2;
            vec2yLeftSide = vec2yLeftSide + 5.7f;

            Boxwidth = Boxwidth - 1f;
        }

        //create platforms to the more left side
        for (int i = 0; i <= 2; i++) {
            Shape platformMORELeftShape = new BoxShape(4, 0.6f);
            Body platformMORELeft = new StaticBody(this, platformMORELeftShape);
            platformMORELeft.setPosition(new Vec2(vec2xMoreLeftSide, vec2yMoreLeftSide));

            vec2xMoreLeftSide = vec2xMoreLeftSide + 2;
            vec2yMoreLeftSide = vec2yMoreLeftSide + 5.7f;
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

        //create platforms to the more right side
        for (int i = 0; i <= 2; i++) {
            Shape platformMORERightShape = new BoxShape(4, 0.6f);
            Body platformMORERight = new StaticBody(this, platformMORERightShape);
            platformMORERight.setPosition(new Vec2(vec2xMoreRightSide, vec2yMoreRightSide));

            vec2xMoreRightSide = vec2xMoreRightSide - 2;
            vec2yMoreRightSide = vec2yMoreRightSide + 5.7f;
        }
        ////////////////////////// END OF CREATE PLATFORMS /////////////////////
    }

    @Override
    public Vec2 startPosition() {
        return new Vec2(2, -10);
    }

    @Override
    public Vec2 NextLevelPosition() {
        return new Vec2(28.5f, -12f);
    }

    @Override
    public boolean isCompleted() {
        return getPlayer().getPokeballCount() >= NUM_POKEBALLS;
    }

}
