package com.phone.phonetool.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.phone.phonetool.R;
import com.phone.phonetool.fragment.RecommendFragment;
import com.phone.phonetool.fragment.WelfareFragment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by zyb on 2017/3/6.
 */

public class AppSearch extends AppCompatActivity implements View.OnClickListener {

    private TabLayout tableLayout;
    private ViewPager viewPager;
    private String[] titles = {"推荐", "软件", "游戏", "福利"};
    private List<String> tabTitles = new ArrayList<>();
    private List<Fragment> fragments = new ArrayList<>();
    private AppSearchAdapter adapter;
    private EditText searchEdit;
    private ImageView clearText;
    private ImageView searchView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_search);
        initView();
    }

    private void initView() {
        tableLayout = (TabLayout) findViewById(R.id.app_search_tab_layout);
        viewPager = (ViewPager) findViewById(R.id.app_search_view_pager);
        searchEdit = (EditText) findViewById(R.id.app_search_edit);
        clearText = (ImageView) findViewById(R.id.app_search_clear);
        searchView = (ImageView) findViewById(R.id.app_search_search);
        clearText.setOnClickListener(this);
        searchView.setOnClickListener(this);
        Collections.addAll(tabTitles, titles);
        for (int i = 0; i < tabTitles.size(); i++) {

            if (i == tabTitles.size() - 1) {
                fragments.add(new WelfareFragment());
            }else {
                fragments.add(new RecommendFragment());
            }
        }
        if (adapter == null) {
            adapter = new AppSearchAdapter(getSupportFragmentManager(), tabTitles, fragments);
        }
        viewPager.setAdapter(adapter);
        tableLayout.setupWithViewPager(viewPager); //与ViewPager关联
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.app_search_clear:
                searchEdit.setText("");
                break;
            case R.id.app_search_search:
                Toast.makeText(this, "搜索", Toast.LENGTH_SHORT).show();
                break;
        }
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
