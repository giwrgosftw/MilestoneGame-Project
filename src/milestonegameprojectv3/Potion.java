package milestonegameprojectv3;

import city.cs.engine.BodyImage;
import city.cs.engine.DynamicBody;
import city.cs.engine.PolygonShape;
import city.cs.engine.Shape;
import city.cs.engine.SoundClip;
import city.cs.engine.World;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * * A potion.**
 */
public class Potion extends DynamicBody {

    private static final Shape PotionShape = new PolygonShape(0.47f, 1.66f, -1.17f, 1.19f, -1.21f, -0.99f, 1.2f, -0.99f, 1.21f, 1.39f, 0.61f, 1.64f);
    private static final BodyImage image = new BodyImage("data/Potion.png", 3.5f);
    private static SoundClip pickThePotionSound;

    //sound
    static {
        try {
            pickThePotionSound = new SoundClip("data/MilestoneGame - pickThePotion.mp3");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }

    /**
     * Construct a potion.* @param world the world in which this body exists.*
     */
    public Potion(World world) {
        super(world, PotionShape);
        addImage(image);
    }

    @Override
    public void destroy() {
        pickThePotionSound.play();
        super.destroy();
    }

}
