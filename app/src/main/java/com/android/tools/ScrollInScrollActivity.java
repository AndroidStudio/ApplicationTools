package com.android.tools;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ScrollView;

/**
 * Created by WitchUser on 2015-12-29.
 */
public class ScrollInScrollActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scrool_layout);
        ScrollView parentScroll = (ScrollView) findViewById(R.id.parentScroll);
        final ScrollView scrollChild = (ScrollView) findViewById(R.id.scrollChild);

        parentScroll.setOnTouchListener(new View.OnTouchListener() {

            public boolean onTouch(View v, MotionEvent event) {
                scrollChild.getParent().requestDisallowInterceptTouchEvent(false);
                return false;
            }
        });

        scrollChild.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                v.getParent().requestDisallowInterceptTouchEvent(true);
                return false;
            }
        });
    }
}
