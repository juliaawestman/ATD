package main.java.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;

/**
 * Class: CLayout
 * This class builds the GUI for the game. This GUI is of type CardLayout in which this class i able to switch between
 * different cards after it built them.
 *
 * Created by Zacke on 2015-12-01.
 */
public class CLayout {

    private JFrame frame = new JFrame("Anti Tower Defence");

    private JPanel panelCont = new JPanel();
    //JPanel gamePanel = new JPanel();
    //JPanel menuCard, newGameCard, highScoreCard, endGameCard;

     MusicPlayer music = new MusicPlayer();

    private CardLayout cl = new CardLayout();

    public MapInformation mapinfo;
    public UserInformation userinfo;

    private GameGUI game;
    private MenuGUI menu;
    private NewGameGUI newGame;
    private HighScoreGUI highScore;
    private GameOverGUI gameOver;
    private AboutGUI about;
    private HelpGUI help;



    public CLayout(MapInformation mapinfo, UserInformation userinfo) {
        this.mapinfo = mapinfo;
        this.userinfo = userinfo;

        music.play("main/resources/defaultMusic.wav");

        panelCont.setLayout(cl);

        menu = new MenuGUI(this);
        newGame = new NewGameGUI(this);
        highScore = new HighScoreGUI(this);
        game = new GameGUI(this);
        gameOver = new GameOverGUI(this);
        about = new AboutGUI(this);
        help = new HelpGUI(this);

        panelCont.add(menu.getPanel(), "menu");
        panelCont.add(highScore.getPanel(), "highScore");
        panelCont.add(newGame.getPanel(), "newGame");
        panelCont.add(game.getPanel(), "game");
        panelCont.add(gameOver.getPanel(), "gameOver");
        panelCont.add(about.getPanel(), "about");
        panelCont.add(help.getPanel(), "help");


        cl.show(panelCont, "menu");

        frame.add(panelCont);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);



        //MenuGUI gui = new MenuGUI();
        //gui.show();

        /*
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CLayout();

            }
        });

        */

    }

    /**
     * Shows a specific card in the GUI
     *
     * @param s String of which card to show
     */
    public void showCard(String s) {

        cl.show(panelCont, s);
    }

    /**
     * Resizes the frame and shows the card containing the game including the map
     *
     * @param map String of which map is chosen
     */
    public void showGame(String map) {

        frame.setSize(900, 900);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        game.setChosenMap(map);

        cl.show(panelCont, "game");
    }

    /**
     * Closing the frame and program
     */
    public void exit() {
        frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
    }


    public void setBoardImage(BufferedImage b) {

        game.drawImage(b);

    }

    /**
     * @return The size of a tile in the game board
     */
    public int getTileSize() {
        //return game.gameBoard.blockSize;
        return Board.blockSize;
    }

}
