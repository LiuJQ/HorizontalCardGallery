package com.android.jackin.horizontalcardgallery;

import java.util.List;

/**
 * Created by LiuJQ on 2016/6/24.
 */
public interface GalleryView {

    void showProgress();

    void hideProgress();

    void setItems(List<String> items);

    void showMessage(String message);

}
