package cc.alessio.gameframework;

import java.util.PriorityQueue;
import java.util.concurrent.ConcurrentSkipListMap;

/**
 * Created by alessio on 9/12/14.
 */
public class Time {
    class TimeEvent implements Comparable<TimeEvent> {
        public int id;
        public double time;
        public Callback callback;

        public TimeEvent (int id, double time, Callback callback) {
            this.id = id;
            this.time = time;
            this.callback = callback;
        }

        @Override
        public int compareTo(TimeEvent timeEvent) {
            return (new Double(this.time)).compareTo(new Double(timeEvent.time));
        }
    }
    private PriorityQueue<TimeEvent> queue = new PriorityQueue<TimeEvent>();
    private ConcurrentSkipListMap<Integer, Boolean> eventIsActive = new ConcurrentSkipListMap<Integer, Boolean>();
    private double time;
    private double deltaTime;
    private int eventCount;

    public double getTime() {
        return time;
    }

    public int registerTimeEvent(double time, Callback callback) {
        queue.add(new TimeEvent(++eventCount, time, callback));
        eventIsActive.put(eventCount, true);
        return eventCount;
    }

    public void cancelTimeEvent(int id) {
        eventIsActive.replace(id, false);
    }

    public void executeEvents() {
        Callback.Attributes attr = new Callback.Attributes();
        attr.putDouble("time", getTime());
        while (!queue.isEmpty() && getTime() > queue.peek().time) {
            TimeEvent e = queue.poll();
            if (eventIsActive.get(e.id))
                e.callback.execute(attr);
            eventIsActive.remove(e.id);
        }
    }

    public void init() {
        time = System.nanoTime() / 1000000000.0;
        deltaTime = 0.0;
        eventCount = -1;
    }

    public double getDeltaTime() {
        return deltaTime;
    }

    public void update() {
        double newTime = System.nanoTime() / 1000000000.0;
        deltaTime = newTime - time;
        time = newTime;
    }

    public void clear() {
        queue.clear();
        eventIsActive.clear();
    }
}
