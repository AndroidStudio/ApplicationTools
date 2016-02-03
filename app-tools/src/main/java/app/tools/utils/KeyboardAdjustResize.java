package app.tools.utils;

import android.app.Activity;
import android.graphics.Rect;
import android.os.Handler;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;

public class KeyboardAdjustResize {

    private final Activity activity;

    public static void registerActivity(Activity activity) {
        new KeyboardAdjustResize(activity);
    }

    private View childOfContent;
    private int usableHeightPrevious;
    private FrameLayout.LayoutParams frameLayoutParams;
    private final Handler handler = new Handler();

    private KeyboardAdjustResize(Activity activity) {
        this.activity = activity;
        handler.postDelayed(runnable, 1000);
    }

    private final Runnable runnable = new Runnable() {
        @Override
        public void run() {
            FrameLayout content = (FrameLayout) activity.findViewById(android.R.id.content);
            childOfContent = content.getChildAt(0);
            if (childOfContent == null) {
                handler.postDelayed(runnable, 1000);
                return;
            }
            childOfContent.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                public void onGlobalLayout() {
                    possiblyResizeChildOfContent();
                }
            });
            frameLayoutParams = (FrameLayout.LayoutParams) childOfContent.getLayoutParams();
        }
    };

    private void possiblyResizeChildOfContent() {
        int usableHeightNow = computeUsableHeight();
        if (usableHeightNow != usableHeightPrevious) {
            int usableHeightSansKeyboard = childOfContent.getRootView().getHeight();
            int heightDifference = usableHeightSansKeyboard - usableHeightNow;
            if (heightDifference > (usableHeightSansKeyboard / 4)) {
                frameLayoutParams.height = usableHeightSansKeyboard - heightDifference;
            } else {
                frameLayoutParams.height = usableHeightSansKeyboard;
            }
            childOfContent.requestLayout();
            usableHeightPrevious = usableHeightNow;
        }
    }

    private int computeUsableHeight() {
        Rect r = new Rect();
        childOfContent.getWindowVisibleDisplayFrame(r);
        return (r.bottom - r.top);
    }

}