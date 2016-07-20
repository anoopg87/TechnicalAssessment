package com.android.app.technicalassesment.view.adapters;

import android.widget.BaseAdapter;



        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
import android.widget.TextView;


import com.android.app.technicalassesment.R;
import com.android.app.technicalassesment.model.LocationInfo;

import java.util.List;

// Spinner custom adapter for listing location names
public class SpinnerAdapter extends BaseAdapter {
    List<LocationInfo> mDataSet;
    View mView;

    // constructor with dataset
    public SpinnerAdapter(List<LocationInfo> dataSet) {
        mDataSet=dataSet;
    }

    @Override
    public int getCount() {
        return null!=mDataSet?mDataSet.size():0;
    }

    @Override
    public Object getItem(int position) {
        return mDataSet.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        mView=convertView;
        viewHolder vh=null;
        if(null==mView){
            vh=new viewHolder();
            mView= LayoutInflater.from(parent.getContext()).inflate(R.layout.data_row,parent,false);
            vh.textView=((TextView)mView.findViewById(R.id.textView));
            mView.setTag(vh);
        }else {
            vh= (viewHolder) mView.getTag();
        }
        vh.textView.setText(mDataSet.get(position).getName());

        return mView;
    }

    public  class viewHolder{
        TextView textView;
    }
}