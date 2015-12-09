package main.java.GUI;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Joakim on 2015-12-07.
 */
public class Mob extends Rectangle {
    public int xC, yC;
    public int mobSize = 54;
    public int Id = Value.groundUnit;
    public boolean inGame = false;
    private Board gameBoard;

    public Mob(Board gameBoard) {
        this.gameBoard = gameBoard;
        //if(GameGUI.gameBoard.block[y][x] == Value.start)
    }

    public void spawnMob(int Id) {
        setBounds(gameBoard.block[0][0].x , gameBoard.block[0][0].y, mobSize, mobSize);

        xC = 0;
        yC = 0;

        this.Id = Id;

        inGame = true;
    }

    public int walkFrame = 0, walkSpeed = 40;
    public void physic() {
        if(walkFrame >= walkSpeed) {
            x += 1;

            walkFrame = 0;
        } else {
            walkFrame += 1;
        }


    }


    public void draw(Graphics g) {
        if(inGame) {
            g.drawImage(new ImageIcon("main/resources/teleporterUnit.png").getImage(), x, y, width, height, null);
        }

    }
}
