package com.mine.mishi.mishi.base;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;


import com.mine.mishi.mishi.R;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by Administrator on 2017/5/3 0003.
 */

public abstract class BaseActivity extends AppCompatActivity {
    // 上下文实例
    protected Context mContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EventBus.getDefault().register(this);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            //setTranslucentStatus(true);
            if (getStatusBarColor() != 0) {
                SystemBarTintManager tintManager = new SystemBarTintManager(this);
                tintManager.setStatusBarTintEnabled(true);
                tintManager.setStatusBarTintResource(getStatusBarColor());//通知栏所需颜色
            }
        }
        mContext = this;

    }

    protected void setChangeNotifaction(boolean b){
        if (b){
            setTranslucentStatus(true);
        }
    }

   @TargetApi(19)
    private void setTranslucentStatus(boolean on) {
        Window win = getWindow();
        WindowManager.LayoutParams winParams = win.getAttributes();
        final int bits = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
        if (on) {
            winParams.flags |= bits;
        } else {
            winParams.flags &= ~bits;
        }
        win.setAttributes(winParams);
    }

    public void hideKeyboard() {
        if ((getWindow().getAttributes().softInputMode != 2) && (getCurrentFocus() != null)) {
            ((InputMethodManager) getSystemService(INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 2);
        }
    }

    protected int getStatusBarColor() {
        return 0;
    }

    @Override
    protected void onActivityResult(int arg0, int arg1, Intent arg2) {
        super.onActivityResult(arg0, arg1, arg2);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    /**
     * 跳转到某个Activity
     */
    public void gotoActivity(Context mContext, Class<?> toActivityClass, Bundle bundle) {
        Intent intent = new Intent(mContext, toActivityClass);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        mContext.startActivity(intent);
        ((Activity) mContext).overridePendingTransition(R.anim.push_right_in, R.anim.not_exit_push_left_out);
    }

    /**
     * 退出到某个Activity
     */
    protected void backActivity() {
        finish();
        overridePendingTransition(R.anim.not_exit_push_left_in, R.anim.push_right_out);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // 所有需要统一处理的onKeyDown写在这个if里面
        if (isExtendsBaseOnKeyDown()) {
            if (keyCode == KeyEvent.KEYCODE_BACK) {
                backActivity();
                return true;
            }
        }
        return super.onKeyDown(keyCode, event);
    }

    protected boolean isExtendsBaseOnKeyDown() {
        return true;
    }



    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }
}
