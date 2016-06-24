package com.android.jackin.horizontalcardgallery;

import android.os.Handler;

import java.util.Arrays;
import java.util.List;

/**
 * Created by LiuJQ on 2016/6/24.
 */
public class LoadItemsInteractorImpl implements LoadItemsInteractor {

    @Override
    public void loadItems(final OnLoadListener listener) {
        listener.onStart();
        new Handler().postDelayed(new Runnable() {
            @Override public void run() {
                List<String> results = createArrayList();
                if (results != null) {
                    listener.onSuccess(results);
                } else {
                    listener.onFail("数据加载失败");
                }
            }
        }, 2000);
    }

    private List<String> createArrayList() {
        return Arrays.asList(
                "Item 1",
                "Item 2",
                "Item 3",
                "Item 4",
                "Item 5",
                "Item 6",
                "Item 7",
                "Item 8",
                "Item 9",
                "Item 10"
        );
    }

}
