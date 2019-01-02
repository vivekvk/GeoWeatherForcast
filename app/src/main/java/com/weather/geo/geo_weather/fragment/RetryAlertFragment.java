package com.weather.geo.geo_weather.fragment;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.weather.geo.geo_weather.R;

/**
 * Created by Vivek
 */
public class RetryAlertFragment extends Fragment {
    TextView tv_ErrorText;
    Button btn_Retry;


    public RetryAlertFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tv_ErrorText = view.findViewById(R.id.tv_errortext);
        Typeface roboto = Typeface.createFromAsset(getActivity().getAssets(),
                "fonts"+"/Roboto-Thin.ttf"); //use this.getAssets if you are calling from an
        // Activity
        tv_ErrorText.setTypeface(roboto);
        btn_Retry = view.findViewById(R.id.btn_retry);
        btn_Retry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction tx = getActivity().getSupportFragmentManager()
                        .beginTransaction();
                tx.replace(R.id.frame_container, new WeatherCastFragment());
                tx.commit();
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_retry_alert, container, false);
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
