package com.phone.phonetool.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.phone.phonetool.R;
import com.phone.phonetool.bean.WelfareBean;
import com.phone.phonetool.util.ImgLoad;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zyb on 2017/3/10.
 */

public class WelfareAdapter extends BaseExpandableListAdapter {

    private List<WelfareBean> list = new ArrayList<>();

    public WelfareAdapter(List<WelfareBean> list) {
        this.list = list;
    }

    @Override
    public int getGroupCount() {
        return list.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return list.get(groupPosition).getList().size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return list.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return list.get(groupPosition).getList().get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        final Context context = parent.getContext();
        GroupHolder holder;
        if (convertView == null) {
            holder = new GroupHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.item_welfare_group, parent, false);
            holder.textView = (TextView) convertView.findViewById(R.id.item_welfare_title);
            holder.more = (LinearLayout) convertView.findViewById(R.id.item_welfare_more);
            convertView.setTag(holder);
        }else {
            holder = (GroupHolder) convertView.getTag();
        }

        holder.more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "更多", Toast.LENGTH_SHORT).show();
            }
        });
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, final ViewGroup parent) {
        final Context context = parent.getContext();
        ChildHolder holder;
        if (convertView == null) {
            holder = new ChildHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.item_welfare_child, parent, false);
            holder.textView = (TextView) convertView.findViewById(R.id.item_welfare_child_title);
            holder.grab = (TextView) convertView.findViewById(R.id.item_welfare_child_go);
            holder.img = (ImageView) convertView.findViewById(R.id.item_welfare_child_img);
            holder.icon = (ImageView) convertView.findViewById(R.id.item_welfare_child_icon);
            convertView.setTag(holder);
        }else {
            holder = (ChildHolder) convertView.getTag();
        }

        holder.grab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "马上抢", Toast.LENGTH_SHORT).show();
            }
        });
        ImgLoad.loadImg(context, "http://p1.qhimg.com/dm/200_125_/t019f48cb19646f18da.jpg",holder.img);
        ImgLoad.loadImg(context, "http://p16.qhimg.com/dm/30_30_/t013b5e82f3ac3dcfa9.png",holder.icon);
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }

    private class GroupHolder {
        TextView textView;
        LinearLayout more;
    }

    private class ChildHolder {
        TextView textView;
        TextView grab;
        ImageView img;
        ImageView icon;
    }
}
