package milestonegameprojectv3;

import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
import city.cs.engine.*;
import java.awt.Font;

/**
 * extended view*
 */
public class Background extends UserView {

    MainCharacter mainCharacter;
    MilestoneGame milestoneGame;

    private Image backgroundLevel1;
    private Image backgroundLevel2;
    private Image backgroundLevel3;
    private Image heart;
    private Image pokeball;

    public Background(World world, MainCharacter mainCharacter, MilestoneGame milestoneGame, int width, int height) {
        super(world, width, height);
        this.mainCharacter = mainCharacter;
        this.milestoneGame = milestoneGame;
        this.backgroundLevel1 = new ImageIcon("data/BackgroundLevel1.png").getImage();
        this.backgroundLevel2 = new ImageIcon("data/BackgroundLevel2.png").getImage();
        this.backgroundLevel3 = new ImageIcon("data/BackgroundLevel3.png").getImage();
        this.heart = new ImageIcon("data/Heart.png").getImage();
        this.pokeball = new ImageIcon("data/PokeballIcon.gif").getImage();
    }

    @Override
    protected void paintBackground(Graphics2D g) {
        if (milestoneGame.level == 1) {
            g.drawImage(backgroundLevel1, 310, 115, this);
            g.drawImage(heart, 5, 95, this);
            g.drawImage(pokeball, -10, 112, this);
        } else if (milestoneGame.level == 2) {
            g.drawImage(backgroundLevel2, 480, 240, this);
            g.drawImage(heart, 5, 95, this);
            g.drawImage(pokeball, -10, 112, this);
        } else if (milestoneGame.level == 3) {
            g.drawImage(backgroundLevel3, 170, 50, this);
            g.drawImage(heart, 5, 95, this);
            g.drawImage(pokeball, -10, 112, this);
        }

    }

    @Override
    protected void paintForeground(Graphics2D g) {
        g.setFont(new Font("Imprint MT Shadow", Font.BOLD, 16));
        if (mainCharacter.getLiveCount() >= 0) {
            g.drawString("Lives: " + mainCharacter.getLiveCount(), 30, 115);
        } else {
            g.drawString("Lives: 0", 30, 115);
        }
        g.drawString("Score: " + mainCharacter.getPokeballCount(), 30, 132);
        g.drawString("Buttons:   - ^ -  ,  Jump = Space,  Fire = c", 5, 150);
        g.drawString("         <   |   >             ", 29, 151);
        g.drawString("You must collect all pokeballs for the next level!", 5, 166);
        g.setFont(new Font("Imprint MT Shadow", Font.BOLD, 25));
        g.drawString("Time: " + milestoneGame.minutes + ":" + milestoneGame.seconds + "" + milestoneGame.milliseconds, 1220, 130);
        g.setFont(new Font("Imprint MT Shadow", Font.BOLD, 16));
        if (milestoneGame.level == 1) {
            g.drawString("Level: 1", 5, 180);
        } else if (milestoneGame.level == 2) {
            g.drawString("Level: 2", 5, 180);
        } else if (milestoneGame.level == 3) {
            g.drawString("Level: 3", 5, 180);
            if (mainCharacter.getPokeballCount() == 6) {
                g.setFont(new Font("Imprint MT Shadow", Font.BOLD, 100));
                g.drawString("YOU WIN!!!", 400, 315);
            }
        }

        if (mainCharacter.getLiveCount() == 0) {
            g.setFont(new Font("Imprint MT Shadow", Font.BOLD, 100));
            g.drawString("YOU LOSE!!!", 370, 315);
        }
    }

    void setMainCharacter(MainCharacter mainCharacter) {
        this.mainCharacter = mainCharacter;

    }
}
