package com.weather.geo.geo_weather;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;

import com.weather.geo.geo_weather.fragment.RetryAlertFragment;
import com.weather.geo.geo_weather.fragment.WeatherCastFragment;

public class MainActivity extends AppCompatActivity {

    FrameLayout fr_Container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fr_Container = (FrameLayout) findViewById(R.id.frame_container);

       FragmentTransaction tx = getSupportFragmentManager().beginTransaction();
        tx.replace(R.id.frame_container, new WeatherCastFragment());
        tx.commit();

    }
}
