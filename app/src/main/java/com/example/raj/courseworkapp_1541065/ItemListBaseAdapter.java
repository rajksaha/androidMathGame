package com.example.raj.courseworkapp_1541065;

/**
 * Created by raj on 5/11/2016.
 */


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ItemListBaseAdapter extends BaseAdapter {

    private static ArrayList<ItemData> itemDetailsrrayList;



    private LayoutInflater l_Inflater;

    public ItemListBaseAdapter(Context context, ArrayList<ItemData> results) {
        itemDetailsrrayList = results;
        l_Inflater = LayoutInflater.from(context);
    }

    public int getCount() {
        return itemDetailsrrayList.size();
    }

    public Object getItem(int position) {
        return itemDetailsrrayList.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = l_Inflater.inflate(R.layout.level_list, null);
            holder = new ViewHolder();
            holder.txt_itemName = (TextView) convertView.findViewById(R.id.levelName);
            holder.txt_itemNo = (TextView) convertView.findViewById(R.id.itemNum);
            holder.txt_itemNo.setVisibility(View.INVISIBLE);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.txt_itemName.setText(itemDetailsrrayList.get(position).getLevelName());
        holder.txt_itemNo.setText(String.valueOf(itemDetailsrrayList.get(position).getLevelNo()));

        return convertView;
    }

    static class ViewHolder {
        TextView txt_itemName;
        TextView txt_itemNo;
    }
}

