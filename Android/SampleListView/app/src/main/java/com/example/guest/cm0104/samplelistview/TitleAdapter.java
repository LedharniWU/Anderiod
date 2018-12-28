package com.example.guest.cm0104.samplelistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by guest on 2018/11/29.
 */

class TitleAdapter extends BaseAdapter {

    private LayoutInflater inflater;
    private int resourcedId;
    private ArrayList<String> items;

    static class ViewHolder {
        Button editButton;
        TextView textView;
        Button deleteButton;
    }

    TitleAdapter(Context context, int resourcedId, ArrayList<String> items) {
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.resourcedId = resourcedId;
        this.items = items;
    }

    @Override
    public View getView(final int position, View convertView, final ViewGroup parent) {
        ViewHolder holder;

        if(convertView == null){

            convertView = inflater.inflate(resourcedId,parent,false );
            holder = new ViewHolder();
            holder.editButton = (Button)convertView.findViewById(R.id.btnEDIT);
            holder.textView = (TextView)convertView.findViewById(R.id.title);
            holder.deleteButton = (Button)convertView.findViewById(R.id.btnDelete);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.textView.setText(items.get(position));

        holder.editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((ListView) parent).performItemClick(view, position, R.id.btnEDIT);
            }
        });
        holder.deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((ListView) parent).performItemClick(view, position, R.id.btnDelete);
            }
        });

        return convertView;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

}