package com.phone.phonetool.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.phone.phonetool.R;

import java.util.List;

/**
 * Created by zyb on 2017/2/24.
 */

public class AppDetailsAdapter extends RecyclerView.Adapter<AppDetailsAdapter.MyHolder> {

    private Context mContext;
    private List<String> mList;

    public AppDetailsAdapter(List<String> mList) {
        this.mList = mList;
    }

    @Override
    public AppDetailsAdapter.MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (mContext == null) {
            mContext = parent.getContext();
        }
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_app_details, parent, false);
        final MyHolder holder = new MyHolder(view);
//        holder.image.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(mContext, "第"+holder.getAdapterPosition(), Toast.LENGTH_SHORT).show();
//                Intent i = new Intent(mContext, AppDetailImgs.class);
//                mContext.startActivity(i);
//            }
//        });
        return holder;
    }

    @Override
    public void onBindViewHolder(AppDetailsAdapter.MyHolder holder, int position) {
//        Glide.with(mContext).load(R.drawable.ic_yi_loading).into(holder.image);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class MyHolder extends RecyclerView.ViewHolder {

        private ImageView image;

        MyHolder(View itemView) {
            super(itemView);
            image = (ImageView) itemView.findViewById(R.id.item_app_search_icon);
        }
    }
}
