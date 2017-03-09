package com.phone.phonetool.activity;

import android.os.Bundle;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.bigkoo.convenientbanner.listener.OnItemClickListener;
import com.phone.phonetool.BaseActivity;
import com.phone.phonetool.R;
import com.phone.phonetool.view.BannerImg;

import java.util.Arrays;
import java.util.List;

public class AppDetailImgs extends BaseActivity {

    private ConvenientBanner banner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_detadil_imgs);
        String[] imgUrl = getIntent().getStringArrayExtra("imgUrls");
        int position = getIntent().getIntExtra("position", 0);
        List<String> imgList = Arrays.asList(imgUrl);
        banner = (ConvenientBanner) findViewById(R.id.app_detail_banner_imgs);
        banner.setPages(new CBViewHolderCreator<BannerImg>() {
            @Override
            public BannerImg createHolder() {
                return new BannerImg();
            }
        }, imgList)
                .setPageIndicator(new int[]{R.mipmap.ic_banner_no_select,R.mipmap.ic_banner_select})
                .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.CENTER_HORIZONTAL);
        banner.setcurrentitem(position);
        banner.setCanLoop(false); //禁止循环
        banner.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                finish();
            }
        });
    }

}
