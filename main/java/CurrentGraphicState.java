package main.java;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Stack;

/**
 *
 * @author guldsmurfen
 */
public class CurrentGraphicState {

    HashMap allGraphicEvents;

    public CurrentGraphicState() {
        this.allGraphicEvents = new HashMap();
    }

    public void addGraphicEvent(GraphicEvent e) {
        this.allGraphicEvents.put(e.getId(), e);
    }

    public void removeGraphicEvent(GraphicEvent e){
        this.allGraphicEvents.remove(e.getId());
    }

    /**
     *
     * @return returns the most recent version of all events since last call to
     * this method. Stack is empty if there is no new events.
     */
    public Stack getCurrentGraphicState() {
        Stack s = new Stack();
        Iterator itr;
        GraphicEvent currentGraphicEvent;
        itr = allGraphicEvents.entrySet().iterator();

        while (itr.hasNext()) {
            s.push(itr.next());
        }

        return s;
    }
}
