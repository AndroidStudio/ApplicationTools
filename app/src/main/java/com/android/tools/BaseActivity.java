package com.android.tools;

import android.app.Activity;
import android.os.Bundle;

import app.tools.manager.DownloadManager;
import app.tools.manager.ErrorMessage;

public class BaseActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DownloadManager.init("http://test.360-hotel.com/api/",
                ErrorMessage.DEFAULT_CONNECTION_ERROR_MESSAGE);
    }
}
