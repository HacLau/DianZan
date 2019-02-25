package com.mine.mishi.mishi.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.mine.mishi.mishi.R;
import com.mine.mishi.mishi.base.BaseActivity;
import com.mine.mishi.mishi.utils.Utility;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class LoginActivity extends BaseActivity {
    private static final String TAG = "LoginActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

    }

    @Subscribe(threadMode = ThreadMode.POSTING)
    public void getMessage(String message){
        Log.d(TAG,message);
    }
}
