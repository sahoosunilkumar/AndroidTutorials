package com.sunilsahoo.mvvm.ViewModel;

import com.sunilsahoo.mvvm.Model.OnModelModifiedListener;

/**
 * Created by sunilkumarsahoo on 9/3/16.
 */
abstract public class BaseViewModel implements OnModelModifiedListener {
    OnViewModifiedListener onViewModifiedListener;

    BaseViewModel(OnViewModifiedListener onViewModifiedListener) {
        this.onViewModifiedListener = onViewModifiedListener;
    }

    @Override
    public void onModelModified() {
        if (onViewModifiedListener != null) {
            onViewModifiedListener.onViewModified(false);
        }
    }
}
