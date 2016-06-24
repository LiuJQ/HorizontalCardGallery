package com.android.jackin.horizontalcardgallery;

import java.util.List;

/**
 * Created by LiuJQ on 2016/6/24.
 */
public interface LoadItemsInteractor {

    interface OnLoadListener {
        void onStart();
        void onFail(String message);
        void onSuccess(List<String> items);
    }

    void loadItems(OnLoadListener listener);

}
