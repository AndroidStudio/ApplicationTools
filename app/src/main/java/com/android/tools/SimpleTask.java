package com.android.tools;

import app.tools.manager.Downloader;
import app.tools.manager.RequestParams;

public class SimpleTask extends Downloader {
    @Override
    public String onCreateUrl() {
        return getBaseUrl() + "POI/v5/GetList.json";
    }

    @Override
    public void onCreateRequestParams(RequestParams requestParams) {
        requestParams.put("sid", "tajny_sid");
    }

    @Override
    public int onCreateRetryCount() {
        return 0;
    }

    @Override
    public String onCreateRequestMethod() {
        return null;
    }

    @Override
    public Object onDownloadSuccess(String response) throws Exception {
        return null;
    }

}
