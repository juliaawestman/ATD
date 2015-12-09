package main.java.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;

/**
 * Created by Zacke on 2015-12-01.
 */
public class CLayout {

    JFrame frame = new JFrame("Anti Tower Defence");

    JPanel panelCont = new JPanel();
    //JPanel gamePanel = new JPanel();
    //JPanel menuCard, newGameCard, highScoreCard, endGameCard;

    CardLayout cl = new CardLayout();

    private MapInformation mapinfo;



    public CLayout(MapInformation mapinfo) {
        this.mapinfo = mapinfo;



        panelCont.setLayout(cl);

        //menuCard = MenuGUI

                //MenuGUI gui = new MenuGUI();

        MenuGUI menu = new MenuGUI(this);
        NewGameGUI newGame = new NewGameGUI();
        HighScoreGUI highScore = new HighScoreGUI();
        GameGUI game = new GameGUI(this);


        panelCont.add(menu.getPanel(), "menu");
        panelCont.add(highScore.getPanel(), "highScore");
        //panelCont.add(newGame.getPanel(), "newGame");
        panelCont.add(game.getPanel(), "game");


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

    public void showCard(String s) {

        if(s.equals("game")) {
            frame.setSize(900, 900);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        }
        cl.show(panelCont, s);
    }

    public void exit() {
        frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
    }

}
