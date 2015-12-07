/**
 * Class: Game
 *
 * Author: Isak Hjelt
 *
 * cs-user: dv14iht
 *
 * Date: 2015-12-07
 */
package main.java;

import java.awt.image.BufferedImage;

public class Event {
    BufferedImage img;
    int id;
    
    public Event(int id, BufferedImage image){
        this.id = id;
        this.img = image;
    }
    public int getId(){
        return this.id;
    }
    public BufferedImage getImage(){
        return this.img;
    }
}
