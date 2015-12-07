package main.java;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Stack;

/**
 *
 * @author guldsmurfen
 */
public class Events {

    HashMap allNewEvents;

    public Events() {
        this.allNewEvents = new HashMap();
    }

    public void addEvent(Event e) {
        this.allNewEvents.put(e.getId(), e);
    }

    /**
     *
     * @return returns the most recent version of all events since last call to
     * this method. Stack is empty if there is no new events.
     */
    public Stack getAllNewEvents() {
        Stack s = new Stack();
        Iterator itr;
        Event currentEvent;
        itr = allNewEvents.entrySet().iterator();

        while (itr.hasNext()) {
            s.push(itr.next());
            itr.remove();
        }

        return s;
    }
}
