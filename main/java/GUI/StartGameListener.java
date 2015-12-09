package main.java.GUI;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by id12jzn on 2015-12-09.
 */
public class StartGameListener implements MouseListener {

    private JButton button;

    private CLayout c;

    public StartGameListener(JButton button, CLayout c) {

        this.button = button;
        this.c = c;
    }

    public void mouseClicked(MouseEvent e) {
        button.setIcon(new ImageIcon("main/resources/newGameButtonPress.png"));
        c.showCard("game");

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
