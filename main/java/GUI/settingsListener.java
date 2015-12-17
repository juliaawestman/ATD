package main.java.GUI;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by juliawestman on 2015-12-17.
 */
public class SettingsListener  implements MouseListener {
    private JButton button;
    private CLayout c;

    public SettingsListener(JButton button, CLayout c) {

        this.button = button;
        this.c = c;
    }

    public void mouseClicked(MouseEvent e) {
        c.showCard("menu");

    }

    public void mousePressed(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
        button.setIcon(new ImageIcon("main/resources/settings.png"));
    }

    public void mouseExited(MouseEvent e) {
        button.setIcon(new ImageIcon("main/resources/settings.png"));

    }

}

