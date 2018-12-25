package com.weather.geo.geo_weather;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;


public class WeatherlistAdaptor extends RecyclerView.Adapter<WeatherlistAdaptor.ViewHolder> {
    Context context;
    ArrayList<String> dayList = new ArrayList<>();
    ArrayList<String> tempList = new ArrayList<>();
    Map<String, TreeMap<String,String>> timeTempMapping = new TreeMap<>();
    private TimeTempListAdaptor mAdapter;

    public WeatherlistAdaptor(Context context, ArrayList<String> dayList,
                              ArrayList<String>tempList,Map<String,TreeMap<String,String>> timeTempMapping ) {

        this.dayList = dayList;
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


//        for(int i=0;i<timeList.length;i++){
//            if(i==0){
//                viewHolder.tv_Time1.setText(timeList[0].toString());
//                viewHolder.tv_Temp1.setText(tempList[0].toString());
//            }else if(i==1){
//                viewHolder.tv_Time2.setText(timeList[1].toString());
//                viewHolder.tv_Temp2.setText(tempList[1].toString());
//            }else if(i==2){
//                viewHolder.tv_Time3.setText(timeList[2].toString());
//                viewHolder.tv_Temp3.setText(tempList[2].toString());
//            }else if(i==3){
//                viewHolder.tv_Time4.setText(timeList[3].toString());
//                viewHolder.tv_Temp4.setText(tempList[3].toString());
//            }else if(i==4){
//                viewHolder.tv_Time5.setText(timeList[4].toString());
//                viewHolder.tv_Temp5.setText(tempList[4].toString());
//            }else if(i==5){
//                viewHolder.tv_Time6.setText(timeList[5].toString());
//                viewHolder.tv_Temp6.setText(tempList[5].toString());
//            }else if(i==6){
//                viewHolder.tv_Time7.setText(timeList[6].toString());
//                viewHolder.tv_Temp7.setText(tempList[6].toString());
//            }else if(i==7){
//                viewHolder.tv_Time8.setText(timeList[7].toString());
//                viewHolder.tv_Temp8.setText(tempList[7].toString());
//            }
//        }

    }

    @Override
    public int getItemCount() {
        return tempList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tv_Day;
        TextView tv_Temp;
        TextView tv_Time1,tv_Time2,tv_Time3,tv_Time4,tv_Time5,tv_Time6,tv_Time7,tv_Time8;
        TextView tv_Temp1,tv_Temp2,tv_Temp3,tv_Temp4,tv_Temp5,tv_Temp6,tv_Temp7,tv_Temp8;
        RecyclerView rcv_Weather;


        public ViewHolder(View view) {
            super(view);
            tv_Day = view.findViewById(R.id.tv_day);
            tv_Temp = view.findViewById(R.id.tv_temp);
            tv_Temp1 = view.findViewById(R.id.tv_Temp1);
            tv_Temp2 = view.findViewById(R.id.tv_Temp2);
            tv_Temp3 = view.findViewById(R.id.tv_Temp3);
            tv_Temp4 = view.findViewById(R.id.tv_Temp4);
            tv_Temp5 = view.findViewById(R.id.tv_Temp5);
            tv_Temp6 = view.findViewById(R.id.tv_Temp6);
            tv_Temp7 = view.findViewById(R.id.tv_Temp7);
            tv_Temp8 = view.findViewById(R.id.tv_Temp8);
            tv_Time1 = view.findViewById(R.id.tv_Time1);
            tv_Time2 = view.findViewById(R.id.tv_Time2);
            tv_Time3 = view.findViewById(R.id.tv_Time3);
            tv_Time4 = view.findViewById(R.id.tv_Time4);
            tv_Time5 = view.findViewById(R.id.tv_Time5);
            tv_Time6 = view.findViewById(R.id.tv_Time6);
            tv_Time7 = view.findViewById(R.id.tv_Time7);
            tv_Time8 = view.findViewById(R.id.tv_Time8);
            rcv_Weather = view.findViewById(R.id.rcv_WeatherCast);
            LinearLayoutManager horizontalLayoutManager = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
            rcv_Weather.setLayoutManager(horizontalLayoutManager);

            view.setTag(itemView);

        }

    }

}
