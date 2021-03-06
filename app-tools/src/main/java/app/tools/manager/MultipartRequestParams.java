package app.tools.manager;

import java.util.HashMap;

/**
 * Created by WitchUser on 2016-02-16.
 */
public class MultipartRequestParams {

    private final HashMap<String, Object> fileParams = new HashMap<>();

    public void put(String key, Object value) {
        fileParams.put(key, value);
    }

    public HashMap<String, Object> getFileRequestParams() {
        return fileParams;
    }
}
