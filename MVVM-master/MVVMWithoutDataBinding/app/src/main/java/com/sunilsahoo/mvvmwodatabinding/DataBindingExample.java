package com.sunilsahoo.mvvmwodatabinding;

import android.app.Activity;
import android.databinding.Observable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

import com.sunilsahoo.mvvmwodatabinding.databinding.MainListBinding;

import java.util.ArrayList;

/**
 * Created by sunilkumarsahoo on 9/4/16.
 */
public class DataBindingExample extends Activity {
    private static final String TAG = DataBindingExample.class.getName();
    ListView listView;
    ItemAdapter itemAdapter;
    MainListBinding mainListBinding;
    ListViewViewModel lv;
    EditText nameET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = LayoutInflater.from(this).inflate(R.layout.main_list, null);
        setContentView(view);

        nameET = (EditText) findViewById(R.id.nameET);
        //TODO these three lines are most important
        lv = new ListViewViewModel();
        mainListBinding = MainListBinding.bind(view);
        mainListBinding.setData(lv);

        lv.itemList = new ArrayList<>();
        for (int i = 1; i < 100; i++) {
            Item item = new Item();
            item.setName("Item : " + (100 - i));
            lv.itemList.add(item);
        }
        Log.d(TAG, "list will be attached");
        listView = (ListView) findViewById(R.id.listView);
        itemAdapter = new ItemAdapter(this, lv.itemList);
        listView.setAdapter(itemAdapter);
        listView.setNestedScrollingEnabled(true);
        /*listView.setOnTouchListener(new View.OnTouchListener() {
            // Setting on Touch Listener for handling the touch inside
            // ScrollView

            @Override
            public boolean onTouch(View v, MotionEvent event) {
// Disallow the touch request for parent scroll on touch of child view
                v.getParent().requestDisallowInterceptTouchEvent(true);
                return false;
            }
        });*/
        lv.user.userName.addOnPropertyChangedCallback(new Observable
                .OnPropertyChangedCallback() {
            @Override
            public void onPropertyChanged(Observable observable, int i) {
                Log.d(TAG, i + " onPropertyChanged : " + observable.toString());
                updateList();
            }
        });
    }

    public void onOkClicked(View view) {
//        updateList();
        lv.user.userName.set(nameET.getText().toString());
    }

    private void updateList() {
        lv.itemList.clear();
        for (int i = 1; i < 100; i++) {
            Item item = new Item();
            item.setName(nameET.getText().toString() + (100 - i));
            lv.itemList.add(item);
        }
        itemAdapter.notifyDataSetChanged();
    }
}
