package com.weather.geo.geo_weather.model;
/*
 * Copyright (C) 2018 Stack Labs, Inc - All Rights Reserved.
 * Contents of this file are proprietary and confidential.
 * Unauthorized copying of this file, via any medium, is strictly prohibited.
 */

public class Condition {

    private String icon;

    private String text;

    private String code;

    public String getIcon ()
    {
        return icon;
    }

    public void setIcon (String icon)
    {
        this.icon = icon;
    }

    public String getText ()
    {
        return text;
    }

    public void setText (String text)
    {
        this.text = text;
    }

    public String getCode ()
    {
        return code;
    }

    public void setCode (String code)
    {
        this.code = code;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [icon = "+icon+", text = "+text+", code = "+code+"]";
    }
}
