package src.GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by Joakim on 2015-11-30.
 */
class SoundListener implements MouseListener {

        private JButton button;

        public SoundListener(JButton button) {
            this.button = button;
        }

    public void mouseClicked(MouseEvent e) {
        button.setIcon(new ImageIcon("soundOff.png"));

    }

    public void mousePressed(MouseEvent e) {
        button.setIcon(new ImageIcon("soundOff.png"));

    }

    public void mouseReleased(MouseEvent e) {

    }

    public void mouseEntered(java.awt.event.MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {

    }

    }