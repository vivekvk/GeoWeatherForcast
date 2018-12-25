package com.weather.geo.geo_weather.fragment;

import com.weather.geo.geo_weather.Condition;

public class Current {

    private String temp_f;

    private Condition condition;

    private String temp_c;

    private String wind_degree;

    private String wind_dir;

    private String wind_kph;

    private String is_day;

    private String pressure_in;

    private String humidity;

    private String uv;

    private String vis_km;

    private String precip_mm;

    private String wind_mph;

    private String pressure_mb;

    private String feelslike_f;

    private String cloud;

    private String last_updated_epoch;

    private String feelslike_c;

    private String last_updated;

    private String precip_in;

    private String vis_miles;

    public String getTemp_f ()
    {
        return temp_f;
    }

    public void setTemp_f (String temp_f)
    {
        this.temp_f = temp_f;
    }

    public Condition getCondition ()
    {
        return condition;
    }

    public void setCondition (Condition condition)
    {
        this.condition = condition;
    }

    public String getTemp_c ()
    {
        return temp_c;
    }

    public void setTemp_c (String temp_c)
    {
        this.temp_c = temp_c;
    }

    public String getWind_degree ()
    {
        return wind_degree;
    }

    public void setWind_degree (String wind_degree)
    {
        this.wind_degree = wind_degree;
    }

    public String getWind_dir ()
    {
        return wind_dir;
    }

    public void setWind_dir (String wind_dir)
    {
        this.wind_dir = wind_dir;
    }

    public String getWind_kph ()
    {
        return wind_kph;
    }

    public void setWind_kph (String wind_kph)
    {
        this.wind_kph = wind_kph;
    }

    public String getIs_day ()
    {
        return is_day;
    }

    public void setIs_day (String is_day)
    {
        this.is_day = is_day;
    }

    public String getPressure_in ()
    {
        return pressure_in;
    }

    public void setPressure_in (String pressure_in)
    {
        this.pressure_in = pressure_in;
    }

    public String getHumidity ()
    {
        return humidity;
    }

    public void setHumidity (String humidity)
    {
        this.humidity = humidity;
    }

    public String getUv ()
    {
        return uv;
    }

    public void setUv (String uv)
    {
        this.uv = uv;
    }

    public String getVis_km ()
    {
        return vis_km;
    }

    public void setVis_km (String vis_km)
    {
        this.vis_km = vis_km;
    }

    public String getPrecip_mm ()
    {
        return precip_mm;
    }

    public void setPrecip_mm (String precip_mm)
    {
        this.precip_mm = precip_mm;
    }

    public String getWind_mph ()
    {
        return wind_mph;
    }

    public void setWind_mph (String wind_mph)
    {
        this.wind_mph = wind_mph;
    }

    public String getPressure_mb ()
    {
        return pressure_mb;
    }

    public void setPressure_mb (String pressure_mb)
    {
        this.pressure_mb = pressure_mb;
    }

    public String getFeelslike_f ()
    {
        return feelslike_f;
    }

    public void setFeelslike_f (String feelslike_f)
    {
        this.feelslike_f = feelslike_f;
    }

    public String getCloud ()
    {
        return cloud;
    }

    public void setCloud (String cloud)
    {
        this.cloud = cloud;
    }

    public String getLast_updated_epoch ()
    {
        return last_updated_epoch;
    }

    public void setLast_updated_epoch (String last_updated_epoch)
    {
        this.last_updated_epoch = last_updated_epoch;
    }

    public String getFeelslike_c ()
    {
        return feelslike_c;
    }

    public void setFeelslike_c (String feelslike_c)
    {
        this.feelslike_c = feelslike_c;
    }

    public String getLast_updated ()
    {
        return last_updated;
    }

    public void setLast_updated (String last_updated)
    {
        this.last_updated = last_updated;
    }

    public String getPrecip_in ()
    {
        return precip_in;
    }

    public void setPrecip_in (String precip_in)
    {
        this.precip_in = precip_in;
    }

    public String getVis_miles ()
    {
        return vis_miles;
    }

    public void setVis_miles (String vis_miles)
    {
        this.vis_miles = vis_miles;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [temp_f = "+temp_f+", condition = "+condition+", temp_c = "+temp_c+", wind_degree = "+wind_degree+", wind_dir = "+wind_dir+", wind_kph = "+wind_kph+", is_day = "+is_day+", pressure_in = "+pressure_in+", humidity = "+humidity+", uv = "+uv+", vis_km = "+vis_km+", precip_mm = "+precip_mm+", wind_mph = "+wind_mph+", pressure_mb = "+pressure_mb+", feelslike_f = "+feelslike_f+", cloud = "+cloud+", last_updated_epoch = "+last_updated_epoch+", feelslike_c = "+feelslike_c+", last_updated = "+last_updated+", precip_in = "+precip_in+", vis_miles = "+vis_miles+"]";
    }
}
