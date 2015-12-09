/**
 * Class: GraphicEvent
 *
 * Author: Isak Hjelt
 *
 * cs-user: dv14iht
 *
 * Date: 2015-12-07
 */
package main.java;


import java.net.URL;

public class GraphicEvent {
    private Position pos;
    private Position pos1;
    private Position pos2;
    private URL imageURl = null;
    boolean isLaserEvent;
    private int id;

    public GraphicEvent(int id, Position pos, URL imageURl) {
        this.isLaserEvent = false;
        this.pos = pos;
        this.id = id;
        this.imageURl = imageURl;
    }

    /*Make a laser event*/
    public GraphicEvent(int id, Position pos1, Position pos2) {
        this.isLaserEvent = true;
        this.id = id;
        this.pos1 = pos1;
        this.pos2 = pos2;
    }

    public int getId() {
        return this.id;
    }

    public boolean isLaserEvent() {
        return isLaserEvent;
    }

    public Position getLineStartPos() {
        return this.pos1;
    }

    public Position getLineEndPos() {
        return this.pos2;
    }

    public URL getImageUrl() {
        return this.imageURl;
    }
}
