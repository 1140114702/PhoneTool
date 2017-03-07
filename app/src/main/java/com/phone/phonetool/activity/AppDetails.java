package com.phone.phonetool.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.bigkoo.convenientbanner.listener.OnItemClickListener;
import com.phone.phonetool.BaseActivity;
import com.phone.phonetool.R;
import com.phone.phonetool.view.BannerImg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zyb on 2017/3/7.
 */

public class AppDetails extends BaseActivity implements OnItemClickListener {

    private ConvenientBanner banner;
    private String[] imgUrls = {
            "http://file.market.xiaomi.com/thumbnail/jpeg/l395/AppStore/0ff33c45a8834452120ab3aa6237938e142b1f20d",
            "http://file.market.xiaomi.com/thumbnail/jpeg/l395/AppStore/04be22493e3b546dc1f387ba9668caf318c680043",
            "http://file.market.xiaomi.com/thumbnail/jpeg/l395/AppStore/03be24893b3c5c6d63f388ba9708c8f013e4146a2",
            "http://file.market.xiaomi.com/thumbnail/jpeg/l395/AppStore/03be24893b3c5d6d6ff387ba9808cdf011e4146a2"
    };
    private List<String> imgList = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_details);
        initView();
    }

    private void initView() {
        banner = (ConvenientBanner) findViewById(R.id.app_detail_banner);

        imgList = Arrays.asList(imgUrls);
        banner.setPages(new CBViewHolderCreator<BannerImg>() {
            @Override
            public BannerImg createHolder() {
                return new BannerImg();
            }
        }, imgList)
                .setPageIndicator(new int[]{R.mipmap.ic_banner_no_select, R.mipmap.ic_banner_select})
                .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.CENTER_HORIZONTAL);
    }

    @Override
    protected void onResume() {
        super.onResume();
        //自动轮播
        banner.startTurning(3000);
    }

    @Override
    protected void onPause() {
        super.onPause();
        banner.stopTurning();
    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(this, AppDetailImgs.class);
        intent.putExtra("imgList", imgUrls);
        intent.putExtra("position", banner.getCurrentItem());
        startActivity(intent);
    }
}
