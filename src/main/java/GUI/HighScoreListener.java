package src.main.java.GUI;

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
            button.setIcon(new ImageIcon("src/main/resources/highScorePressed.png"));

        }

        public void mousePressed(MouseEvent e) {
            button.setIcon(new ImageIcon("src/main/resources/highScorePressed.png"));

        }

        public void mouseReleased(MouseEvent e) {
            button.setIcon(new ImageIcon("src/main/resources/highScoreHover.png"));

        }

        public void mouseEntered(java.awt.event.MouseEvent e) {
            button.setIcon(new ImageIcon("src/main/resources/highScoreHover.png"));
        }

        public void mouseExited(MouseEvent e) {
            button.setIcon(new ImageIcon("src/main/resources/highScoreButton.png"));

        }


    }
