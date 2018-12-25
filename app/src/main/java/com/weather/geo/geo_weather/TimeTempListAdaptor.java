package com.weather.geo.geo_weather;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class TimeTempListAdaptor extends RecyclerView.Adapter<TimeTempListAdaptor.ViewHolder> {
    Context context;
    ArrayList<String> dayList = new ArrayList<>();
    ArrayList<String> tempList = new ArrayList<>();

    public TimeTempListAdaptor(Context context, ArrayList<String> dayList,
                               ArrayList<String> tempList) {

        this.dayList = dayList;
        this.tempList = tempList;
        this.context = context;

    }

    @Override
    public TimeTempListAdaptor.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.time_temp_list_row, viewGroup,
                false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, final int position) {


        viewHolder.tv_Day.setText(dayList.get(position).toString());
        viewHolder.tv_Temp.setText(tempList.get(position).toString());

    }

    @Override
    public int getItemCount() {
        return dayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tv_Day;
        TextView tv_Temp;


        public ViewHolder(View view) {
            super(view);
            tv_Day = view.findViewById(R.id.tv_day);
            tv_Temp = view.findViewById(R.id.tv_temp);

            view.setTag(itemView);

        }

    }
}


