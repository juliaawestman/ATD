package main.java.GUI;

import main.java.User;

/**
 * Created by id12jzn on 2015-12-15.
 */
public interface UserInformation {

    void buyUnit(int i);

    boolean canBuyUnit(int i);

    String getUnitName(int i);

    void updateUsername(String s);

    boolean gameOver();

    boolean gameWon();

    User getUser();

    void killGame();

    void pauseGame();

    void resumeGame();

    void hasClicked(int x, int y);

}
