package main.java.GUI;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Joakim on 2015-12-07.
 */
public class Mob extends Rectangle {
    public int mobSize = 54;
    public int Id = Value.groundUnit;
    public boolean inGame = false;

    public Mob() {
        //if(GameGUI.gameBoard.block[y][x] == Value.start)


    }

    public void spawnMob(int Id) {
        setBounds(GameGUI.gameBoard.block[0][0].x , GameGUI.gameBoard.block[0][0].y, mobSize, mobSize);

        this.Id = Id;

        inGame = true;
    }

    public void draw(Graphics g) {
        if(inGame) {
            g.drawImage(new ImageIcon("main/resources/groundUnit.png").getImage(), x, y, width, height, null);
        }

    }
}
