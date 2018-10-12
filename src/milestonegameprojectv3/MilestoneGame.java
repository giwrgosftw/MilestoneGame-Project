package milestonegameprojectv3;

import city.cs.engine.DebugViewer;
import city.cs.engine.SoundClip;
import city.cs.engine.UserView;
import city.cs.engine.World;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;
import java.awt.BorderLayout;

/**
 * * The Milestone Computer Game.**
 */
public class MilestoneGame implements ActionListener {

    /**
     * The World in which the bodies move and interact. *
     */
    private MilestoneGameLevel world;
    private JFrame window;
    /**
     * A graphical display of the world (a specialised JPanel). *
     */
    private UserView view;

    JLabel l1;
    int level;
    private Movement movement;
    private SoundClip milestoneGameMusic;
    private SoundClip mainMenuMusic;
    private SoundClip gameOverSound;
    private SoundClip winSound;
    public int minutes = 0;
    public int seconds = 0;
    public int milliseconds = 0;
    public Timer timer;
    int prevLevel;

    public MilestoneGame() {
        //music
        try {
            mainMenuMusic = new SoundClip("data/MilstoneGame - Menu song.mp3");   // Open an audio input stream
            mainMenuMusic.loop();  // Set it to continous playback (looping)
            //milestoneGameMusic.setVolume(0.3);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }

        MainMenu menu = new MainMenu(this);
        menu.setTitle("Milestone The Game - Main menu");
        //menu.setLocationByPlatform(true);
        menu.setExtendedState(JFrame.MAXIMIZED_BOTH);
        menu.setLocationRelativeTo(null);
        menu.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        menu.pack();
        menu.setVisible(true);
        menu.setResizable(false);
        menu.requestFocus();
    }

    public void HelpMenu() {
        HelpMenu helpMenu = new HelpMenu(this);
        helpMenu.setTitle("Milestone The Game - Help");
        helpMenu.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        helpMenu.pack();
        helpMenu.setVisible(true);
        helpMenu.setResizable(false);
        helpMenu.setSize(660, 418);
        helpMenu.setLocationRelativeTo(null);
        helpMenu.requestFocus();
    }

    public void menuSoundOFF() {
        mainMenuMusic.setVolume(0.001);
    }

    public void menuSoundON() {
        mainMenuMusic.setVolume(1);
    }

    /**
     * Initialise a new Game.
     */
    public void playMilestoneGame() {

        //music
        try {
            mainMenuMusic.stop();
            milestoneGameMusic = new SoundClip("data/MilstoneGame - Level 1 song.mp3");   // Open an audio input stream
            milestoneGameMusic.loop();  // Set it to continous playback (looping)
            //milstoneGameMusic.setVolume(0.3);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }

        // make the world - Initialise a new Level
        level = 1;
        world = new Level1();
        world.populate(this);

        // make a view (with background)
        view = new Background(world, world.getPlayer(), this, 1920, 1080);

        // uncomment this to draw a 1-metre grid over the view
        //view.setGridResolution(1);
        // display the view in a frame   
        window = new JFrame("MileStone The Game");

        //add controlPanel to the screen
        Container buttons = new ControlPanel(this);
        window.add(buttons, BorderLayout.SOUTH);

        // uncomment this to make a debugging view
        //JFrame debugView = new DebugViewer(world, 1920, 1280);
        // quit the application when the game window is closed
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocationByPlatform(true);

        //fullscreen
        window.setExtendedState(JFrame.MAXIMIZED_BOTH);

        // display the world in the window
        window.add(view);

        // size the game window to fit the world view
        window.pack();

        // make the window visible
        window.setVisible(true);

        // get keyboard focus
        window.requestFocus();

        // give keyboard focus to the frame whenever the mouse enters the view
        view.addMouseListener(new GiveFocus(window));

        // enable the keyboard (register it to receive keyboard events)
        movement = new Movement(world.getPlayer(), view);
        window.addKeyListener(movement);

        timer = new Timer(1000, this);
        timer.start();

        // start the game!
        world.start();
    }

    /**
     * Pause the game*
     */
    public void pause() {
        world.stop();
    }

    /**
     * Resume the game*
     */
    public void resume() {
        world.start();
    }

    public void pauseSound() {
        milestoneGameMusic.pause();
    }

    public void resumeSound() {
        milestoneGameMusic.resume();
    }

    public void gameSoundOFF() {
        milestoneGameMusic.setVolume(0.001);
    }

    public void gameSoundON() {
        milestoneGameMusic.setVolume(1);
    }

    public void gameOverSound() {
        milestoneGameMusic.stop();
        world.stop();
        timer.stop();
        try {
            gameOverSound = new SoundClip("data/MilestoneGame - Game Over.mp3");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
        gameOverSound.play();
    }

    public void WinSound() {
        milestoneGameMusic.stop();
        world.stop();
        timer.stop();
        try {
            winSound = new SoundClip("data/MilestoneGame - You Win.mp3");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
        winSound.play();
    }

    public void restart() {

        //music
        try {
            milestoneGameMusic.stop();
            milestoneGameMusic = new SoundClip("data/MilstoneGame - Level 1 song.mp3");   // Open an audio input stream
            milestoneGameMusic.loop();  // Set it to continous playback (looping)
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }

        World prevWorld = world;
        prevWorld.stop();
        level = 1;
        minutes = 0;
        seconds = 0;
        milliseconds = 0;
        // get a new world
        world = new Level1();
        // fill it with bodies
        world.populate(this);

        // switch the keyboard control to the new player
        movement.setBody(world.getPlayer());
        // show the new world in the view
        view.setWorld(world);
        ((Background) view).setMainCharacter(world.getPlayer());
        timer.start();
        world.start();
    }

    /**
     * The player in the current level.
     */
    public MainCharacter getPlayer() {
        return world.getPlayer();
    }

    /**
     * Is the current level of the game finished?
     */
    public boolean isCurrentLevelCompleted() {
        return world.isCompleted();
    }

    public void level1() {

        MainCharacter oldMainCharacter = world.getPlayer();
        level = 1;

        //music
        try {
            milestoneGameMusic.stop();
            milestoneGameMusic = new SoundClip("data/MilstoneGame - Level 1 song.mp3");   // Open an audio input stream
            milestoneGameMusic.loop();  // Set it to continous playback (looping)
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }

        world = new Level1();
        // fill it with bodies
        world.populate(this);
        // switch the keyboard control to the new player
        movement.setBody(world.getPlayer());

        //trasnfer items(score,lives) from this level to another
        world.getPlayer().setPokeballCount(oldMainCharacter.getPokeballCount());
        world.getPlayer().setLiveCount(oldMainCharacter.getLiveCount());

        // show the new world in the view
        view.setWorld(world);
        ((Background) view).setMainCharacter(world.getPlayer());

        world.start();
    }

    public void level2() {
        MainCharacter oldMainCharacter = world.getPlayer();
        level = 2;

        //music
        try {
            milestoneGameMusic.stop();
            milestoneGameMusic = new SoundClip("data/MilstoneGame - Level 2 song.mp3");   // Open an audio input stream
            milestoneGameMusic.loop();  // Set it to continous playback (looping)
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }

        world = new Level2();
        // fill it with bodies
        world.populate(this);
        // switch the keyboard control to the new player
        movement.setBody(world.getPlayer());

        //move objects
        world.addStepListener(new StepAdapter(((Level2) world).getZaptos()));
        world.addStepListener(new StepAdapter(((Level2) world).getMoltres()));
        world.addStepListener(new StepAdapter(((Level2) world).getArticuno()));
        //trasnfer items(score,lives) from this level to another
        world.getPlayer().setPokeballCount(oldMainCharacter.getPokeballCount());
        world.getPlayer().setLiveCount(oldMainCharacter.getLiveCount());

        //show the new world in the view
        view.setWorld(world);
        ((Background) view).setMainCharacter(world.getPlayer());

        world.start();
    }

    public void level3() {
        MainCharacter oldMainCharacter = world.getPlayer();
        level = 3;

        //music
        try {
            milestoneGameMusic.stop();
            milestoneGameMusic = new SoundClip("data/MilstoneGame - Level 3 song.mp3");   // Open an audio input stream
            milestoneGameMusic.loop();  // Set it to continous playback (looping)
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }

        world = new Level3();
        // fill it with bodies
        world.populate(this);
        // switch the keyboard control to the new player
        movement.setBody(world.getPlayer());

        //move objects
        world.addStepListener(new StepAdapterPokemonLevel3(((Level3) world).getRayquaza()));
        world.addStepListener(new StepAdapterPokemonLevel3(((Level3) world).getKyogre()));
        world.addStepListener(new StepAdapterFireball(((Level3) world).getFireball()));
        //trasnfer items(score,lives) from this level to another
        world.getPlayer().setPokeballCount(oldMainCharacter.getPokeballCount());
        world.getPlayer().setLiveCount(oldMainCharacter.getLiveCount());

        //show the new world in the view
        view.setWorld(world);
        ((Background) view).setMainCharacter(world.getPlayer());
        world.start();
    }

    /**
     * Advance to the next level of the game.
     */
    public void goNextLevel() {
        MainCharacter oldMainCharacter = world.getPlayer();
        level++;
        if (level == 2) {

            //music
            try {
                milestoneGameMusic.stop();
                milestoneGameMusic = new SoundClip("data/MilstoneGame - Level 2 song.mp3");   // Open an audio input stream
                milestoneGameMusic.loop();  // Set it to continous playback (looping)
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
                System.out.println(e);
            }

            // get a new world
            world = new Level2();
            // fill it with bodies
            world.populate(this);
            // switch the keyboard control to the new player
            movement.setBody(world.getPlayer());

            //move objects
            world.addStepListener(new StepAdapter(((Level2) world).getZaptos()));
            world.addStepListener(new StepAdapter(((Level2) world).getMoltres()));
            world.addStepListener(new StepAdapter(((Level2) world).getArticuno()));
            //trasnfer items(score,lives) from this level to another
            world.getPlayer().setPokeballCount(oldMainCharacter.getPokeballCount());
            world.getPlayer().setLiveCount(oldMainCharacter.getLiveCount());

            //show the new world in the view
            view.setWorld(world);
            ((Background) view).setMainCharacter(world.getPlayer());

            world.start();
        } else if (level == 3) {

            //music
            try {
                milestoneGameMusic.stop();
                milestoneGameMusic = new SoundClip("data/MilstoneGame - Level 3 song.mp3");   // Open an audio input stream
                milestoneGameMusic.loop();  // Set it to continous playback (looping)
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
                System.out.println(e);
            }

            // get a new world
            world = new Level3();
            // fill it with bodies
            world.populate(this);
            // switch the keyboard control to the new player
            movement.setBody(world.getPlayer());

            //move objects
            world.addStepListener(new StepAdapterPokemonLevel3(((Level3) world).getRayquaza()));
            world.addStepListener(new StepAdapterPokemonLevel3(((Level3) world).getKyogre()));
            world.addStepListener(new StepAdapterFireball(((Level3) world).getFireball()));
            //trasnfer items(score,lives) from this level to another
            world.getPlayer().setPokeballCount(oldMainCharacter.getPokeballCount());
            world.getPlayer().setLiveCount(oldMainCharacter.getLiveCount());

            // show the new world in the view
            view.setWorld(world);
            ((Background) view).setMainCharacter(world.getPlayer());
            world.start();
        } else {
            System.exit(0);
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        milliseconds++;
        if (milliseconds > 9) {
            milliseconds = 0;
            seconds++;
        }
        if (seconds > 5) {
            seconds = 0;
            minutes++;
        }

        //System.out.println("Time: " + minutes + ":" + seconds + "" + milliseconds);
    }

    /**
     * Run the game. *
     */
    public static void main(String[] args) {
        new MilestoneGame();
    }

}
