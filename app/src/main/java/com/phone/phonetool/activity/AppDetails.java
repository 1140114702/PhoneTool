package com.phone.phonetool.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.phone.phonetool.BaseActivity;
import com.phone.phonetool.R;
import com.phone.phonetool.bean.AppDetailTagBean;
import com.phone.phonetool.util.ImgLoad;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zyb on 2017/3/7.
 */

public class AppDetails extends BaseActivity implements View.OnClickListener {

    private String[] imgUrls = {
            "http://f.hiphotos.bdimg.com/wisegame/pic/item/3ddf8db1cb1349541486c5d45f4e9258d0094ae1.jpg",
            "http://a.hiphotos.bdimg.com/wisegame/pic/item/da12c8fcc3cec3fdb4fa8ac5df88d43f869427bd.jpg",
            "http://g.hiphotos.bdimg.com/wisegame/pic/item/d0de9c82d158ccbf4a24988a10d8bc3eb03541e1.jpg",
            "http://e.hiphotos.bdimg.com/wisegame/pic/item/9f039245d688d43fcb58bc42741ed21b0ff43b88.jpg",
            "http://d.hiphotos.bdimg.com/wisegame/pic/item/b11b0ef41bd5ad6e8e3d495a88cb39dbb7fd3cbd.jpg"
    };
    private String[] tagText = {"官网：官网正版授权", "捆绑：没有捆绑恶意", "广告：内置广告", "插件：不需要", "资费：无扣费", "泄密：不存在", "赌博：不存在", "色情：不存在淫秽色情", "安全：通过“亿动安全中心”审核"};
    private List<String> imgList = new ArrayList<>();
    private RelativeLayout contentMore;
    private TextView content;
    private boolean isMore = false, tagIsMore;
    private ImageView moreImg;
    private ImageView tagMore;
    private LinearLayout appInfoLayout;
    private Toolbar toolbar;
    private LinearLayout imgLayout;
    private LinearLayout tagLayout;
    private int tagNumber;
    private Button download;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_details);
        initView();
    }

    private void initView() {
        contentMore = (RelativeLayout) findViewById(R.id.app_detail_more);
        content = (TextView) findViewById(R.id.app_detail_content);
        moreImg = (ImageView) findViewById(R.id.app_detail_more_img);
        tagMore = (ImageView) findViewById(R.id.app_detail_tag_more);
        appInfoLayout = (LinearLayout) findViewById(R.id.app_detail_info_layout);
        toolbar = (Toolbar) findViewById(R.id.app_detail_toolbar);
        imgLayout = (LinearLayout) findViewById(R.id.app_detail_img_layout);
        tagLayout = (LinearLayout) findViewById(R.id.app_detail_tag_layout);
        download = (Button) findViewById(R.id.app_detail_download);

        contentMore.setOnClickListener(this);
        content.setOnClickListener(this);
        download.setOnClickListener(this);
        findViewById(R.id.app_detail_tag_layout_more).setOnClickListener(this);

        toolbar.setTitle("亿生活");
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        ImgLoad.loadBlurTrans(this, "http://file.market.xiaomi.com/thumbnail/PNG/l114/AppStore/0b99955f32bea493d14c0f197197b32b5d2032e14", (ImageView) findViewById(R.id.app_detail_app_bg));
        ImgLoad.loadImg(this, "http://file.market.xiaomi.com/thumbnail/PNG/l114/AppStore/0b99955f32bea493d14c0f197197b32b5d2032e14", (ImageView) findViewById(R.id.app_detail_icon));

        List<AppDetailTagBean> tagList = new ArrayList<>();
        for (int i = 0; i < tagText.length; i++) {
            AppDetailTagBean bean = new AppDetailTagBean();
            if (i == 2) {
                bean.setPass(false);
            } else {
                bean.setPass(true);
            }
            bean.setTagText(tagText[i]);
            tagList.add(bean);
        }

        tagLayout.removeAllViews();
        for (int i = 0; i < tagList.size(); i++) {
            View view = LayoutInflater.from(this).inflate(R.layout.item_app_detail_tag, tagLayout, false);
            ImageView img = (ImageView) view.findViewById(R.id.item_app_detail_tag_img);
            TextView text = (TextView) view.findViewById(R.id.item_app_detail_tag_text);
            if (tagList.get(i).isPass()) {
                img.setImageResource(R.mipmap.ic_pass);
            } else {
                img.setImageResource(R.mipmap.ic_no_pass);
            }
            text.setText(tagList.get(i).getTagText());
            tagLayout.addView(view);
        }

        imgList = Arrays.asList(imgUrls);
        imgLayout.removeAllViews();
        for (int i = 0; i < imgList.size(); i++) {
            View view = LayoutInflater.from(this).inflate(R.layout.item_app_detail_img, imgLayout, false);
            view.setId(i);
            ImgLoad.loadImg(this, imgList.get(i), (ImageView) view.findViewById(R.id.item_app_detail_img));
            imgLayout.addView(view);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = v.getId();
                    Intent intent = new Intent(AppDetails.this, AppDetailImgs.class);
                    intent.putExtra("imgUrls",imgUrls);
                    intent.putExtra("position",position);
                    startActivity(intent);
                }
            });
        }

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

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

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
            case R.id.app_detail_download:
                Toast.makeText(this, "开始下载", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
