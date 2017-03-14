package com.phone.phonetool.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.phone.phonetool.R;

public class MainActivity extends AppCompatActivity {

    private PopupWindow popupWindow,popupWindow1;
    private TextView popfalse;
    private TextView poptrue;
    private View popView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        popfalse = (TextView) findViewById(R.id.pop_false);
        poptrue = (TextView) findViewById(R.id.pop_true);
        popView = LayoutInflater.from(this).inflate(R.layout.popup_test,null);
    }

    public void into(View view) {
        Intent intent = new Intent(this, AppSearch.class);
        startActivity(intent);
    }

    //没有焦点的popupwindow
    public void popupFalse(View view) {
        if (popupWindow == null) {
            popupWindow = new PopupWindow(popView, LinearLayoutCompat.LayoutParams.WRAP_CONTENT,LinearLayoutCompat.LayoutParams.WRAP_CONTENT);
        }
        popupWindow.setOutsideTouchable(true);
        popupWindow.showAsDropDown(popfalse);
    }

    //有焦点的popupwindow
    public void popupTrue(View view) {
        if (popupWindow1 == null) {
            popupWindow1 = new PopupWindow(popView, LinearLayoutCompat.LayoutParams.WRAP_CONTENT,LinearLayoutCompat.LayoutParams.WRAP_CONTENT);
        }
        popupWindow1.setFocusable(true);
        popupWindow1.showAsDropDown(poptrue);
    }

}
