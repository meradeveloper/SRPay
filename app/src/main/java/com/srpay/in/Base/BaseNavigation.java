package com.srpay.in.Base;

/**
 * Created by Localadmin on 10/9/2018.
 */

public interface BaseNavigation {
    void onNext(Class C);
    void onPrevious(Class C);

    enum NavigationMode {

        NEXT(0),
        PREV(1);

        private final int mType;

        NavigationMode(int type) {
            mType = type;
        }

        public int getNavigationType() {
            return mType;
        }
    }
}
