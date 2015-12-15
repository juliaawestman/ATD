package main.java.GUI;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

/**
 * Class: GameGUI
 * Builds the GUI for when a new game is starting
 *
 * Created by Zacke on 2015-11-26.
 */
public class GameGUI extends JPanel implements Runnable {

    JPanel gamePanel = new JPanel();
    public Thread thread = new Thread(this);
    public static boolean isFirst =true;
    public static int myWidth, myHeight;
    public String chosenMap;
    private CLayout c;
    public Board gameBoard;
    public static Store store;
    public static Mob[] mobs = new Mob[1];

    public GameGUI(CLayout c) {
        this.c = c;
        thread.start();
    }

    /**
     * Paints the actual GUI for when a new game is starting, including the store and game board
     *
     * @param g
     */
    public void paintComponent(Graphics g) {
        if(isFirst) {
            myWidth = getWidth();
            myHeight = getHeight();
            define();
            isFirst = false;

        }
        g.setColor(new Color(50, 50, 50));
        g.fillRect(0, 0, getWidth(), getHeight());
        g.setColor(new Color(255, 255, 0));
        ((Graphics2D)g).setStroke(new BasicStroke(3));
        g.drawLine(gameBoard.block[0][0].x-1, 0, gameBoard.block[0][0].x-1, gameBoard.block[gameBoard.worldHeight-1][0].y + gameBoard.blockSize);
        g.drawLine(gameBoard.block[0][gameBoard.worldWidth-1].x + gameBoard.blockSize, 0, gameBoard.block[0][gameBoard.worldWidth-1].x + gameBoard.blockSize, gameBoard.block[gameBoard.worldHeight-1][0].y + gameBoard.blockSize);
        g.drawLine(gameBoard.block[0][0].x, gameBoard.block[gameBoard.worldHeight-1][0].y + gameBoard.blockSize, gameBoard.block[0][gameBoard.worldWidth-1].x + gameBoard.blockSize, gameBoard.block[gameBoard.worldHeight-1][0].y + gameBoard.blockSize);
        gameBoard.draw(g);
        g.setColor(new Color(0, 255, 255));
        store.draw(g);

        for(int i=0;i<mobs.length;i++) {
            if (mobs[i].inGame) {
                mobs[i].draw(g);
            }
        }

    }

    /**
     * Defines the game board, store and units
     */
    public void define() {
        gameBoard = new Board(c, chosenMap);
        store = new Store(gameBoard);

        for(int i=0;i<mobs.length;i++) {
            mobs[i] = new Mob(gameBoard);
            mobs[i].spawnMob(0);
        }
    }

    public int spawnTime = 20000, spawnFrame = 0;
    public void mobSpawner() {
        if (spawnFrame >= spawnTime) {
            for (int i= 0; i<mobs.length; i++) {
                if(!mobs[i].inGame) {
                    mobs[i].spawnMob(0);
                    break;
                }
            }

            spawnFrame = 0;

        } else {
            spawnFrame += 1;
        }

    }

    /**
     * A method that repaints the GUI every millisecond and is run by a new thread
     */
    public static int fpsFrame = 0, fps = 120;
    public void run() {
        while(true) {
            if(!isFirst) {
                gameBoard.physic();
                mobSpawner();
                for(int i=0;i<mobs.length;i++) {
                    if(mobs[i].inGame) {
                        mobs[i].physic();
                    }
                }
            }

            repaint();

            try {
                Thread.sleep(1);
            } catch(Exception e) {

            }

        }
    }

    /**
     * @return The game panel as a panel with a grid layout
     */
    public JPanel getPanel() {

        gamePanel.setLayout(new GridLayout(1, 1, 0, 0));
        //gamePanel.add(new GameGUI(c));
        gamePanel.add(this);

        return gamePanel;
    }

    /**
     * Updates which map is chosen by the user
     *
     * @param s String of which map is chosen
     */
    public void setChosenMap(String s) {
        chosenMap = s;
    }

    public void setBoardImage(BufferedImage b) {




    }

    public int getTileSize() {
        return gameBoard.blockSize;
    }

}