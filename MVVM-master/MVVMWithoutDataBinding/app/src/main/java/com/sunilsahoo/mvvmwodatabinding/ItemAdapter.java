package com.sunilsahoo.mvvmwodatabinding;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.sunilsahoo.mvvmwodatabinding.databinding.ItemRowBinding;

import java.util.List;

/**
 * Created by sunilkumarsahoo on 9/4/16.
 */
public class ItemAdapter extends BaseAdapter{
    private static final String TAG = ItemAdapter.class.getName();
    List<Item> itemList;
    Context context;
    ItemAdapter(Context context, List<Item> itemList){
        this.context = context;
        this.itemList = itemList;
    }
    @Override
    public int getCount() {
        return itemList.size();
    }

    @Override
    public Item getItem(int position) {
        return itemList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ItemRowBinding rowBinding =
                DataBindingUtil.getBinding(convertView);

        Log.d(TAG, position+" rowbinding : "+rowBinding);
        if (rowBinding==null) {
            rowBinding =
                    ItemRowBinding.bind(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row, parent, false));
        }
        Item item=getItem(position);
        rowBinding.setItem(item);

        return(rowBinding.getRoot());
    }
    
}
