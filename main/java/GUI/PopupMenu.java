package main.java.GUI;

import javax.swing.*;

/**
 * Created by id12jzn on 2015-12-17.
 */
public class PopupMenu {

        private CLayout c;
        final JFrame popup = new JFrame();

        public PopupMenu(CLayout c) {
        this.c = c;

        }


    public void openPopup() {
        Object[] options = {"Resume",
                "Restart",
                "Main menu"};

        int n = JOptionPane.showOptionDialog(popup,
                "Game is paused! Choose a option"
                        + "",
                "",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[2]);
        // Resume
        if(n == 0) {
            //Hej
        }
        // Restart
        if(n == 1) {

        }
        // Menu
        if(n == 2) {
            c.showMainMenu();
        }

        System.out.println(n);
    }

}
