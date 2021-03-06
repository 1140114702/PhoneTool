package com.phone.phonetool.view;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import com.bigkoo.convenientbanner.holder.Holder;
import com.phone.phonetool.util.ImgLoad;

/**
 * banner图片轮播
 * Created by zyb on 2017/3/7.
 */

public class BannerImg implements Holder<String> {

    private ImageView imageView;

    @Override
    public View createView(Context context) {
        imageView = new ImageView(context);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        return imageView;
    }

    @Override
    public void UpdateUI(Context context, int position, String data) {
        ImgLoad.loadImg(context, data,imageView);
    }
}
