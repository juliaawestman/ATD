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
        button.setIcon(new ImageIcon("main/resources/newGameButtonPress.png"));
        c.showCard("newGame");



        final JFrame parent = new JFrame();

        String name = JOptionPane.showInputDialog(parent,
                "Enter username:", null);



    }

    public void mousePressed(MouseEvent e) {
        button.setIcon(new ImageIcon("main/resources/newGameHover.png"));

    }

    public void mouseReleased(MouseEvent e) {
        button.setIcon(new ImageIcon("main/resources/newGameHover.png"));

    }

    public void mouseEntered(java.awt.event.MouseEvent e) {
        button.setIcon(new ImageIcon("main/resources/newGameHover.png"));
    }

    public void mouseExited(MouseEvent e) {
        button.setIcon(new ImageIcon("main/resources/newGameButton.png"));

    }


}
