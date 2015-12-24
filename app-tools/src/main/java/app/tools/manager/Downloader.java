package app.tools.manager;

import android.content.Context;

public abstract class Downloader {

    private Context context;

    public abstract String onCreateUrl();

    public abstract void onCreateRequestParams(RequestParams requestParams);

    public abstract int onCreateRetryCount();

    public abstract String onCreateRequestMethod();

    public abstract Object onDownloadSuccess(String response) throws Exception;

    public void init(Context context) {
        this.context = context;
    }

    public Context getContext() {
        return context;
    }

    public Exception exception(String errorMessage) {
        ErrorMessage.addError(errorMessage);
        return new Exception(errorMessage);
    }

    public void onResult(Object result) {

    }
}
