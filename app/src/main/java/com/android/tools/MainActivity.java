package com.android.tools;

import android.os.Bundle;
import android.widget.Toast;

import app.tools.manager.DownloadListener;
import app.tools.manager.DownloadManager;
import app.tools.manager.ErrorMessage;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DownloadManager.init("http://test.360-hotel.com/api/", ErrorMessage.DEFAULT_CONNECTION_ERROR_MESSAGE);
        DownloadManager downloadManager = new DownloadManager(this);
        downloadManager.download(new DeviceTask() {

            @Override
            public void onResult(Object result) throws Exception {
                Toast.makeText(MainActivity.this, "onResult", Toast.LENGTH_SHORT).show();
            }
        });
        downloadManager.setDownloadListener(new DownloadListener() {
            @Override
            public void onNoInternetConnection() {
                super.onNoInternetConnection();
                Toast.makeText(MainActivity.this, "onNoInternetConnection", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(String message) {
                super.onError(message);
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFinishSuccess() {
                super.onFinishSuccess();
                Toast.makeText(MainActivity.this, "onFinishSuccess", Toast.LENGTH_SHORT).show();
            }

        });
        downloadManager.start();
    }

}
