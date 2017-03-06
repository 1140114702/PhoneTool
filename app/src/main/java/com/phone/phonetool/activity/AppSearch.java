package com.phone.phonetool.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.phone.phonetool.R;
import com.phone.phonetool.fragment.RecommendFragment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by zyb on 2017/3/6.
 */

public class AppSearch extends AppCompatActivity {

    private TabLayout tableLayout;
    private ViewPager viewPager;
    private String[] titles = {"推荐", "软件", "游戏", "福利"};
    private List<String> tabTitles = new ArrayList<>();
    private List<Fragment> fragments = new ArrayList<>();
    private AppSearchAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_search);
        initView();
    }

    private void initView() {
        tableLayout = (TabLayout) findViewById(R.id.app_search_tab_layout);
        viewPager = (ViewPager) findViewById(R.id.app_search_view_pager);

        Collections.addAll(tabTitles, titles);
        for (int i = 0; i < tabTitles.size(); i++) {
            fragments.add(new RecommendFragment());
        }
        if (adapter == null) {
            adapter = new AppSearchAdapter(getSupportFragmentManager(), tabTitles, fragments);
        }
        viewPager.setAdapter(adapter);
        tableLayout.setupWithViewPager(viewPager); //与ViewPager关联
    }

    class AppSearchAdapter extends FragmentPagerAdapter {

        private List<String> tabTitles;
        private List<Fragment> fragmentList;

        AppSearchAdapter(FragmentManager fm, List<String> tabTitles, List<Fragment> fragmentList) {
            super(fm);
            this.tabTitles = tabTitles;
            this.fragmentList = fragmentList;
        }

        //必须实现的，设置fragment
        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }

        //设置标题
        @Override
        public CharSequence getPageTitle(int position) {
            return tabTitles.get(position);
        }

    }
}
