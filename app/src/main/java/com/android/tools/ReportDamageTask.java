package com.android.tools;

import android.os.Environment;

import java.io.File;

import app.tools.manager.Downloader;
import app.tools.manager.MultipartRequestParams;
import app.tools.manager.RequestHeaders;
import app.tools.manager.RequestMethod;
import app.tools.manager.RequestParams;

/**
 * Created by WitchUser on 2016-02-16.
 */
public class ReportDamageTask extends Downloader {
    private final String accessToken;
    private final String placeId;
    private final String description;
    private final File photoFile;
    private final File audioRec;

    public ReportDamageTask(String accessToken, String placeId, String description, File photoFile, File audioRec) {
        this.accessToken = accessToken;
        this.placeId = placeId;
        this.description = description;
        this.photoFile = photoFile;
        this.audioRec = audioRec;
    }

    @Override
    public String onCreateUrl() {
        return "http://test.360-hotel.com/api/personnel/issue.json";
    }

    @Override
    public void onCreateRequestParams(RequestParams requestParams) {
    }

    @Override
    public void onCreateRequestHeaders(RequestHeaders requestHeaders) {
        requestHeaders.put("Access-Token", accessToken);
    }

    @Override
    public void onCreateMultipartRequestParams(MultipartRequestParams multipartRequestParams) {

        File folder = Environment.getExternalStorageDirectory();
        File photoFile = new File(folder, "czekolada.jpg");


        multipartRequestParams.put("id_room", placeId);
        multipartRequestParams.put("photo", photoFile);
        multipartRequestParams.put("description", description);
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
        return null;
    }
}
