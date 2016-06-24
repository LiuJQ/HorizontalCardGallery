package com.android.jackin.horizontalcardgallery;

import java.util.List;

/**
 * Created by LiuJQ on 2016/6/24.
 */
public class GalleryPresenterImpl implements GalleryPresenter, LoadItemsInteractor.OnLoadListener {

    private GalleryView mGalleryView;
    private LoadItemsInteractor mLoadItemsInteractor;

    public GalleryPresenterImpl(GalleryView mGalleryView) {
        this.mGalleryView = mGalleryView;
        this.mLoadItemsInteractor = new LoadItemsInteractorImpl();
    }

    @Override
    public void onResume() {
        mLoadItemsInteractor.loadItems(this);
    }

    @Override
    public void onDestroy() {
        mGalleryView = null;
    }

    @Override
    public void onStart() {
        if (mGalleryView != null) {
            mGalleryView.showProgress();
        }
    }

    @Override
    public void onFail(String message) {
        if (mGalleryView != null) {
            mGalleryView.hideProgress();
            mGalleryView.showMessage(message);
        }
    }

    @Override
    public void onSuccess(List<String> items) {
        if (mGalleryView != null) {
            mGalleryView.hideProgress();
            mGalleryView.setItems(items);
        }
    }

}
