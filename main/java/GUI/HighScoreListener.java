package main.java.GUI;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by Joakim on 2015-11-30.
 */
public class HighScoreListener implements MouseListener{

        private JButton button;

        public HighScoreListener(JButton button) {

            this.button = button;
        }

        public void mouseClicked(MouseEvent e) {
            button.setIcon(new ImageIcon("main/resources/highScorePressed.png"));
            new CLayout().showCard("highScore");

        }

        public void mousePressed(MouseEvent e) {
            button.setIcon(new ImageIcon("main/resources/highScorePressed.png"));

        }

        public void mouseReleased(MouseEvent e) {
            button.setIcon(new ImageIcon("main/resources/highScoreHover.png"));

        }

        public void mouseEntered(java.awt.event.MouseEvent e) {
            button.setIcon(new ImageIcon("main/resources/highScoreHover.png"));
        }

        public void mouseExited(MouseEvent e) {
            button.setIcon(new ImageIcon("main/resources/highScoreButton.png"));

        }


    }
