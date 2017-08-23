package com.sunilsahoo.mvvm.Model;

/**
 * Created by sunilkumarsahoo on 9/3/16.
 */
abstract public class BaseModel {
    OnModelModifiedListener modelModifiedListener;

    public void register(OnModelModifiedListener modelModifiedListener) {
        this.modelModifiedListener = modelModifiedListener;
    }

    protected void notifyModelChange() {
        if (modelModifiedListener != null) {
            modelModifiedListener.onModelModified();
        }
    }

}
