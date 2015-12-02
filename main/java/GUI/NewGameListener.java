package main.java.GUI;

import javax.swing.*;
import java.awt.event.*;

/**
 * Created by Zacke on 2015-11-26.
 */
class NewGameListener implements MouseListener {

    private JButton button;

    public NewGameListener(JButton button) {
        this.button = button;
    }

    public void mouseClicked(MouseEvent e) {
        button.setIcon(new ImageIcon("main/resources/newGameButtonPress.png"));

    }

    public void mousePressed(MouseEvent e) {
        button.setIcon(new ImageIcon("main/resources/newGameButtonPress.png"));

    }

    public void mouseReleased(MouseEvent e) {
        button.setIcon(new ImageIcon("main/resources/newGameButtonEnter.png"));

    }

    public void mouseEntered(java.awt.event.MouseEvent e) {
        button.setIcon(new ImageIcon("main/resources/newGameButtonEnter.png"));
    }

    public void mouseExited(MouseEvent e) {
        button.setIcon(new ImageIcon("main/resources/newGameButton.png"));

    }


}
