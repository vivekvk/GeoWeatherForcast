package com.weather.geo.geo_weather.adaptors;
/*
 *Created Vivek
 */

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.weather.geo.geo_weather.R;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;


public class WeatherlistAdaptor extends RecyclerView.Adapter<WeatherlistAdaptor.ViewHolder> {
    Context context;
    ArrayList<String> tempList = new ArrayList<>();
    Map<String, TreeMap<String,String>> timeTempMapping = new TreeMap<>();
    private TimeTempListAdaptor mAdapter;

    public WeatherlistAdaptor(Context context,
                              ArrayList<String>tempList,Map<String,TreeMap<String,String>> timeTempMapping ) {

        this.tempList = tempList;
        this.timeTempMapping = timeTempMapping;
        this.context = context;

    }

    @Override
    public WeatherlistAdaptor.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycle_list_row, viewGroup,
                false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, final int position) {


        Object[] keys = timeTempMapping.keySet().toArray();

        String key = keys[position].toString();

        viewHolder.tv_Day.setText(key);
        viewHolder.tv_Temp.setText(tempList.get(position));

        Map<String,String>dayTimeTempMap = new TreeMap<>();
        dayTimeTempMap.putAll(timeTempMapping.get(key));

        Object[] timeList = dayTimeTempMap.keySet().toArray();
        Object[] tempList = dayTimeTempMap.values().toArray();

        ArrayList<String> timeListArray = new ArrayList<>();
        for (Object object : timeList) {
            timeListArray.add(object != null ? object.toString() : null);
        }
        ArrayList<String> tempListArray = new ArrayList<>();
        for (Object object : tempList) {
            tempListArray.add(object != null ? object.toString() : null);
        }

        mAdapter = new TimeTempListAdaptor(context,timeListArray,tempListArray);
        viewHolder.rcv_Weather.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return timeTempMapping.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tv_Day;
        TextView tv_Temp;
        RecyclerView rcv_Weather;


        public ViewHolder(View view) {
            super(view);
            tv_Day = view.findViewById(R.id.tv_day);
            tv_Temp = view.findViewById(R.id.tv_temp);
            rcv_Weather = view.findViewById(R.id.rcv_WeatherCast);
            LinearLayoutManager horizontalLayoutManager = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
            rcv_Weather.setLayoutManager(horizontalLayoutManager);

            view.setTag(itemView);

        }

    }

}
