package com.example.system_3.bioauthentication;

import java.util.ArrayList;



import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class MyCustomBaseAdapter1 extends BaseAdapter {

    private static ArrayList<String[]> searchArrayList;
    private LayoutInflater mInflater;

    public MyCustomBaseAdapter1(Context context, ArrayList<String[]> results) {
        searchArrayList = results;
        mInflater = LayoutInflater.from(context);

    }
    public int getCount() {
        return searchArrayList.size();
    }
    public Object getItem(int position) {
        return searchArrayList.get(position);
    }
    public long getItemId(int position) {
        return position;
    }
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.list2, null);
            holder = new ViewHolder();
            holder.txtName = (TextView) convertView.findViewById(R.id.textView1);
            holder.txtCityState = (TextView) convertView
                    .findViewById(R.id.textView2);
            holder.txtPhone = (TextView) convertView.findViewById(R.id.textView3);

            holder.txtqty = (TextView) convertView.findViewById(R.id.TextView01);

            holder.txttime = (TextView) convertView.findViewById(R.id.TextView02);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        String []s=searchArrayList.get(position);
        holder.txtName.setText(s[0]);
        holder.txtCityState.setText(s[1]);
        holder.txtPhone.setText(s[4]);
        holder.txtqty.setText(s[3]);
        holder.txttime.setText(s[5]);
        return convertView;
    }
    static class ViewHolder {
        public TextView txttime;
        public TextView txtqty;
        TextView txtName;
        TextView txtCityState;
        TextView txtPhone;
    }
}



