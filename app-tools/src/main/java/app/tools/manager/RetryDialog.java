package app.tools.manager;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

public class RetryDialog extends AlertDialog.Builder {

    public RetryDialog(Context context, String title, String message) {
        super(context);
        setTitle(title);
        setMessage(message);
        setPositiveButton("Ponów", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.dismiss();
                onRetry();

            }
        });
        setNegativeButton("Anuluj", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.dismiss();
                onCancel();

            }
        });
        create().show();
    }

    public void onCancel() {

    }

    public void onRetry() {

    }

}