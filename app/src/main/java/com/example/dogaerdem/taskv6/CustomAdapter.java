package com.example.dogaerdem.taskv6;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter{
    private LayoutInflater inflater = null;
    private ArrayList <String> newList;
    private Context context;



    public CustomAdapter(Context context, ArrayList<String> newList ){
        this.newList = newList;
        this.context = context;
        inflater = ( LayoutInflater)
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    public void changeList(ArrayList<String> newList){
        this.newList = newList;
    }


    @Override
    public int getCount() {
        return newList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null ) {
            convertView = inflater.inflate(R.layout.listview_row, null);
            Holder viewHolder = new Holder();
            viewHolder.tv = (TextView)convertView.findViewById(R.id.textView);
            convertView.setTag(viewHolder);
        }
        Holder newHolder = (Holder)convertView.getTag();
        newHolder.tv.setText(newList.get(position));



        return convertView;
    }
    public class Holder
    {
        TextView tv;
    }
}
