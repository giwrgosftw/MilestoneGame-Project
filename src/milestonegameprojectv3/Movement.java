package milestonegameprojectv3;

import city.cs.engine.WorldView;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import org.jbox2d.common.Vec2;

/**
 * * Key handler to control an Walker. **
 */
public class Movement extends KeyAdapter {

    private static final float JUMPING_SPEED = 13.5f;
    private static final float WALKING_SPEED = 8.5f;

    private MainCharacter body;
    private Fireblast fireBlast;
    private WorldView view;
    private boolean mainCharacterSide = true;

    public Movement(MainCharacter body, WorldView view) {
        this.body = body;
        this.view = view;
    }

    /**
     * Handle key press events for walking and jumping.* @param e description of
     * the key event *
     */
    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_0) { // 0 = quit
            System.exit(0);
        } else if (code == KeyEvent.VK_SPACE) { // SPACE = jump
            Vec2 v = body.getLinearVelocity();
            body.jumpSound.play();

            if (Math.abs(v.y) < 0.01f) {
                body.jump(JUMPING_SPEED);
            }
        } else if (code == KeyEvent.VK_LEFT) {
            body.addImage(body.getImageLeft());
            body.startWalking(-WALKING_SPEED); // button " <- " = walk left
            mainCharacterSide = false;
        } else if (code == KeyEvent.VK_RIGHT) {
            body.addImage(body.getImageRight());
            body.startWalking(WALKING_SPEED); // button " -> " = walk right
            mainCharacterSide = true;
        } else if (code == KeyEvent.VK_C) {
            fireBlast.fireblastSound.play();
            if (mainCharacterSide == true) {
                //body.removeAllImages();
                //body.addImage(body.throwRight());
                fireBlast = new Fireblast(view.getWorld());
                fireBlast.setPosition(new Vec2(body.getPosition().x + 5, body.getPosition().y));
                fireBlast.applyImpulse(new Vec2(40, 0));

            }
            if (mainCharacterSide == false) {
                //body.removeAllImages();
                //body.addImage(body.throwLeft());
                fireBlast = new Fireblast(view.getWorld());
                fireBlast.setPosition(new Vec2(body.getPosition().x - 5, body.getPosition().y));
                fireBlast.applyImpulse(new Vec2(-40, 0));

            }
        }
    }

    /**
     * Handle key press events (stop walking).* @param e description of the key
     * event *
     */
    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_LEFT) {
            body.stopWalking();
        } else if (code == KeyEvent.VK_RIGHT) {
            body.stopWalking();
        }
    }

    public void setBody(MainCharacter body) {
        this.body = body;
    }

}


/**The startWalking method (called when a 1 or 2 key is pressed) registers a step listener on the world. 
After that, this listener then continually sets the character's horizontal velocity, making it walk (unless it runs into something). 
The stopWalking method (called when a 1 or 2 is released) removes the step listener, so it stops setting the velocity. 
The body then slows down due to friction (unless it's in the air).**/
