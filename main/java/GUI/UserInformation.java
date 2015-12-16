package main.java.GUI;

/**
 * Created by id12jzn on 2015-12-15.
 */
public interface UserInformation {

    void buyUnit(int i);

    boolean canBuyUnit(int i);

    String getUnitName(int i);

    int getUnitCost(int i);

    void withdrawCredits(int i);

    void updateUsername(String s);

    boolean gameOver();

    void hasClicked(int x, int y);

}
