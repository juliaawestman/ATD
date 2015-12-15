package main.java.GUI;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by juliawestman on 2015-12-15.
 */
public class HelpListener implements MouseListener {
    private JButton button;
    private CLayout c;

    public HelpListener(JButton button, CLayout c) {

        this.button = button;
        this.c = c;
    }

    public void mouseClicked(MouseEvent e) {
        button.setIcon(new ImageIcon("main/resources/helpPress.png"));
        c.showCard("help");

    }

    public void mousePressed(MouseEvent e) {
        button.setIcon(new ImageIcon("main/resources/helpPress.png"));

    }

    public void mouseReleased(MouseEvent e) {
        button.setIcon(new ImageIcon("main/resources/helpHover.png"));

    }

    public void mouseEntered(java.awt.event.MouseEvent e) {
        button.setIcon(new ImageIcon("main/resources/helpHover.png"));
    }

    public void mouseExited(MouseEvent e) {
        button.setIcon(new ImageIcon("main/resources/helpButton.png"));

    }

}
