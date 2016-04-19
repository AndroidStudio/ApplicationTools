package com.android.tools;

import android.os.Environment;

import java.io.File;

import app.tools.manager.Downloader;
import app.tools.manager.MultipartRequestParams;
import app.tools.manager.RequestHeaders;
import app.tools.manager.RequestMethod;
import app.tools.manager.RequestParams;

public class DeviceTask extends Downloader {

    public void onCreateRequestHeaders(RequestHeaders requestHeaders) {
        requestHeaders.put("Access-Token", "5d722e8f0aa1f85a2dea640805bacc5c");
    }

    @Override
    public void onCreateMultipartRequestParams(MultipartRequestParams multipartRequestParams) {
        multipartRequestParams.put("id_room", "3991");
        multipartRequestParams.put("description", "test");

        File folder = Environment.getExternalStorageDirectory();
        File photoFile = new File(folder, "czekolada.jpg");

        multipartRequestParams.put("photo", photoFile);
    }

    @Override
    public String onCreateUrl() {
        return "http://test.360-hotel.com/api/personnel/issue.json";
    }

    @Override
    public void onCreateRequestParams(RequestParams requestParams) {

    }

    @Override
    public int onCreateRetryCount() {
        return 4;
    }

    @Override
    public String onCreateRequestMethod() {
        return RequestMethod.POST;
    }

    @Override
    public Object onDownloadSuccess(String response) throws Exception {

        return response;
    }
}
