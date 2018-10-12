package milestonegameprojectv3;

import city.cs.engine.*;

public class NextLevelListener implements CollisionListener {

    private MilestoneGame milestoneGame;

    public NextLevelListener(MilestoneGame milestoneGame) {
        this.milestoneGame = milestoneGame;
    }

    @Override
    public void collide(CollisionEvent e) {
        MainCharacter player = milestoneGame.getPlayer();
        boolean levelDone = milestoneGame.isCurrentLevelCompleted();
        if (e.getOtherBody() == player && levelDone) {
            System.out.println("Congratulations,level is completed!!!Going to next level...");
            //    if (milestoneGame.levelNumber == 1) {
//                milestoneGame.level2Game();
//            }
//            if (milestoneGame.levelNumber == 2) {
//                milestoneGame.level3Game();
//            }
//            if (milestoneGame.levelNumber == 3) {
//                milestoneGame.level4Game();
//            }

            milestoneGame.goNextLevel();
        } else {
            System.out.println("Level is locked! Pick up all the pokeballs first!!");
        }
    }
}

/**
 * if the current level is complete the game is advanced to the next level. *
 */
