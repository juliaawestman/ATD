package main.java.GUI;

import main.java.User;

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
    public boolean isFirst =true;
    public int myWidth, myHeight;

    User u = new User(0,0);

    boolean gameOver = false;

    public String chosenMap;

    BufferedImage b;

    boolean firstWin = true;


    //private MapInformation mapinfo;

    private CLayout c;
    public Board gameBoard;
    public Store store;

    private Point mse = new Point(0, 0);

    //public static boolean isFirst = true;

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

    }

    public void define() {
        gameBoard = new Board(c, chosenMap);
        store = new Store(gameBoard, c);
    }

    public int spawnTime = 20000, spawnFrame = 0;


    /**
     * Metod som kör gui tråden och målar om guit varje millisekund
     *
     * TODO Fixa wincondition!
     */
    public static int fpsFrame = 0, fps = 120;
    public void run() {
        while(true) {

            // Wincondition
            if (u.getScore() >= 5 && firstWin) {
                firstWin = false;
                    c.showGameOver();
            }


            if(!isFirst) {
                gameBoard.physic();
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