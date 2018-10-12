package milestonegameprojectv3;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * * A mouse listener that gives the keyboard focus to a specified component.**
 */
public class GiveFocus extends MouseAdapter {

    private Component target;

    /**
     * * Initialize the listener.* @param target the component to be given the
     * focus on mouseEntered().**
     */
    public GiveFocus(Component target) {
        this.target = target;
    }

    /**
     * * Called when the mouse enters a component.* @param e description of the
     * mouse event**
     */
    @Override
    public void mouseEntered(MouseEvent e) {
        target.requestFocus();
    }
}


/**Keyboard events are delivered to a single graphical component, which is said to have the keyboard focus. 
To make sure the right component has the focus, this week's demo includes another mouse listener 
to give focus to the frame when the mouse enters the view.**/
