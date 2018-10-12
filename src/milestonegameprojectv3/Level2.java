package milestonegameprojectv3;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 * Level 2 of the game*
 */
public class Level2 extends MilestoneGameLevel {

    private static final int NUM_POKEBALLS = 7;
    Body zaptos;
    Body articuno;
    Body moltres;

    //inputs
    float vec2xCentre = 0.1f;
    float vec2yCentre = -8.5f;

    float vec2xLeftSide = -15f;
    float vec2yLeftSide = -8.5f;

    float vec2xRightSide = 16f;
    float vec2yRightSide = -8.5f;

    float Boxwidth = 4f;
    float CloudWhiteX = -30f;

    float PokeballLeftX = -14.7f;
    float PokeballLeftY = -8f;

    float PokeballRightX = 16f;
    float PokeballRightY = -8f;

    float PokeballCentreY = -8f;

    float ZaptosX = -7.5f;
    float ZaptosY = 9.5f;

    float ArticunoX = 8.5f;
    float ArticunoY = 9.5f;

    float MoltresX = 25.5f;
    float MoltresY = 9.5f;

    float LugiaX = 12f;
    float LugiaY = -7f;

    /**
     * Populate the world.*
     */
    @Override
    public void populate(MilestoneGame milestoneGame) {
        super.populate(milestoneGame);

        //create Zaptos
        this.zaptos = new Zaptos(this);
        zaptos.setPosition(new Vec2(ZaptosX, ZaptosY));
        zaptos.addCollisionListener(new LoseLife(getPlayer()));

        //create Articuno
        this.articuno = new Articuno(this);
        articuno.setPosition(new Vec2(ArticunoX, ArticunoY));
        articuno.addCollisionListener(new LoseLife(getPlayer()));

        //create Moltres
        this.moltres = new Moltres(this);
        moltres.setPosition(new Vec2(MoltresX, MoltresY));
        moltres.addCollisionListener(new LoseLife(getPlayer()));

        //create Lugia
        for (int i = 0; i <= 1; i++) {
            Body lugia = new Lugia(this);
            lugia.setPosition(new Vec2(LugiaX, LugiaY));
            lugia.addCollisionListener(new LoseLife(getPlayer()));

            LugiaX = LugiaX + 6;
            LugiaY = LugiaY + 6;
        }

        //create the Whiteclouds
        for (int i = 0; i <= 12; i++) {
            Body cloudsWhite = new CloudsWhite(this);
            cloudsWhite.setPosition(new Vec2(CloudWhiteX, 14.2f));
            cloudsWhite.addCollisionListener(new LoseLife(getPlayer()));

            CloudWhiteX = CloudWhiteX + 5f;
        }

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

        //Create the ground
        Shape shapeLeftGround = new BoxShape(3, 7f);
        Body groundLeft = new StaticBody(this, shapeLeftGround);
        groundLeft.setPosition(new Vec2(-32.5f, -21f));

        Body blank = new Blank(this);
        blank.setPosition(new Vec2(0f, -20.5f));
        blank.addCollisionListener(new LoseLife(getPlayer()));

        Shape shapeRightGround = new BoxShape(3, 7f);
        Body groundRight = new StaticBody(this, shapeRightGround);
        groundRight.setPosition(new Vec2(32.5f, -21f));

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

    Body getZaptos() {
        return this.zaptos;
    }

    Body getArticuno() {
        return this.articuno;
    }

    Body getMoltres() {
        return this.moltres;
    }
}
