package cc.alessio.gameframework;

import java.util.concurrent.ConcurrentSkipListMap;
import java.util.ArrayList;

/**
 * Created by alessio on 3/10/14.
 */
public abstract class Input {
    private ConcurrentSkipListMap<Integer, ArrayList<Callback> > callbacks = new ConcurrentSkipListMap<Integer, ArrayList<Callback>>();

    public Input() {
        ArrayList<Integer> eventTypes = this.getEventTypes();
        for(int i = 0; i < eventTypes.size(); ++i) {
            callbacks.put(eventTypes.get(i), new ArrayList<Callback>());
        }
    }

    public void executeEvent(Integer event) {
        executeEvent(event, null);
    }

    public void executeEvent(Integer event, Callback.Attributes attr) {
        ArrayList<Callback> callbackList = callbacks.get(event);
        for (int j = 0; j < callbackList.size(); j++) {
            callbackList.get(j).execute(attr);
        }
    }

    public abstract void executeEvents();

    protected abstract ArrayList<Integer> getEventTypes();

    public void register(Integer event, Callback callback) {
        callbacks.get(event).add(callback);
    }

    public void clear() {
        for (Integer event : getEventTypes()) {
            callbacks.get(event).clear();
        }
    }
}