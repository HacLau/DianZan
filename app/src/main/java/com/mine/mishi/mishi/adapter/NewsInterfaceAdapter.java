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
import com.mine.mishi.mishi.entity.NewsInterfaceEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liush on 2019/2/22.
 */

public class NewsInterfaceAdapter extends RecyclerView.Adapter<NewsInterfaceAdapter.SecondSubViewHolder> {
    /**
     * 上下文
     */
    private Context mContext;

    private String positionData = "";
    /**
     * 数据集合
     */
    private List<NewsInterfaceEntity> data;

    private List<String> timeBuffer = new ArrayList<>();

    public NewsInterfaceAdapter(List<NewsInterfaceEntity> data, Context context) {
        this.data = data;
        this.mContext = context;
    }

    @Override
    public int getItemViewType(int position) {
        //0 是新的，1是已经有了的
        if (position == 0){
            return 1;
        }else{
            if(data.get(position - 1).getData().equals(data.get(position).getData())){
                return 0;
            }else{
                return 1;
            }
        }
        //positionData = data.get(position);
    }

    @Override
    public SecondSubViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //加载item 布局文件
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_news_layout, parent, false);
        return new SecondSubViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final SecondSubViewHolder holder, int position) {
        if(getItemViewType(position) == 0){
            holder.time.setVisibility(View.GONE);
            //holder.timeLine.setVisibility(View.GONE);
        }else{
            holder.time.setVisibility(View.VISIBLE);
            //holder.timeLine.setVisibility(View.VISIBLE);
        }

        //将数据设置到item上
        NewsInterfaceEntity beauty = data.get(position);

        /*Glide.with(mContext)
                .load(beauty.getImgUrl())
                .centerCrop()
                .placeholder(R.mipmap.ic_launcher)
                .crossFade()
                .into(holder.imageView);*/

        Glide.with(mContext)
                .load(beauty.getHeadUrl())
                .asBitmap()
                .centerCrop()
                .placeholder(R.mipmap.ic_launcher)
                .diskCacheStrategy(DiskCacheStrategy.ALL) //设置缓存
                .into(new BitmapImageViewTarget(holder.head){
                    @Override
                    protected void setResource(Bitmap resource) {
                        super.setResource(resource);
                        RoundedBitmapDrawable circularBitmapDrawable =
                                RoundedBitmapDrawableFactory.create(mContext.getResources(), resource);
                        circularBitmapDrawable.setCornerRadius(5); //设置圆角弧度
                        holder.head.setImageDrawable(circularBitmapDrawable);
                    }
                });

        Glide.with(mContext)
                .load(beauty.getHeadUrl())
                .asBitmap()
                .centerCrop()
                .placeholder(R.mipmap.ic_launcher)
                .diskCacheStrategy(DiskCacheStrategy.ALL) //设置缓存
                .into(new BitmapImageViewTarget(holder.image){
                    @Override
                    protected void setResource(Bitmap resource) {
                        super.setResource(resource);
                        RoundedBitmapDrawable circularBitmapDrawable =
                                RoundedBitmapDrawableFactory.create(mContext.getResources(), resource);
                        circularBitmapDrawable.setCornerRadius(5); //设置圆角弧度
                        holder.image.setImageDrawable(circularBitmapDrawable);
                    }
                });


        holder.name.setText(beauty.getUserName());
        holder.desc.setText(beauty.getDesc());
        holder.time.setText(beauty.getData());

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    static class SecondSubViewHolder extends RecyclerView.ViewHolder {
        private ImageView head;
        private TextView name;
        private TextView desc;
        private ImageView image;
        private TextView time;
        //private View timeLine;

        public SecondSubViewHolder(View itemView) {
            super(itemView);
            head = itemView.findViewById(R.id.head);
            name = itemView.findViewById(R.id.name);
            desc = itemView.findViewById(R.id.desc);
            image = itemView.findViewById(R.id.image);
            time = itemView.findViewById(R.id.time);
            //timeLine = itemView.findViewById(R.id.time_line);

        }
    }
}