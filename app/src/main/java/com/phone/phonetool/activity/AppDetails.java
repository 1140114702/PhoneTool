package com.phone.phonetool.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.phone.phonetool.BaseActivity;
import com.phone.phonetool.R;

/**
 * Created by zyb on 2017/3/7.
 */

public class AppDetails extends BaseActivity implements View.OnClickListener {

//    private ConvenientBanner banner;
//    private String[] imgUrls = {
//            "http://file.market.xiaomi.com/thumbnail/jpeg/l395/AppStore/0ff33c45a8834452120ab3aa6237938e142b1f20d",
//            "http://file.market.xiaomi.com/thumbnail/jpeg/l395/AppStore/04be22493e3b546dc1f387ba9668caf318c680043",
//            "http://file.market.xiaomi.com/thumbnail/jpeg/l395/AppStore/03be24893b3c5c6d63f388ba9708c8f013e4146a2",
//            "http://file.market.xiaomi.com/thumbnail/jpeg/l395/AppStore/03be24893b3c5d6d6ff387ba9808cdf011e4146a2"
//    };
//    private List<String> imgList = new ArrayList<>();
    private RelativeLayout contentMore;
    private TextView content;
    private boolean isMore = false, tagIsMore;
    private ImageView moreImg;
    private ImageView tagMore;
    private LinearLayout appInfoLayout;
    private ImageView appIcon;
    private Toolbar toolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_details);
        initView();
    }

    private void initView() {
//        banner = (ConvenientBanner) findViewById(R.id.app_detail_banner);
        contentMore = (RelativeLayout) findViewById(R.id.app_detail_more);
        content = (TextView) findViewById(R.id.app_detail_content);
        moreImg = (ImageView) findViewById(R.id.app_detail_more_img);
        tagMore = (ImageView) findViewById(R.id.app_detail_tag_more);
        appInfoLayout = (LinearLayout) findViewById(R.id.app_detail_info_layout);
        appIcon = (ImageView) findViewById(R.id.app_detail_icon);
        toolbar = (Toolbar) findViewById(R.id.app_detail_toolbar);

        contentMore.setOnClickListener(this);
        content.setOnClickListener(this);
        findViewById(R.id.app_detail_tag_layout_more).setOnClickListener(this);

        toolbar.setTitle("QQ");
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
//        toolbar.setNavigationIcon(getResources().getDrawable(R.mipmap.ic_menu));
//        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                finish();
//            }
//        });

        //判断简介的行数进行一些操作
        content.post(new Runnable() {
            @Override
            public void run() {
                if (content.getLineCount() > 3) {
                    content.setMaxLines(3);
                    contentMore.setVisibility(View.VISIBLE);
                    content.setClickable(true);
                } else {
                    content.setClickable(false);
                    contentMore.setVisibility(View.GONE);
                }
            }
        });

//        imgList = Arrays.asList(imgUrls);
//        banner.setPages(new CBViewHolderCreator<BannerImg>() {
//            @Override
//            public BannerImg createHolder() {
//                return new BannerImg();
//            }
//        }, imgList)
//                .setPageIndicator(new int[]{R.mipmap.ic_banner_no_select, R.mipmap.ic_banner_select})
//                .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.CENTER_HORIZONTAL);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    //    @Override
//    protected void onResume() {
//        super.onResume();
//        //自动轮播
//        banner.startTurning(3000);
//    }

//    @Override
//    protected void onPause() {
//        super.onPause();
//        banner.stopTurning();
//    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.app_detail_content:
            case R.id.app_detail_more:
                if (!isMore) {
                    isMore = true;
                    content.setMaxLines(Integer.MAX_VALUE);
                    moreImg.setImageResource(R.mipmap.ic_less_up);
                } else {
                    isMore = false;
                    content.setMaxLines(3);
                    moreImg.setImageResource(R.mipmap.ic_more_down);
                }
                break;
            case R.id.app_detail_tag_layout_more:
                if (!tagIsMore) {
                    tagIsMore = true;
                    findViewById(R.id.app_detail_tag_layout).setVisibility(View.VISIBLE);
                    tagMore.setImageResource(R.mipmap.ic_up);
                } else {
                    tagIsMore = false;
                    findViewById(R.id.app_detail_tag_layout).setVisibility(View.GONE);
                    tagMore.setImageResource(R.mipmap.ic_down);
                }
                break;
        }
    }
}
