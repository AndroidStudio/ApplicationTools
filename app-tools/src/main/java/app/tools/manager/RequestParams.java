package app.tools.manager;

import java.util.HashMap;

/**
 * Created by Przemek on 2015-12-18.
 */
public class RequestParams {

    private final HashMap<String, String> urlParams = new HashMap<>();

    public void put(String key, String value) {
        urlParams.put(key, value);
    }

    public void put(String key, double value) {
        urlParams.put(key, String.valueOf(value));
    }

    public void put(String key, int value) {
        urlParams.put(key, String.valueOf(value));
    }

    public void put(String key, float value) {
        urlParams.put(key, String.valueOf(value));
    }

    public HashMap<String, String> getUrlParams() {
        return urlParams;
    }
}
