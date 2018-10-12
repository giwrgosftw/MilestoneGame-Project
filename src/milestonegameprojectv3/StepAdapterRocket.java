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

public class StepAdapterRocket implements StepListener {

    Body rocket;
    int time = 0;
    int frequency = 300;
    float dir;

    public StepAdapterRocket(Body rocket) {
        this.rocket = rocket;
        dir = -0.15f;
    }

    @Override
    public void preStep(StepEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

        time++;

        if (this.time > this.frequency) {
            this.time = 0;
        }
        //System.out.println(this.rocket.getPosition().y);

        if (this.rocket.getPosition().y >= -20f) {
            Vec2 pos = new Vec2(this.rocket.getPosition().x, this.rocket.getPosition().y + dir);
            this.rocket.setPosition(pos);
        } else if (this.rocket.getPosition().y < -20f) {
            Vec2 pos = new Vec2(this.rocket.getPosition().x, 11f);
            this.rocket.setPosition(pos);
        }
    }

    @Override
    public void postStep(StepEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
