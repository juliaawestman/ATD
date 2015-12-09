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
    private int timeStamp;
    private int visibilityTime = -1;

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
    /*Set i a time the Graphic object will be visible. When the object has 
     lived for the specified time (measured in game ticks) it will be removed. If this time is not set 
     the object will live untill it is removed*/

    public void setVisibilityTime(int timestamp, int visibilityTime) {
        this.visibilityTime = visibilityTime;
        this.timeStamp = timestamp;
    }

    public boolean shouldBeRemoved(int currentTime) {
        return ((currentTime)-(this.timeStamp)) >= this.visibilityTime;
    }
    /**
     * 
     * @return true if this object has a set lifetime false if not.
     */
    public boolean isLifeTimeObject(){
        return this.visibilityTime >= 0;
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
