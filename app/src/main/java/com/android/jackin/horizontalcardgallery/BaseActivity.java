package com.android.jackin.horizontalcardgallery;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.Toast;

/**
 * Activity 基类
 * Created by LiuJQ on 2016/6/24.
 */
public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentViewRes());

        initView();
        initData();
    }

    protected abstract int getContentViewRes();
    protected abstract void initView();
    protected abstract void initData();

    protected void showMessage(String message) {
        if (!TextUtils.isEmpty(message)) {
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        }
    }

}
