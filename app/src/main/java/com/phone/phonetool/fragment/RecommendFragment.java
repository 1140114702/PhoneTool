package com.phone.phonetool.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.phone.phonetool.R;
import com.phone.phonetool.adapter.AppSearchAdapter;
import com.phone.phonetool.bean.AppSearchBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zyb on 2017/3/6.
 */

public class RecommendFragment extends Fragment {

    private static RecommendFragment instance;

    public static RecommendFragment getInstance() {
        if (instance == null) {
            instance = new RecommendFragment();
        }
        return instance;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_app_search, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        XRecyclerView recyclerView = (XRecyclerView) view.findViewById(R.id.app_search_frag_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setLoadingMoreEnabled(false);
        recyclerView.setPullRefreshEnabled(false);
        List<AppSearchBean> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            AppSearchBean bean = new AppSearchBean();
            list.add(bean);
        }
        ImageView imageView = new ImageView(getActivity());
        imageView.setBackgroundResource(R.mipmap.ic_launcher);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,500);
        imageView.setLayoutParams(layoutParams);
        recyclerView.addHeaderView(imageView);
        recyclerView.setAdapter(new AppSearchAdapter(list));
    }
}
