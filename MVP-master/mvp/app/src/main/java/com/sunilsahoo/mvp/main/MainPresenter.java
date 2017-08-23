package com.sunilsahoo.mvp.main;

public interface MainPresenter {

    void onResume();

    void onItemClicked(int position);

    void onDestroy();
}
