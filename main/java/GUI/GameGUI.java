package main.java.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

/**
 * Created by Zacke on 2015-11-26.
 */
public class GameGUI extends JPanel implements Runnable {
    //JPanel gamePanel = new JPanel();

    JPanel gamePanel = new JPanel();
    public Thread thread = new Thread(this);
    public static boolean isFirst =true;
    public static int myWidth, myHeight;

    public String chosenMap;

    BufferedImage b;


    //private MapInformation mapinfo;

    private CLayout c;
    public Board gameBoard;
    public Store store;

    private Point mse = new Point(0, 0);

    //public static boolean isFirst = true;

    public static Mob[] mobs = new Mob[1];

    public GameGUI(CLayout c) {
        this.c = c;
        thread.start();
    }

    public void paintComponent(Graphics g) {
        if(isFirst) {
            myWidth = getWidth();
            myHeight = getHeight();
            define();
            isFirst = false;
        }
        g.setColor(new Color(50, 50, 50));
        g.fillRect(0, 0, getWidth(), getHeight());
        g.setColor(new Color(255, 255, 255));
        ((Graphics2D)g).setStroke(new BasicStroke(2));
        g.drawLine(gameBoard.block[0][0].x-1, 0, gameBoard.block[0][0].x-1, gameBoard.block[gameBoard.worldHeight-1][0].y + gameBoard.blockSize);
        g.drawLine(gameBoard.block[0][gameBoard.worldWidth-1].x + gameBoard.blockSize, 0, gameBoard.block[0][gameBoard.worldWidth-1].x + gameBoard.blockSize, gameBoard.block[gameBoard.worldHeight-1][0].y + gameBoard.blockSize);
        g.drawLine(gameBoard.block[0][0].x, gameBoard.block[gameBoard.worldHeight-1][0].y + gameBoard.blockSize, gameBoard.block[0][gameBoard.worldWidth-1].x + gameBoard.blockSize, gameBoard.block[gameBoard.worldHeight-1][0].y + gameBoard.blockSize);
        gameBoard.draw(g);
        g.setColor(new Color(0, 255, 255));
        store.draw(g);


        if (b != null) {
            g.drawImage(new ImageIcon(b).getImage(), (myWidth / 2) - (gameBoard.blockSize*(gameBoard.worldWidth/2)), 0, null);
        }

        for(int i=0;i<mobs.length;i++) {
            if (mobs[i].inGame) {
                mobs[i].draw(g);
            }
        }

    }

    public void define() {
        gameBoard = new Board(c, chosenMap);
        store = new Store(gameBoard, c);

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

    public JPanel getPanel() {

        gamePanel.setLayout(new GridLayout(1, 1, 0, 0));
        //gamePanel.add(new GameGUI(c));

        gamePanel.add(this);

        gamePanel.addMouseListener(new GameListener(c, this));

        return gamePanel;
    }

    public void setChosenMap(String s) {
        chosenMap = s;
    }

    public void drawImage(BufferedImage b) {
        this.b = b;
    }

}