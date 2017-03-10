package com.phone.phonetool.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ExpandableListView;

/**
 * Created by zyb on 2017/3/10.
 */

public class MyExpandListView extends ExpandableListView {

    public MyExpandListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    //使得自适应scrollview高度
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,
                MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }
}
