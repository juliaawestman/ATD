package src.main.java.GUI;

import javax.swing.*;

/**
 * Created by Zacke on 2015-12-01.
 */
public class CardLayout {

    JFrame frame;

    JPanel menucard, newGameCard, highScoreCard, endGameCard;

    CardLayout cl = new CardLayout();



    public CardLayout() {

        frame = new JFrame();


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);



        MenuGUI gui = new MenuGUI();
        gui.show();

        /*
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CardLayout();

            }
        });

        */

    }
}
