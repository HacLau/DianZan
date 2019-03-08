package com.mine.mishi.mishi.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.mine.mishi.mishi.R;
import com.mine.mishi.mishi.bean.SMyOrder;
import com.mine.mishi.mishi.entity.MineMenuEntity;

import java.util.List;

/**
 * Created by liush on 2019/2/22.
 */

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.SecondSubViewHolder> {
    /**
     * 上下文
     */
    private Context mContext;
    /**
     * 数据集合
     */
    private List<SMyOrder> data;

    private OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public OrderAdapter(List<SMyOrder> data, Context context) {
        this.data = data;
        this.mContext = context;
    }

    public void setData(List<SMyOrder> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @Override
    public SecondSubViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //加载item 布局文件
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_order, parent, false);
        return new SecondSubViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final SecondSubViewHolder holder, final int position) {
        //将数据设置到item上
        SMyOrder beauty = data.get(position);

        /*Glide.with(mContext)
                .load(beauty.getImgUrl())
                .centerCrop()
                .placeholder(R.mipmap.ic_launcher)
                .crossFade()
                .into(holder.imageView);*/

        /*Glide.with(mContext)
                .load(beauty.beauty())
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
        });*/

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    static class SecondSubViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView title;
        private TextView address;
        private TextView price;
        private TextView validity;
        private Button toUser;

        private LinearLayout card_view;

        public SecondSubViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image);
            title = itemView.findViewById(R.id.title);
            address = itemView.findViewById(R.id.address);
            price = itemView.findViewById(R.id.sell_price);
            validity = itemView.findViewById(R.id.validity);
            toUser = itemView.findViewById(R.id.use);
            card_view = itemView.findViewById(R.id.card_view);
        }
    }

    public interface OnItemClickListener{
        public boolean onItemClickListener(int position);
    }
}