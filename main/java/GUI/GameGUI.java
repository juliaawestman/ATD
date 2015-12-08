package main.java.GUI;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.IOException;
import java.util.Random;

/**
 * Created by Zacke on 2015-11-26.
 */
public class GameGUI extends JPanel implements Runnable {
    //JPanel gamePanel = new JPanel();

    JPanel gamePanel = new JPanel();
    public Thread thread = new Thread(this);
    public static boolean isFirst =true;
    public static int myWidth, myHeight;
    public static Board gameBoard;

    public static Mob[] mobs = new Mob[100];

    public void paintComponent(Graphics g) {
        if(isFirst) {
            myWidth = getWidth();
            myHeight = getHeight();
            define();
            isFirst = false;


        }
        //g.clearRect(0, 0, getWidth(), getHeight());
        gameBoard.draw(g);

        for(int i=0;i<mobs.length;i++) {
            if (mobs[i].inGame) {
                mobs[i].draw(g);
            }
        }

    }

    public void define() {
        gameBoard = new Board();

        for(int i=0;i<mobs.length;i++) {
            mobs[i] = new Mob();
            mobs[i].spawnMob(0);
        }
    }

    public static int fpsFrame = 0, fps = 120;
    public void run() {
        while(true) {
            if(!isFirst) {
                repaint();
            }

            try {
                Thread.sleep(1);
            } catch(Exception e) {

            }

        }
    }

    public JPanel getPanel() {

        gamePanel.setLayout(new GridLayout(1, 1, 0, 0));
        gamePanel.add(new GameGUI());

        return gamePanel;
    }

}