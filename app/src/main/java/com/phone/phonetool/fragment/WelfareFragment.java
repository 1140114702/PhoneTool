package com.phone.phonetool.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.phone.phonetool.R;
import com.phone.phonetool.adapter.WelfareAdapter;
import com.phone.phonetool.bean.WelfareBean;
import com.phone.phonetool.bean.WelfareChildBean;
import com.phone.phonetool.util.ImgLoad;
import com.phone.phonetool.view.MyExpandListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zyb on 2017/3/6.
 */

public class WelfareFragment extends Fragment implements View.OnClickListener {

    private static WelfareFragment instance;
    private WelfareAdapter adapter;
    private TextView grab;

    public static WelfareFragment getInstance() {
        if (instance == null) {
            instance = new WelfareFragment();
        }
        return instance;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_welfare, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        MyExpandListView expandListView = (MyExpandListView) view.findViewById(R.id.fragment_welfare_expandlistview);
        grab = (TextView) view.findViewById(R.id.item_welfare_head_go);
        grab.setOnClickListener(this);
        expandListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                return true;
            }
        });
        List<WelfareBean> list = new ArrayList<>();
        List<WelfareChildBean> childList = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            WelfareChildBean childBean = new WelfareChildBean();
            childList.add(childBean);
        }
        for (int i = 0; i < 5; i++) {
            WelfareBean bean = new WelfareBean();
            list.add(bean);
            list.get(i).setList(childList);
        }
        if (adapter == null) {
            adapter = new WelfareAdapter(list);
        }
        expandListView.setAdapter(adapter);
        for (int i = 0; i < list.size(); i++) {
            expandListView.expandGroup(i);
        }
        ImgLoad.loadImg(getActivity(), "http://p1.qhimg.com/dm/200_125_/t019f48cb19646f18da.jpg", (ImageView) view.findViewById(R.id.item_welfare_img));
        ImgLoad.loadImg(getActivity(), "http://p16.qhimg.com/dm/30_30_/t013b5e82f3ac3dcfa9.png", (ImageView) view.findViewById(R.id.item_welfare_icon));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.item_welfare_head_go:
                Toast.makeText(getActivity(), "马上抢...", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
