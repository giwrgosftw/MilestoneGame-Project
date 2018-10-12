package milestonegameprojectv3;

import city.cs.engine.BodyImage;
import city.cs.engine.PolygonShape;
import city.cs.engine.Shape;
import city.cs.engine.SoundClip;
import city.cs.engine.Walker;
import city.cs.engine.World;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * * The main character of the game.**
 */
public class MainCharacter extends Walker {

    private MilestoneGame milestoneGame;

    private static final Shape MainCharacterShape = new PolygonShape(0.66f, 1.94f, -1.03f, 0.76f, -1.08f, -1.44f, -0.31f, -2.04f, 1.12f, -2.03f, 1.45f, -1.4f, 1.43f, 1.95f);
    private static final BodyImage imageRight = new BodyImage("data/MainCharacterRight.gif", 5f);
    private static final BodyImage imageLeft = new BodyImage("data/MainCharacterLeft.gif", 5f);

    private int PokeballCount;
    public int LiveCount;
    public static SoundClip jumpSound;
    private static SoundClip loseLifeSound;
    private static SoundClip lifeLeft1Sound;
    private boolean flag = false;

    /**
     * Construct the main character.** @param world the world in which this body
     * exists.*
     */
    public MainCharacter(World world, MilestoneGame milestoneGame) {
        super(world, MainCharacterShape);
        addImage(imageRight);
        this.milestoneGame = milestoneGame;

        PokeballCount = 0;
        LiveCount = 3;
    }

    static {
        try {
            jumpSound = new SoundClip("data/MilestoneGame - Jump.wav");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
        jumpSound.setVolume(0.2f);
    }

    //change the image when the main chacacter turns right
    public BodyImage getImageRight() {
        this.removeAllImages();
        return imageRight;

    }

    //change the image when the main chacacter turns left
    public BodyImage getImageLeft() {
        this.removeAllImages();
        return imageLeft;

    }

    public int getPokeballCount() {
        return PokeballCount;
    }

    public void setPokeballCount(int countPokeball) {
        PokeballCount = countPokeball;
    }

    public int getLiveCount() {
        return LiveCount;
    }

    public void setLiveCount(int countLive) {
        LiveCount = countLive;
    }

    public void incrementPokeballCount() {
        PokeballCount++;
        if (PokeballCount == 1) {
            System.out.println("GOOD JOB!  YOU HAVE PICKED UP " + PokeballCount + " POKEBALL!");
        } else if (PokeballCount == 10) {
            System.out.println("GOOD JOB!  YOU HAVE PICKED UP ALL THE POKEBALLS!");
        } else if (PokeballCount <= 10) {
            System.out.println("GOOD JOB!  YOU HAVE PICKED UP " + PokeballCount + " POKEBALLS!");
        }
        if (milestoneGame.level == 3) {
            if (PokeballCount == 6) {
                milestoneGame.WinSound();
            }
        }
    }

    public void decrementLiveCount() {
        LiveCount--;
        if (LiveCount == 1) {
            try {
                lifeLeft1Sound = new SoundClip("data/MilestoneGame - When life is 1.mp3");
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
                System.out.println(e);
            }
            lifeLeft1Sound.setVolume(2f);
            lifeLeft1Sound.loop();
            flag = true;
            System.out.println("OH NO! YOU HAVE ONLY " + LiveCount + " LIVE LEFT!!!");
        } else if (LiveCount == 0) {
            lifeLeft1Sound.stop();
            loseLifeSound.stop();
            milestoneGame.gameOverSound();
            System.out.println("OH NO! YOU LOSE !!!");
            System.out.println("PRESS 0 TO QUIT...");
        } else {
            System.out.println("BE CAREFULL! YOU LOST LIFE! YOU HAVE " + LiveCount + " LIVES LEFT!!!");
        }
    }

    public void incrementLiveCount() {
        LiveCount++;

        if (LiveCount == 1) {
            System.out.println("GREAT! YOU WIN A LIFE! NOW YOU HAVE " + LiveCount + " LIVE!!!");
        } else {
            if (LiveCount == 2) {
                if (flag = true) {
                    lifeLeft1Sound.stop();
                    flag = false;
                }
            }
            System.out.println("GREAT! YOU WIN A LIFE! NOW YOU HAVE " + LiveCount + " LIVES!!!");
        }
    }

    public void LifeZero() {
        if (LiveCount == 0) {
            milestoneGame.gameOverSound();
        }
    }

    public void LoseLifeSound() {
        {
            try {
                loseLifeSound = new SoundClip("data/MilestoneGame - When lose life.mp3");
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
                System.out.println(e);
            }
            loseLifeSound.play();
        }
    }
}
