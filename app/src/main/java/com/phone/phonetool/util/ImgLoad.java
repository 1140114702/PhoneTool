package com.phone.phonetool.util;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.phone.phonetool.R;

import jp.wasabeef.glide.transformations.BlurTransformation;

/**
 * Created by zyb on 2017/3/9.
 */

public class ImgLoad {

    public static void loadImg(Context context, String url, ImageView imageView){
        Glide.with(context)
                .load(url)
                .fitCenter()
                .placeholder(R.drawable.ic_yi_loading)
                .into(imageView);
    }

    public static void loadBlurTrans(Context context, String url, ImageView imageView){
        Glide.with(context).load(url)
                .bitmapTransform(new BlurTransformation(context))
                .into(imageView);
    }
}
