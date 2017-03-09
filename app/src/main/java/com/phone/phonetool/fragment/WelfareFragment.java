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
import com.phone.phonetool.util.ImgLoad;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zyb on 2017/3/6.
 */

public class WelfareFragment extends Fragment {

    private static WelfareFragment instance;

    public static WelfareFragment getInstance() {
        if (instance == null) {
            instance = new WelfareFragment();
        }
        return instance;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.item_welfare_head, container, false);
//        initView(view);
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
            bean.setImgUrl("http://file.market.xiaomi.com/thumbnail/PNG/l114/AppStore/0b99955f32bea493d14c0f197197b32b5d2032e14");
            list.add(bean);
        }
        ImageView imageView = new ImageView(getActivity());
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        ImgLoad.loadImg(getActivity(), "http://img23.yidont.com/img/ico/ad/20161028163435.jpg",imageView);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,500);
        imageView.setLayoutParams(layoutParams);
        recyclerView.addHeaderView(imageView);
        recyclerView.setAdapter(new AppSearchAdapter(list));
    }
}
