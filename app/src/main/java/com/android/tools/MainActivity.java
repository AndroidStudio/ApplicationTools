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
    }

}
