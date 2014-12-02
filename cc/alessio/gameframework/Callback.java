package cc.alessio.gameframework;

import java.util.concurrent.ConcurrentSkipListMap;

/**
 * Created by alessio on 3/10/14.
 */
public interface Callback {
    class Attributes extends ConcurrentSkipListMap<String, String> {
        public void putString(String key, String value) {
            put(key, value);
        }

        public String getString(String key) {
            return get(key);
        }

        public void putInteger(String key, Integer value) {
            put(key, String.valueOf(value));
        }

        public Integer getInteger(String key) {
            return Integer.valueOf(get(key));
        }

        public void putFloat(String key, Float value) {
            put(key, String.valueOf(value));
        }

        public Float getFloat(String key) {
            return Float.valueOf(get(key));
        }

        public void putBoolean(String key, Boolean value) {
            put(key, String.valueOf(value));
        }

        public Boolean getBoolean(String key) {
            return Boolean.valueOf(get(key));
        }

        public void putDouble(String key, Double value) {
            put(key, String.valueOf(value));
        }

        public Double getDouble(String key) {
            return Double.valueOf(get(key));
        }

        public void putCharacter(String key, Character value) {
            put(key, String.valueOf(value));
        }

        public Character getCharacter(String key) {
            return Character.valueOf(get(key).charAt(0));
        }
    }
    public void execute(Attributes attr);
}