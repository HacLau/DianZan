package com.mine.mishi.mishi.view;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.mine.mishi.mishi.R;


/**
 * Created by Administrator on 2016/8/4.
 */
public class TitleBar extends RelativeLayout implements View.OnClickListener {

    private ImageView iv_left;
    private ImageView iv_right;
    private TextView tv_title;
    private TextView tv_right;
    private TextView tv_left;
    private Context mContext;
    private View view;
    private View rl_panel;
    private TitleBarListener mListener;
    private boolean isTopPadding = false;

    public TitleBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        view = LayoutInflater.from(mContext).inflate(R.layout.view_title, this);
        init(attrs);
    }

    private void init(AttributeSet attrs) {
        findViews(view);
        initData(attrs);
    }

    private void findViews(View view) {
        iv_left = (ImageView) view.findViewById(R.id.top_left_img);
        tv_title = (TextView) view.findViewById(R.id.top_title);
        tv_right = (TextView) view.findViewById(R.id.top_right_text);

        tv_left = (TextView) view.findViewById(R.id.top_left_text);
        iv_right = (ImageView) view.findViewById(R.id.top_right_img);

        rl_panel = view.findViewById(R.id.rl_panel);
        iv_left.setOnClickListener(this);
        tv_right.setOnClickListener(this);
        tv_left.setOnClickListener(this);
        iv_right.setOnClickListener(this);
    }

    private void initData(AttributeSet attrs) {
        TypedArray arr = mContext.obtainStyledAttributes(attrs, R.styleable.TitleBar);
        Drawable img = arr.getDrawable(R.styleable.TitleBar_tbImage);
        Drawable tbRightImage = arr.getDrawable(R.styleable.TitleBar_tbRightImage);
        String text = arr.getString(R.styleable.TitleBar_tbText);
        String rightText = arr.getString(R.styleable.TitleBar_tbRightText);
        String leftText = arr.getString(R.styleable.TitleBar_tbLeftText);
        int color = arr.getColor(R.styleable.TitleBar_tbTextColor, 0);
        isTopPadding = arr.getBoolean(R.styleable.TitleBar_tbTopPadding, true);

       /* if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT && isTopPadding) {
            rl_panel.setPadding(0, (int) (getResources().getDisplayMetrics().density * 25 + 0.5f), 0, 0);
        }*/
        if (img != null) {
            iv_left.setImageDrawable(img);
            iv_left.setVisibility(View.VISIBLE);
        }
        if (tbRightImage != null){
            iv_right.setImageDrawable(tbRightImage);
            iv_right.setVisibility(View.VISIBLE);
        }
        if (text != null) {
            tv_title.setText(text);
        }
        if (rightText != null) {
            tv_right.setText(rightText);
            tv_right.setVisibility(VISIBLE);
        }
        if (leftText != null) {
            tv_left.setText(leftText);
            tv_left.setVisibility(VISIBLE);
        }
        if (color != 0) {
            tv_title.setTextColor(color);
            tv_right.setTextColor(color);
        }
        arr.recycle();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.top_left_img:
                if (mListener != null) {
                    mListener.onClickBack();
                }
               /* if (mListener == null || mListener.onClickBack()) {

                    ((Activity) mContext).finish();
                    ((Activity) mContext).overridePendingTransition(R.anim.not_exit_push_left_in, R.anim.push_right_out);
                }*/
                break;
            case R.id.top_left_text:
                if (mListener != null) {
                    mListener.onLeftTextClick();
                }
                break;
            case R.id.top_right_text:
                if (mListener != null) {
                    mListener.onRightTextClick();
                }
            case R.id.top_right_img:
                if (mListener != null) {
                    mListener.onRightImageClick();
                }
                break;
        }
    }

    public void setViewBackground( ) {
        this.rl_panel.getBackground().setAlpha(100);
    }

    public void setTitle(String text) {
        tv_title.setText(text);
    }

    public void setTitleBarListener(TitleBarListener listener) {
        mListener = listener;
    }

    public void setTv_right(String text) {
        tv_right.setVisibility(VISIBLE);
        tv_right.setText(text);
    }
    public String getTv_right() {
        return tv_right.getText().toString().trim();
    }
    public void setTv_rightDrow() {
        tv_right.setCompoundDrawables(null,null,getResources().getDrawable(R.mipmap.drow),null);
    }
    public interface TitleBarListener {
        void onLeftTextClick();

        void onRightTextClick();

        boolean onClickBack();

        boolean onRightImageClick();
    }
}
