package com.mine.mishi.mishi.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.mine.mishi.mishi.R;
import com.mine.mishi.mishi.bean.IndexSubEntity;

import java.util.List;

/**
 * Created by liush on 2019/2/22.
 */

public class IndexSubAdapter extends RecyclerView.Adapter<IndexSubAdapter.BeautyViewHolder> {
    /**
     * 上下文
     */
    private Context mContext;
    /**
     * 数据集合
     */
    private List<IndexSubEntity> data;

    public IndexSubAdapter(List<IndexSubEntity> data, Context context) {
        this.data = data;
        this.mContext = context;
    }

    @Override
    public BeautyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //加载item 布局文件
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.index_sub_item, parent, false);
        return new BeautyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final BeautyViewHolder holder, int position) {
        //将数据设置到item上
        IndexSubEntity beauty = data.get(position);
        //holder.beautyImage.setBackgroundResource(beauty.getImageIcon());
        /*Glide.with(mContext)
                .load(beauty.getImageIcon())
                .asBitmap()//强制Glide返回一个Bitmap对象
                .into(new SimpleTarget<Bitmap>() {
                    @Override
                    public void onResourceReady(Bitmap bitmap, GlideAnimation<? super Bitmap> glideAnimation) {
                        int width = bitmap.getWidth();
                        int height = bitmap.getHeight();
                        Log.d(TAG, "width " + width); //200px
                        Log.d(TAG, "height " + height); //200px
                        //holder.beautyImage.setImageBitmap(bitmap);

                        LinearLayout.LayoutParams linearParams = (LinearLayout.LayoutParams) holder.beautyImage.getLayoutParams();
                        int mWidth = holder.beautyImage.getWidth();
                        int mHeight = holder.beautyImage.getHeight();
                        linearParams.width = mWidth;
                        linearParams.height = height * mWidth / width;
                        holder.beautyImage.setLayoutParams(linearParams);
                    }
                });*/
        /*Glide.with(mContext)
                .load(beauty.getImageIcon())
                .centerCrop()
                .placeholder(R.mipmap.ic_launcher)
                .crossFade()
                .into(holder.beautyImage);*/
        Glide.with(mContext)
                .load(beauty.getImageIcon())
                .asBitmap()
                .centerCrop()
                .placeholder(R.mipmap.ic_launcher)
                .diskCacheStrategy(DiskCacheStrategy.ALL) //设置缓存
                .into(new BitmapImageViewTarget(holder.beautyImage){
                    @Override
                    protected void setResource(Bitmap resource) {
                        super.setResource(resource);
                        RoundedBitmapDrawable circularBitmapDrawable =
                                RoundedBitmapDrawableFactory.create(mContext.getResources(), resource);
                        circularBitmapDrawable.setCornerRadius(5); //设置圆角弧度
                        holder.beautyImage.setImageDrawable(circularBitmapDrawable);
                    }
                });

        Glide.with(mContext)
                .load(beauty.getHeadIcon())
                .placeholder(R.mipmap.ic_launcher)
                .into(holder.personIcon);
        Glide.with(mContext)
                .load(beauty.getLikeIcon())
                .placeholder(R.mipmap.ic_launcher)
                .into(holder.likeIcon);

        holder.nameTv.setText(beauty.getIamagedesc());
        holder.personName.setText(beauty.getName());
        holder.likeNumber.setText(beauty.getLikeNumber());

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    static class BeautyViewHolder extends RecyclerView.ViewHolder {
        ImageView beautyImage;
        TextView nameTv;

        ImageView personIcon;
        TextView personName;

        ImageView likeIcon;
        TextView likeNumber;

        public BeautyViewHolder(View itemView) {
            super(itemView);
            beautyImage = itemView.findViewById(R.id.image_address);
            nameTv = itemView.findViewById(R.id.image_desc);

            personIcon = itemView.findViewById(R.id.person_head);
            personName = itemView.findViewById(R.id.person_name);

            likeIcon = itemView.findViewById(R.id.like_icon);
            likeNumber = itemView.findViewById(R.id.like_number);
        }
    }
}