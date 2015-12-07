package main.java.GUI;

import java.awt.*;

/**
 * Created by Joakim on 2015-12-07.
 */
public class Block extends Rectangle {
    public int groundId;
    public int airId;

    public Block(int x, int y, int width, int height, int groundId, int airId) {
        setBounds(x, y, width, height);
        this.groundId = groundId;
        this.airId = airId;
    }

    public void draw(Graphics g) {
        g.drawRect(x, y, width, height);
    }
}
