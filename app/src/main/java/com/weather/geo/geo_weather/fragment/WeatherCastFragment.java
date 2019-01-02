package com.weather.geo.geo_weather.fragment;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.weather.geo.geo_weather.APIClient;
import com.weather.geo.geo_weather.APIInterface;
import com.weather.geo.geo_weather.R;
import com.weather.geo.geo_weather.adaptors.WeatherlistAdaptor;
import com.weather.geo.geo_weather.model.ForcastModel;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.support.v7.widget.RecyclerView.HORIZONTAL;

/**
 * Created by Vivek Chandran
 */
public class WeatherCastFragment extends Fragment {
    /*Bangalore location hard coded, not integrated map */
    String location = "Bangalore";
    ProgressBar progressBar;
    TextView tv_CurrentTemp, tv_CurrentLocation;
    RecyclerView rcv_Weather;
    private WeatherlistAdaptor mAdapter;
    private ArrayList<String> dayList = new ArrayList<>();
    private ArrayList<String> tempList = new ArrayList<>();
    Map<String, TreeMap<String,String>> timeTempMapping = new TreeMap<>();
    APIInterface apiService;


    public WeatherCastFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View layout = inflater.inflate(R.layout.fragment_weather_cast, container, false);
        return layout;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        apiService = APIClient.getClient().create(APIInterface.class);

        progressBar = view.findViewById(R.id.progress_bar);
        tv_CurrentTemp = view.findViewById(R.id.tv_CurrentTemp);
        tv_CurrentLocation = view.findViewById(R.id.tv_location);
        rcv_Weather = view.findViewById(R.id.rcv_WeatherCast);
        Typeface roboto = Typeface.createFromAsset(getActivity().getAssets(),
                "fonts" + "/Roboto-Black.ttf");
        tv_CurrentTemp.setTypeface(roboto);

        Typeface roboto_thin = Typeface.createFromAsset(getActivity().getAssets(),
                "fonts" + "/Roboto-Thin.ttf");
        tv_CurrentLocation.setTypeface(roboto_thin);

        getCurrentWeather(location);

        mAdapter = new WeatherlistAdaptor(getContext(),tempList,timeTempMapping);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        rcv_Weather.setLayoutManager(mLayoutManager);
        rcv_Weather.setItemAnimator(new DefaultItemAnimator());
        DividerItemDecoration itemDecor = new DividerItemDecoration(getContext(), HORIZONTAL);
        rcv_Weather.addItemDecoration(itemDecor);
        rcv_Weather.setAdapter(mAdapter);
    }

    private void getCurrentWeather(String location) {

        progressBar.setVisibility(View.VISIBLE);

        Call<ForcastModel> call = apiService.getWeatherForcast(location);
        call.enqueue(new Callback<ForcastModel>() {
            @Override
            public void onResponse(Call<ForcastModel> call, Response<ForcastModel> response) {

                if (response.code() == 200) {

                    tv_CurrentLocation.setText(response.body().getCity().getName());
                    String currentTemp = getTemperatureInCelcious(response.body().getList().get(1).getMain().getTemp());
                    tv_CurrentTemp.setText(currentTemp + (char) 0x00B0 + "C");



                    TreeMap<String,String>dayTimeTempMap = new TreeMap<>();
                    for (int i = 0; i < response.body().getList().size(); i++) {
                        String dateTime = response.body().getList().get(i).getDtTxt();
                        String formatedDateTime = formatDate(dateTime);
                        dayList.add(formatedDateTime);

                        Double temperature = response.body().getList().get(i).getMain().getTemp();
                        String temperatureInCelcious = getTemperatureInCelcious(temperature);

                        tempList.add(temperatureInCelcious + (char) 0x00B0 + "C");

                        if(dayList.size()>1) {
                            if (dayList.get(i - 1).equalsIgnoreCase(formatedDateTime)) {
                                dayTimeTempMap.put(formatTime(dateTime),temperatureInCelcious + (char) 0x00B0 + "C");
                                timeTempMapping.put(formatedDateTime, dayTimeTempMap);
                            }
                            else {
                                dayTimeTempMap = new TreeMap<>();
                                dayTimeTempMap.put(formatTime(dateTime),temperatureInCelcious + (char) 0x00B0 + "C");
                                timeTempMapping.put(formatedDateTime, dayTimeTempMap);
                                tempList.clear();
                            }
                        }
                        mAdapter.notifyDataSetChanged();
                    }
                    progressBar.setVisibility(View.GONE);

                } else {
                    progressBar.setVisibility(View.GONE);
                    FragmentTransaction tx = getActivity().getSupportFragmentManager()
                            .beginTransaction();
                    tx.replace(R.id.frame_container, new RetryAlertFragment());
                    tx.commit();
                }
            }

            @Override
            public void onFailure(Call<ForcastModel> call, Throwable t) {

            }
        });

    }

    private String getTemperatureInCelcious(Double temperature) {
        Double temperatureInCelcious = temperature - 273.15;
        String formatedValue = new DecimalFormat("##.#").format(temperatureInCelcious);
        return formatedValue;
    }

    private String formatDate(String date) {

        String day = "";

        String pattern = "yyyy-MM-dd ";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

        try {
            Date formatDate = simpleDateFormat.parse(date);
            Calendar ca = Calendar.getInstance();
            ca.setTime(formatDate);

            String formattedDate = simpleDateFormat.format(formatDate);

            day = formattedDate+" "+ getDayOfWeek(ca.get(Calendar.DAY_OF_WEEK));

        } catch (ParseException e) {
            e.printStackTrace();
        }

        return day;
    }
    private String formatTime(String date) {

        String formatedTime = "";

        String pattern = "yyyy-MM-dd hh:mm:ss";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

        try {
            Date formatDate = simpleDateFormat.parse(date);
            Calendar ca = Calendar.getInstance();
            ca.setTime(formatDate);

            Date dateTime =ca. getTime();
            DateFormat dateFormat = new SimpleDateFormat("ha");
            formatedTime =dateFormat. format(dateTime);


        } catch (ParseException e) {
            e.printStackTrace();
        }

        return formatedTime;
    }

    private String getDayOfWeek(int value) {

        String day = "";

        switch (value) {
            case 1:
                day = "Sunday";
                break;
            case 2:
                day = "Monday";
                break;
            case 3:
                day = "Tuesday";
                break;
            case 4:
                day = "Wednesday";
                break;
            case 5:
                day = "Thursday";
                break;
            case 6:
                day = "Friday";
                break;
            case 7:
                day = "Saturday";
                break;
        }
        return day;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

}
