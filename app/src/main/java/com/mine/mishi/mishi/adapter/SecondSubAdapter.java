package com.mine.mishi.mishi.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.widget.CardView;
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
import com.mine.mishi.mishi.bean.SiscoveryH;

import java.util.List;

/**
 * Created by liush on 2019/2/22.
 */

public class SecondSubAdapter extends RecyclerView.Adapter<SecondSubAdapter.SecondSubViewHolder> {
    /**
     * 上下文
     */
    private Context mContext;
    /**
     * 数据集合
     */
    private List<SiscoveryH> data;
    private OnItemClickListener onItemClickListener;

    public void setData(List<SiscoveryH> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }
    public SecondSubAdapter(List<SiscoveryH> data, Context context) {
        this.data = data;
        this.mContext = context;
    }

    @Override
    public SecondSubViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //加载item 布局文件
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_second_sub, parent, false);
        return new SecondSubViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final SecondSubViewHolder holder, final int position) {
        //将数据设置到item上
        final SiscoveryH beauty = data.get(position);

        /*Glide.with(mContext)
                .load(beauty.getImgUrl())
                .centerCrop()
                .placeholder(R.mipmap.ic_launcher)
                .crossFade()
                .into(holder.imageView);*/

        Glide.with(mContext)
                .load(beauty.getGoods_img())
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

        holder.title.setText(beauty.getGoods_name());
        holder.address.setText(beauty.getShop_addres());
        holder.distance.setText(beauty.getShop_longitude());
        holder.sell_price.setText(beauty.getCurve_price()+"");
        holder.original_price.setText(beauty.getMarket_price()+"");
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemClickListener != null) {
                    onItemClickListener.onItemClickListener(beauty);
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
        private TextView address;
        private TextView distance;
        private TextView sell_price;
        private TextView original_price;
        CardView cardView;
        public SecondSubViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image);
            title = itemView.findViewById(R.id.title);
            address = itemView.findViewById(R.id.address);
            distance = itemView.findViewById(R.id.distance);
            sell_price = itemView.findViewById(R.id.sell_price);
            original_price = itemView.findViewById(R.id.original_price);
            original_price.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
            cardView = itemView.findViewById(R.id.card_view);
        }
    }

    public interface OnItemClickListener{
        public boolean onItemClickListener(SiscoveryH beauty);
    }
}