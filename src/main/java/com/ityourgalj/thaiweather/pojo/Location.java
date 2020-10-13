
package com.ityourgalj.thaiweather.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Location {

    @SerializedName("province")
    @Expose
    private String province;
    @SerializedName("areatype")
    @Expose
    private String areatype;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("tambon")
    @Expose
    private Object tambon;
    @SerializedName("region")
    @Expose
    private String region;
    @SerializedName("geocode")
    @Expose
    private String geocode;
    @SerializedName("amphoe")
    @Expose
    private Object amphoe;
    @SerializedName("lat")
    @Expose
    private Double lat;
    @SerializedName("lon")
    @Expose
    private Double lon;

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getAreatype() {
        return areatype;
    }

    public void setAreatype(String areatype) {
        this.areatype = areatype;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getTambon() {
        return tambon;
    }

    public void setTambon(Object tambon) {
        this.tambon = tambon;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getGeocode() {
        return geocode;
    }

    public void setGeocode(String geocode) {
        this.geocode = geocode;
    }

    public Object getAmphoe() {
        return amphoe;
    }

    public void setAmphoe(Object amphoe) {
        this.amphoe = amphoe;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }

}
