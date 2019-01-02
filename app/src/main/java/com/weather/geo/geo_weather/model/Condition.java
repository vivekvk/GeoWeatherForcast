package com.weather.geo.geo_weather.model;


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
