package main.java.GUI;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by Joakim on 2015-11-30.
 */
public class QuitListener implements MouseListener{

    private JButton button;
    private CLayout c;

    public QuitListener(JButton button, CLayout c) {

        this.button = button;
        this.c = c;
    }

    public void mouseClicked(MouseEvent e) {
        button.setIcon(new ImageIcon("main/resources/QuitPress.png"));

    }

    public void mousePressed(MouseEvent e) {
        button.setIcon(new ImageIcon("main/resources/QuitPress.png"));

    }

    public void mouseReleased(MouseEvent e) {
        button.setIcon(new ImageIcon("main/resources/QuitHover.png"));

    }

    public void mouseEntered(java.awt.event.MouseEvent e) {
        button.setIcon(new ImageIcon("main/resources/QuitHover.png"));
    }

    public void mouseExited(MouseEvent e) {
        button.setIcon(new ImageIcon("main/resources/QuitButton.png"));

    }


}
