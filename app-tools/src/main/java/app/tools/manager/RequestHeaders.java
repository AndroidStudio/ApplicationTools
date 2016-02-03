package app.tools.manager;

import java.util.HashMap;

/**
 * Created by WitchUser on 2015-12-28.
 */
public class RequestHeaders {

    private final HashMap<String, String> urlParams = new HashMap<>();

    public void put(String key, String value) {
        urlParams.put(key, value);
    }

    public HashMap<String, String> getHeaders() {
        return urlParams;
    }
}
