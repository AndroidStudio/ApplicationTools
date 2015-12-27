package com.android.tools;

import android.graphics.Color;
import android.os.Bundle;

import app.tools.manager.DownloadManager;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DownloadManager downloadManager = new DownloadManager(this);
        //downloadManager.showProgressDialog("title", "message", false, Color.BLACK);
        downloadManager.showProgressDialog("message");

        downloadManager.download(new SimpleTask() {
            @Override
            public void onResult(Object result) {

            }
        });
        downloadManager.start();
    }

}
