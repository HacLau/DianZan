package com.mine.mishi.mishi.activity;

import android.databinding.DataBindingUtil;
import android.graphics.Movie;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.mine.mishi.mishi.HttpRequestLocal.HttpLogin;
import com.mine.mishi.mishi.HttpRequestLocal.HttpNoteSIMPort;
import com.mine.mishi.mishi.HttpRequestLocal.HttpSiscoveryH;
import com.mine.mishi.mishi.R;
import com.mine.mishi.mishi.base.BaseActivity;
import com.mine.mishi.mishi.bean.BaseRequest;
import com.mine.mishi.mishi.databinding.ActivityLoginBinding;
import com.mine.mishi.mishi.url.RetrofitLoader;
import com.mine.mishi.mishi.utils.SharedPreferencesUtil;
import com.mine.mishi.mishi.utils.Utility;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.RequestBody;
import rx.functions.Action1;

public class LoginActivity extends BaseActivity implements View.OnClickListener {
    private static final String TAG = "LoginActivity";
    private ActivityLoginBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_login);
        initView();
    }

    private void initView() {
        binding.loginBtnJoin.setOnClickListener(this);
        binding.loginGetVer.setOnClickListener(this);

    }

    @Subscribe(threadMode = ThreadMode.POSTING)
    public void getMessage(String message){
        Log.d(TAG,message);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.login_btn_join:
                goToLogin();
                break;
            case R.id.login_get_ver:
                getVer();
                break;
        }
    }

    private void goToLogin() {
        HttpLogin httpLogin = new HttpLogin();
        httpLogin.setPhone(binding.loginUserMobile.getText().toString().trim());
        httpLogin.setCode("9999");
        RetrofitLoader mRetrofitLoader = new RetrofitLoader();
        mRetrofitLoader.goLogin(httpLogin).subscribe(new Action1<BaseRequest<String>>() {
            @Override
            public void call(BaseRequest<String> listBaseRequest) {
                if (200 == listBaseRequest.getCode() && listBaseRequest.isIsOk()) {
                    //gotoActivity(LoginActivity.this,MainActivity.class,null);
                    SharedPreferencesUtil.getInstance(LoginActivity.this).putString("userid",listBaseRequest.getData());
                    finish();
                }
                Log.e("TAG","success message:" + listBaseRequest.toString());
            }
        }, new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {
                Log.e("TAG","error message:" + throwable.getMessage());
            }
        });
    }

    private void getVer() {

        HttpNoteSIMPort params = new HttpNoteSIMPort();
        params.setPhone(binding.loginUserMobile.getText().toString().trim());
        RetrofitLoader mRetrofitLoader = new RetrofitLoader();
        mRetrofitLoader.goVer(params).subscribe(new Action1<BaseRequest<String>>() {

            @Override
            public void call(BaseRequest<String> s) {
                if (200 == s.getCode() && s.isIsOk()) {

                }
                Log.e("TAG","success message:" + s.toString());
            }
        }, new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {
                Log.e("TAG","error message:" + throwable.getMessage());
            }
        });
    }

}
