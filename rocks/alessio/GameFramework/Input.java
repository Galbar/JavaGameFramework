package rocks.alessio.GameFramework;

import java.util.concurrent.ConcurrentSkipListMap;
import java.util.ArrayList;

/**
 * Created by alessio on 3/10/14.
 */
public abstract class Input {
    private ConcurrentSkipListMap<String, ArrayList<Callback> > callbacks;

    public Input() {
        ArrayList<String> eventTypes = this.getEventTypes();
        for(int i = 0; i < eventTypes.size(); ++i) {
            callbacks.put(eventTypes.get(i), new ArrayList<Callback>());
        }
    }

    public void executeEvents() {
        ArrayList<String> eventTypes = this.getEventTypes();
        for (int i = 0; i < eventTypes.size(); i++) {
            ArrayList<Callback> callbackList = callbacks.get(eventTypes.get(i));
            for (int j = 0; j < callbackList.size(); j++) {
                callbackList.get(j).execute();
            }
        }
    }

    protected abstract ArrayList<String> getEventTypes();

    public void register(String event, Callback callback) {
        callbacks.get(event).add(callback);
    }
}