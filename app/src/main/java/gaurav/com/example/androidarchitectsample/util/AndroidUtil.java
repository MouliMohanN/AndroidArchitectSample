package gaurav.com.example.androidarchitectsample.util;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Service;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Color;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.design.widget.Snackbar;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

/**
 * Created by sivaprasadg on 10/6/16.
 */

public class AndroidUtil {
    /**
     * @param activity
     */
    public static void hideKeyBoard(Activity activity, View view) {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Service.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    /**
     * Converts pixels into dip.
     *
     * @param context
     * @param px
     * @return
     */
    public int convertPixelToDP(Context context, int px) {
        Resources resources = context.getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        int dp = (int) (px * (metrics.densityDpi / 160f));
        return dp;
    }

    /**
     * Converts dpi into pixels.
     *
     * @param context
     * @param dp
     * @return integer value
     */
    public static int convertDpToPixel(Context context, float dp) {
        Resources resources = context.getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        int px = (int) (dp / (metrics.densityDpi / 160f));
        return px;
    }

    public static float dpToPx(Context context, float valueInDp) {
        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, valueInDp, metrics);
    }

    /**
     * @param context
     * @return
     */
    public static int getDisplayWidth(Context context) {
        if (context != null) {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            return displayMetrics.widthPixels;
        }
        return 0;
    }

    /**
     * @param context
     * @return
     */
    // DeviceDimensionsHelper.getDisplayHeight(context) => (display height in pixels)
    public static int getDisplayHeight(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return displayMetrics.heightPixels;
    }

    /**
     * @param view
     * @param msg
     * @param hexaColorCode
     */
    private static void showSnackBar(View view, String msg, String hexaColorCode) {
        Snackbar snackBar = Snackbar.make(view, msg, Snackbar.LENGTH_LONG);
        if (hexaColorCode != null) {
            snackBar.getView().setBackgroundColor(Color.parseColor(hexaColorCode));
        }
        snackBar.show();
    }

    /**
     * @param view
     * @param msg
     */
    public static void showSnackBar(View view, String msg) {
        showSnackBar(view, msg, null);
    }

    public static String getRealPathFromURI(Activity activity, Uri contentURI, boolean isImage) {
        String result;
        Cursor cursor = activity.getContentResolver().query(contentURI, null, null, null, null);
        if (cursor == null) { // Source is Dropbox or other similar local file path
            result = contentURI.getPath();
        } else {
            cursor.moveToFirst();
            int idx;
            if (isImage) {
                idx = cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA);
            } else {
                idx = cursor.getColumnIndex(MediaStore.Video.VideoColumns.DATA);
            }
            result = cursor.getString(idx);
            cursor.close();
        }
        return result;
    }

    public static void showErrorDialog(Context context, String message, DialogInterface.OnClickListener onClickListener) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
        alertDialogBuilder.setMessage(message);
        alertDialogBuilder.setPositiveButton("Ok", onClickListener);

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.setCanceledOnTouchOutside(false);
        alertDialog.show();
    }
}
