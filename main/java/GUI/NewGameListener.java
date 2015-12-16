package main.java.GUI;

import javax.swing.*;
import java.awt.event.*;

/**
 * Created by Zacke on 2015-11-26.
 */
class NewGameListener implements MouseListener {

    private JButton button;
    private CLayout c;

    public NewGameListener(JButton button, CLayout c) {

        this.button = button;
        this.c = c;
    }

    public void mouseClicked(MouseEvent e) {
        c.showCard("newGame");

    }

    public void mousePressed(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
        button.setIcon(new ImageIcon("main/resources/newGameHover.png"));
    }

    public void mouseExited(MouseEvent e) {
        button.setIcon(new ImageIcon("main/resources/newGameButton.png"));

    }


}
