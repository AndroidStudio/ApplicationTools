package app.tools.manager;

import android.content.Context;

public abstract class Downloader {

    private DownloadManager downloadManager;
    private Context context;

    public abstract String onCreateUrl();

    public abstract void onCreateRequestParams(RequestParams requestParams);

    public abstract void onCreateRequestHeaders(RequestHeaders requestHeaders);

    public abstract void onCreateMultipartRequestParams(MultipartRequestParams multipartRequestParams);

    public abstract int onCreateRetryCount();

    public abstract String onCreateRequestMethod();

    public abstract Object onDownloadSuccess(String response) throws Exception;

    public void init(DownloadManager downloadManager, Context context) {
        this.downloadManager = downloadManager;
        this.context = context;
    }

    public Context getContext() {
        return context;
    }

    public DownloadManager getDownloadManager() {
        return downloadManager;
    }

    public Exception exception(String errorMessage) {
        ErrorMessage.addError(errorMessage);
        return new Exception(errorMessage);
    }

    public void onResult(Object result) throws Exception {

    }

    public String getBaseUrl() {
        return DownloadManager.getBaseUrl();
    }
}
