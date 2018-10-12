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

/**
 * * A pokeball.**
 */
public class Pokeball extends DynamicBody {

    private static final float radius = 0.5f;
    private static final Shape PokeballShape = new CircleShape(radius);
    private static final BodyImage pokeballImage = new BodyImage("data/Pokeball.gif", 7.7f * radius);
    private static SoundClip pickThePokeballSound;

    //sound
    static {
        try {
            pickThePokeballSound = new SoundClip("data/MilestoneGame - PickThePokeball.mp3");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }

    /**
     * Construct a pokeball.* @param world the world in which this body exists.*
     */
    public Pokeball(World world) {
        super(world, PokeballShape);
        addImage(pokeballImage);
    }

    @Override
    public void destroy() {
        pickThePokeballSound.play();
        super.destroy();
    }
}
