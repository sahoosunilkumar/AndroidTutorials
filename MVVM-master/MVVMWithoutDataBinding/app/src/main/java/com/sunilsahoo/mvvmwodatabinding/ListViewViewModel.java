package com.sunilsahoo.mvvmwodatabinding;

import java.util.List;

/**
 * Created by sunilkumarsahoo on 9/4/16.
 */
public class ListViewViewModel {
    private String title = "Item List";
    public User user = new User();
    public List<Item> itemList;

    public String getTitle() {
        return title;
    }
}
