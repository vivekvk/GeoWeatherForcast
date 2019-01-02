package com.weather.geo.geo_weather.fragment;
/*
 * Copyright (C) 2018 Stack Labs, Inc - All Rights Reserved.
 * Contents of this file are proprietary and confidential.
 * Unauthorized copying of this file, via any medium, is strictly prohibited.
 */

import com.weather.geo.geo_weather.model.Location;

public class WeatherResponseModel {

    private Location location;

    private Current current;

    public Location getLocation ()
    {
        return location;
    }

    public void setLocation (Location location)
    {
        this.location = location;
    }

    public Current getCurrent ()
    {
        return current;
    }

    public void setCurrent (Current current)
    {
        this.current = current;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [location = "+location+", current = "+current+"]";
    }
}
