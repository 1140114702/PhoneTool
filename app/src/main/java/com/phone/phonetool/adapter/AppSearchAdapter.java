package com.phone.phonetool.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.phone.phonetool.R;
import com.phone.phonetool.activity.AppDetails;
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
                Intent i = new Intent(mContext, AppDetails.class);
                mContext.startActivity(i);
            }
        });
        holder.appDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "开始下载第" + (holder.getAdapterPosition() - 1) + "个", Toast.LENGTH_SHORT).show();
            }
        });

        SpannableStringBuilder text = new SpannableStringBuilder("下载 999万 次");
        //缩放
        text.setSpan(new RelativeSizeSpan(1.1f), 3, 7, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        //设置颜色
        text.setSpan(new ForegroundColorSpan(Color.parseColor("#ffcc6600")), 3, 7, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        holder.downloadNumber.setText(text);
        return holder;
    }

    @Override
    public void onBindViewHolder(AppSearchAdapter.MyHolder holder, int position) {
        Glide.with(mContext).load(R.drawable.ic_yi_loading).into(holder.image);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class MyHolder extends RecyclerView.ViewHolder {

        private CardView cardView;
        private ImageView image;
        private LinearLayout appDownload;
        private TextView downloadNumber;

        MyHolder(View itemView) {
            super(itemView);
            cardView = (CardView) itemView;
            image = (ImageView) cardView.findViewById(R.id.item_app_search_icon);
            appDownload = (LinearLayout) cardView.findViewById(R.id.item_app_search_download);
            downloadNumber = (TextView) cardView.findViewById(R.id.item_app_search_number);
        }
    }
}
