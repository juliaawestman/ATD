package main.java.GUI;

import java.awt.*;

/**
 * Created by Zacke on 2015-12-08.
 */
public class Store {
    private int shopWidth = 8;
    private int buttonSize = 54;
    private int cellSpace = 2;
    private int margin = 30;
    private int iconSize = 20;

    public Rectangle[] button = new Rectangle[shopWidth];
    public Rectangle buttonHealth;
    public Rectangle buttonCoins;
    public Rectangle buttonIncome;

    public Store() {
        define();
    }

    public void define() {
        for(int i = 0; i<button.length;i++) {
            button[i] = new Rectangle((GameGUI.myWidth/2) - ((shopWidth*(buttonSize+cellSpace))/2) + ((buttonSize+cellSpace)*i), 680, buttonSize, buttonSize);
        }

        buttonHealth = new Rectangle(GameGUI.gameBoard.block[0][0].x-1, button[0].y, iconSize, iconSize);
        buttonCoins = new Rectangle(GameGUI.gameBoard.block[0][0].x-1, button[0].y + button[0].height-iconSize, iconSize, iconSize);
        //buttonIncome = new Rectangle(GameGUI.gameBoard.block[0][0].x-1, button[0].y + (button[0].height-iconSize*2), iconSize, iconSize);
    }

    public void draw(Graphics g) {
        for(int i = 0; i<button.length;i++) {
            g.fillRect(button[i].x, button[i].y, button[i].width, button[i].height);
        }
        g.fillRect(buttonHealth.x, buttonHealth.y, buttonHealth.width, buttonHealth.height);
        g.fillRect(buttonCoins.x, buttonCoins.y, buttonCoins.width, buttonCoins.height);
        //g.fillRect(buttonIncome.x, buttonIncome.y, buttonIncome.width, buttonIncome.height);

    }
}
