package jude.kakao.com.codingtest;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface.OnClickListener;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetDialog;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.View;

import org.apache.commons.lang3.StringUtils;

import java.util.concurrent.atomic.AtomicInteger;

public class ToastUtils {
    public final static int LENGTH_SHORT = android.widget.Toast.LENGTH_SHORT;
    public final static int LENGTH_LONG = android.widget.Toast.LENGTH_LONG;

    private static android.widget.Toast mToast;
    private static ProgressDialog waitingDialog;
    private static Snackbar mSnackbar;
    private static BottomSheetDialog mBottomSheet;
    private static BottomSheetBehavior<View> behavior;


    public static void show(Activity activity, int res, int duration) {
        show(activity, activity.getString(res), duration);
    }

    public synchronized static void show(Activity activity, String text, int duration) {
        if (mToast != null) {
            try {
                mToast.cancel();
            } catch (Exception e) {

            }
        }
        try {
            mToast = android.widget.Toast.makeText(activity, text, duration);
        } catch (RuntimeException e) {
            e.printStackTrace();
            return;
        }
        mToast.show();
    }

    public static void alert(Activity act, String title, String message, boolean cancelable, OnClickListener ok) {
        AlertDialog.Builder builder;
        builder = new AlertDialog.Builder(act);
        if (act != null) {
            builder = new AlertDialog.Builder(act);
        }

        if (!StringUtils.isEmpty(title)) {
            builder.setTitle(title);
        }

        builder.setCancelable(cancelable);
        builder.setMessage(message);
        builder.setPositiveButton(android.R.string.ok, ok);
        try {
            builder.create().show();
        } catch (Throwable e) {
            Log.e(ToastUtils.class.getName(), e.toString(), e);
        }
    }
    /**
     * 버튼없는 snackbar 생성
     *
     * @param layout cordinatorlayout
     * @param msg 보여질 메세지
     * @param duration SnackBar.LENGTH_SHORT | SnackBar.LENGTH_LONG | SnackBar.LENGTH_INDEFINITE
     */

    public static void showSnackbar(final CoordinatorLayout layout, String msg, int duration) {
        mSnackbar = Snackbar
                .make(layout, msg, duration);
        mSnackbar.show();
    }

    public static void removeSnackbar() {
        if(mSnackbar != null)
            mSnackbar.dismiss();
    }

    private static final AtomicInteger sNextGeneratedId = new AtomicInteger(1);
    public static int generateViewId() {
        for (;;) {
            final int result = sNextGeneratedId.get();
            // aapt-generated IDs have the high byte nonzero; clamp to the range under that.
            int newValue = result + 1;
            if (newValue > 0x00FFFFFF) newValue = 1; // Roll over to 1, not 0.
            if (sNextGeneratedId.compareAndSet(result, newValue)) {
                return result;
            }
        }
    }
}
