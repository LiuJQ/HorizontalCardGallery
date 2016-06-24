package com.android.jackin.horizontalcardgallery;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.List;

public class GalleryActivity extends BaseActivity implements GalleryView {

    private RecyclerView mRecyclerView;
    private ProgressBar mLoadingView;

    private GalleryAdapter mGalleryAdapter;
    private GalleryPresenter mGalleryPresenter;

    @Override
    protected int getContentViewRes() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mLoadingView = (ProgressBar) findViewById(R.id.loading_view);

        mGalleryAdapter = new GalleryAdapter(this, null);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        mRecyclerView.setAdapter(mGalleryAdapter);
    }

    @Override
    protected void initData() {
        mGalleryPresenter = new GalleryPresenterImpl(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mGalleryPresenter.onResume();
    }

    @Override
    protected void onDestroy() {
        mGalleryPresenter.onDestroy();
        super.onDestroy();
    }

    @Override
    public void showProgress() {
        mRecyclerView.setVisibility(View.GONE);
        mLoadingView.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        mRecyclerView.setVisibility(View.VISIBLE);
        mLoadingView.setVisibility(View.GONE);
    }

    @Override
    public void setItems(List<String> items) {
        mGalleryAdapter.setData(items);
    }

    @Override
    public void showMessage(String message) {
        super.showMessage(message);
    }

}
