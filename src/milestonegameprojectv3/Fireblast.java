package milestonegameprojectv3;

import city.cs.engine.BodyImage;
import city.cs.engine.CircleShape;
import city.cs.engine.DynamicBody;
import city.cs.engine.Shape;
import city.cs.engine.SoundClip;
import city.cs.engine.World;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Fireblast extends DynamicBody {

    /**
     * * Fireblast.**
     */
    private Fireblast fireBlast;
    private static final float radius = 0.5f;
    private static final Shape FireblastShape = new CircleShape(radius);
    private static final BodyImage FireblastImage = new BodyImage("data/Fireblast.gif", 5f * radius);
    public static SoundClip fireblastSound;

    static {
        try {
            fireblastSound = new SoundClip("data/MilestoneGame - FireblastSound.mp3");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }

    /**
     * Construct the enemy.** @param world the world in which this body exists.*
     */
    public Fireblast(World world) {
        super(world, FireblastShape);
        addImage(FireblastImage);
        this.addCollisionListener(new Kill(fireBlast));
    }

}
