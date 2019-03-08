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
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.mine.mishi.mishi.R;
import com.mine.mishi.mishi.entity.MineMenuEntity;

import java.util.List;

/**
 * Created by liush on 2019/2/22.
 */

public class MineMenuAdapter extends RecyclerView.Adapter<MineMenuAdapter.SecondSubViewHolder> {
    /**
     * 上下文
     */
    private Context mContext;
    /**
     * 数据集合
     */
    private List<MineMenuEntity> data;

    private OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public MineMenuAdapter(List<MineMenuEntity> data, Context context) {
        this.data = data;
        this.mContext = context;
    }

    @Override
    public SecondSubViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //加载item 布局文件
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.mine_menu, parent, false);
        return new SecondSubViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final SecondSubViewHolder holder, final int position) {
        //将数据设置到item上
        MineMenuEntity beauty = data.get(position);

        /*Glide.with(mContext)
                .load(beauty.getImgUrl())
                .centerCrop()
                .placeholder(R.mipmap.ic_launcher)
                .crossFade()
                .into(holder.imageView);*/

        Glide.with(mContext)
                .load(beauty.getId())
                .asBitmap()
                .centerCrop()
                .placeholder(R.mipmap.ic_launcher)
                .diskCacheStrategy(DiskCacheStrategy.ALL) //设置缓存
                .into(new BitmapImageViewTarget(holder.imageView){
                    @Override
                    protected void setResource(Bitmap resource) {
                        super.setResource(resource);
                        RoundedBitmapDrawable circularBitmapDrawable =
                                RoundedBitmapDrawableFactory.create(mContext.getResources(), resource);
                        circularBitmapDrawable.setCornerRadius(5); //设置圆角弧度
                        holder.imageView.setImageDrawable(circularBitmapDrawable);
                    }
                });

        holder.title.setText(beauty.getTitle());
        holder.linear_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemClickListener != null) {
                    onItemClickListener.onItemClickListener(position);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    static class SecondSubViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView title;
        private LinearLayout linear_layout;

        public SecondSubViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image);
            title = itemView.findViewById(R.id.title);
            linear_layout = itemView.findViewById(R.id.linear_layout);

        }
    }

    public interface OnItemClickListener{
        public boolean onItemClickListener(int position);
    }
}