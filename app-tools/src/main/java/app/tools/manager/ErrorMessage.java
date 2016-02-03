package app.tools.manager;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Przemek on 2015-12-20.
 */
public class ErrorMessage {
    private final static List<String> errorMessageList = new ArrayList<>();
    public static String DEFAULT_CONNECTION_ERROR_MESSAGE;

    public ErrorMessage(Context context) {
        DEFAULT_CONNECTION_ERROR_MESSAGE = "Błąd połączenia...";
    }

    public static String addError(String errorMessage) {
        errorMessageList.add(errorMessage);
        return errorMessage;
    }

    public static boolean containsError(String errorMessage) {
        return errorMessageList.contains(errorMessage);
    }
}
