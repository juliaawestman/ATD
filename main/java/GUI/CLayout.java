package main.java.GUI;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Zacke on 2015-12-01.
 */
public class CLayout {

    JFrame frame = new JFrame("Anti Tower Defence");

    JPanel panelCont = new JPanel();
    JPanel menuCard, newGameCard, highScoreCard, endGameCard;

    CardLayout cl = new CardLayout();



    public CLayout() {



        panelCont.setLayout(cl);

        //menuCard = MenuGUI

                //MenuGUI gui = new MenuGUI();

        MenuGUI menu = new MenuGUI();
        HighScoreGUI highScore = new HighScoreGUI();


        panelCont.add(menu.getPanel(), "menu");
        panelCont.add(highScore.getPanel(), "highscore");

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
        cl.show(panelCont, s);
    }
}
