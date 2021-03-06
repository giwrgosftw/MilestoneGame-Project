package milestonegameprojectv3;

public class ControlPanel extends javax.swing.JPanel {

    /**
     * Creates new form ControlPanel*
     */
    private MilestoneGame milestoneGame;

    public ControlPanel(MilestoneGame milestoneGame) {
        initComponents();
        this.milestoneGame = milestoneGame;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        pauseButton = new javax.swing.JToggleButton();
        resumeButton = new javax.swing.JToggleButton();
        quitButton = new javax.swing.JToggleButton();
        restartButton = new javax.swing.JToggleButton();
        nextLevel = new javax.swing.JToggleButton();
        level1 = new javax.swing.JToggleButton();
        level2 = new javax.swing.JToggleButton();
        level3 = new javax.swing.JToggleButton();
        gameSoundON = new javax.swing.JToggleButton();
        gameSoundOFF = new javax.swing.JToggleButton();

        jButton1.setText("jButton1");

        setBackground(new java.awt.Color(128, 128, 128));
        setBorder(javax.swing.BorderFactory.createCompoundBorder(null, new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black)));
        setPreferredSize(new java.awt.Dimension(789, 29));

        pauseButton.setText("Pause");
        pauseButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pauseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pauseButtonActionPerformed(evt);
            }
        });

        resumeButton.setText("Resume");
        resumeButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        resumeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resumeButtonActionPerformed(evt);
            }
        });

        quitButton.setText("Quit");
        quitButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        quitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitButtonActionPerformed(evt);
            }
        });

        restartButton.setText("Restart");
        restartButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        restartButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                restartButtonActionPerformed(evt);
            }
        });

        nextLevel.setText("NextLevel");
        nextLevel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        nextLevel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextLevelActionPerformed(evt);
            }
        });

        level1.setText("Level 1");
        level1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        level1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                level1ActionPerformed(evt);
            }
        });

        level2.setText("Level 2");
        level2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        level2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                level2ActionPerformed(evt);
            }
        });

        level3.setText("Level 3");
        level3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        level3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                level3ActionPerformed(evt);
            }
        });

        gameSoundON.setText("SoundON");
        gameSoundON.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        gameSoundON.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gameSoundONActionPerformed(evt);
            }
        });

        gameSoundOFF.setText("SoundOFF");
        gameSoundOFF.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        gameSoundOFF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gameSoundOFFActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pauseButton, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(resumeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(restartButton, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(gameSoundON, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(gameSoundOFF, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(nextLevel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65)
                .addComponent(level1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(level2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(level3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(quitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(resumeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(pauseButton, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(restartButton, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(quitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(nextLevel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(level1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(level2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(level3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(gameSoundON, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(gameSoundOFF, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void resumeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resumeButtonActionPerformed
        milestoneGame.resumeSound();
        milestoneGame.resume();
    }//GEN-LAST:event_resumeButtonActionPerformed

    private void pauseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pauseButtonActionPerformed
        milestoneGame.pauseSound();
        milestoneGame.pause();
    }//GEN-LAST:event_pauseButtonActionPerformed

    private void quitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitButtonActionPerformed
        System.exit(0);
    }//GEN-LAST:event_quitButtonActionPerformed

    private void restartButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_restartButtonActionPerformed
        milestoneGame.restart();
    }//GEN-LAST:event_restartButtonActionPerformed

    private void nextLevelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextLevelActionPerformed
        milestoneGame.goNextLevel();
    }//GEN-LAST:event_nextLevelActionPerformed

    private void level1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_level1ActionPerformed
        milestoneGame.level1();
    }//GEN-LAST:event_level1ActionPerformed

    private void level2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_level2ActionPerformed
        milestoneGame.level2();
    }//GEN-LAST:event_level2ActionPerformed

    private void level3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_level3ActionPerformed
        milestoneGame.level3();
    }//GEN-LAST:event_level3ActionPerformed

    private void gameSoundONActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gameSoundONActionPerformed
        milestoneGame.gameSoundON();
    }//GEN-LAST:event_gameSoundONActionPerformed

    private void gameSoundOFFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gameSoundOFFActionPerformed
        milestoneGame.gameSoundOFF();
    }//GEN-LAST:event_gameSoundOFFActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton gameSoundOFF;
    private javax.swing.JToggleButton gameSoundON;
    private javax.swing.JButton jButton1;
    private javax.swing.JToggleButton level1;
    private javax.swing.JToggleButton level2;
    private javax.swing.JToggleButton level3;
    private javax.swing.JToggleButton nextLevel;
    private javax.swing.JToggleButton pauseButton;
    private javax.swing.JToggleButton quitButton;
    private javax.swing.JToggleButton restartButton;
    private javax.swing.JToggleButton resumeButton;
    // End of variables declaration//GEN-END:variables
}
