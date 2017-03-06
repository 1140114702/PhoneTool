package com.phone.phonetool.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.phone.phonetool.R;
import com.phone.phonetool.bean.AppSearchBean;

import java.util.List;

/**
 * Created by zyb on 2017/2/24.
 */

public class AppSearchAdapter extends RecyclerView.Adapter<AppSearchAdapter.MyHolder> {

    private Context mContext;
    private List<AppSearchBean> mList;

    public AppSearchAdapter(List<AppSearchBean> mList) {
        this.mList = mList;
    }

    @Override
    public AppSearchAdapter.MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (mContext == null) {
            mContext = parent.getContext();
        }
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_app_search, parent, false);
        final MyHolder holder = new MyHolder(view);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "第"+holder.getAdapterPosition()+"个", Toast.LENGTH_SHORT).show();
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(AppSearchAdapter.MyHolder holder, int position) {
        Glide.with(mContext).load(R.mipmap.ic_launcher).into(holder.image);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class MyHolder extends RecyclerView.ViewHolder {

        private CardView cardView;
        private ImageView image;

        MyHolder(View itemView) {
            super(itemView);
            cardView = (CardView) itemView;
            image = (ImageView) cardView.findViewById(R.id.item_app_search_icon);
        }
    }
}
