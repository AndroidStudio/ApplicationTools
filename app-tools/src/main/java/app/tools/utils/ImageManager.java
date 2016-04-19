package app.tools.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class ImageManager {
    private final static String TAG = "PhotoFactory";

    public final static int SELECT_CAMERA_PHOTO_ACTION = 3982;
    public static String originalPhotoPath = null;

    public static void selectPhoto(Activity context, String fileName) {
        try {
            PackageManager packageManager = context.getPackageManager();
            if (!packageManager.hasSystemFeature(PackageManager.FEATURE_CAMERA) && !packageManager.hasSystemFeature(PackageManager.FEATURE_CAMERA_AUTOFOCUS)) {
                Log.e(TAG, "No Camera Detected");
                return;
            }

            File mediaStorageDir = new File(context.getExternalFilesDir(null), "photos");
            if (!mediaStorageDir.exists() && !mediaStorageDir.mkdirs()) {
                return;
            }

            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

            File mediaFile = new File(mediaStorageDir.getPath() + File.separator + fileName + ".jpg");
            Uri fileUri = Uri.fromFile(mediaFile);
            ImageManager.originalPhotoPath = fileUri.getPath();

            intent.putExtra(MediaStore.EXTRA_OUTPUT, fileUri);
            context.startActivityForResult(intent, SELECT_CAMERA_PHOTO_ACTION);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Bitmap getScalePhotoBitmap(Context context, String photoPath, String photoName, int width, int height) {
        Bitmap rotatedBitmap = null;

        try {
            Log.e(TAG, "photoPath: " + photoPath);

            File file = new File(photoPath);
            ExifInterface exif = new ExifInterface(file.getPath());
            int orientation = exif.getAttributeInt(ExifInterface.TAG_ORIENTATION, ExifInterface.ORIENTATION_NORMAL);

            int rotation = 0;

            if (orientation == ExifInterface.ORIENTATION_ROTATE_90) {
                rotation = 90;
            } else if (orientation == ExifInterface.ORIENTATION_ROTATE_180) {
                rotation = 180;
            } else if (orientation == ExifInterface.ORIENTATION_ROTATE_270) {
                rotation = 270;
            }

            Matrix matrix = new Matrix();
            matrix.postRotate(rotation);

            final File folder = new File(context.getExternalFilesDir(null), "photos");
            if (!folder.exists()) {
                folder.mkdirs();
            }

            File destFile = new File(folder, photoName + ".jpg");

            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeStream(new FileInputStream(file), null, options);

            int outWidth = options.outWidth;
            int outHeight = options.outHeight;

            Log.e(TAG, "outWidth: " + outWidth);
            Log.e(TAG, "outHeight: " + outHeight);

            int inSampleSize = calculateInSampleSize(options, width, height);

            Log.e(TAG, "inSampleSize:" + inSampleSize);
            options.inSampleSize = inSampleSize;

            BitmapFactory.decodeStream(new FileInputStream(file), null, options);

            outWidth = options.outWidth;
            outHeight = options.outHeight;

            Log.e(TAG, "scaledBitmapOutWidth: " + outWidth);
            Log.e(TAG, "scaledBitmapOutHeight: " + outHeight);

            options.inJustDecodeBounds = false;
            rotatedBitmap = Bitmap.createBitmap(BitmapFactory.decodeStream(new FileInputStream(file), null, options), 0, 0, outWidth, outHeight, matrix, true);

            FileOutputStream fileOutputStream = new FileOutputStream(destFile);
            rotatedBitmap.compress(Bitmap.CompressFormat.JPEG, 85, fileOutputStream);

            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rotatedBitmap;
    }

    private static int calculateInSampleSize(BitmapFactory.Options options, int reqWidth, int reqHeight) {
        int height = options.outHeight;
        int width = options.outWidth;
        int inSampleSize = 1;
        while (height > reqHeight && width > reqWidth) {
            width = (width / inSampleSize);
            height = (height / inSampleSize);
            inSampleSize += 1;
        }
        return inSampleSize;
    }

}
