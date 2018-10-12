/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package milestonegameprojectv3;

import city.cs.engine.Body;
import city.cs.engine.StepEvent;
import city.cs.engine.StepListener;
import org.jbox2d.common.Vec2;

public class StepAdapter implements StepListener {

    Body movingBody;
    float dir;

    public StepAdapter(Body movingBody) {
        this.movingBody = movingBody;
        dir = -0.15f;
    }

    @Override
    public void preStep(StepEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        //System.out.println("prestep" + this.movingBody.getPosition().y);

        if (this.movingBody.getPosition().y > 9.5f) {
            dir = -0.15f;

        }
        if (this.movingBody.getPosition().y < -5f) {
            dir = 0.15f;
        }

        Vec2 pos = new Vec2(this.movingBody.getPosition().x, this.movingBody.getPosition().y + dir);
        this.movingBody.setPosition(pos);
    }

    @Override
    public void postStep(StepEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
