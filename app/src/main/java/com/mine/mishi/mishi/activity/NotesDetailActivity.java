package com.mine.mishi.mishi.activity;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.widget.TextView;

import com.mine.mishi.mishi.R;
import com.mine.mishi.mishi.base.BaseActivity;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;


public class NotesDetailActivity extends BaseActivity {
    private static final String TAG = "NotesDetailActivity";
    private TextView tv_notes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes_detail);
        initView();
    }

    private void initView() {
        tv_notes = findViewById(R.id.tv_notes);
        SpannableString spannableString = new SpannableString("设置文字的前景色为淡蓝色");
        ForegroundColorSpan colorSpan = new ForegroundColorSpan(Color.parseColor("#0099EE"));
        spannableString.setSpan(colorSpan, 9, spannableString.length(), Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        tv_notes.setText(spannableString);
    }

    @Subscribe(threadMode = ThreadMode.POSTING)
    public void getMessage(String message){
        Log.d(TAG,message);
    }
}
