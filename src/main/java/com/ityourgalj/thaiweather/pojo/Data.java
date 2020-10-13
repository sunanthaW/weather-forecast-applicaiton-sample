
package com.ityourgalj.thaiweather.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data {

    @SerializedName("rh")
    @Expose
    private Double rh;
    @SerializedName("tc_max")
    @Expose
    private Double tcMax;
    @SerializedName("tc_min")
    @Expose
    private Double tcMin;
    @SerializedName("cond")
    @Expose
    private Integer cond;

    public Double getRh() {
        return rh;
    }

    public void setRh(Double rh) {
        this.rh = rh;
    }

    public Double getTcMax() {
        return tcMax;
    }

    public void setTcMax(Double tcMax) {
        this.tcMax = tcMax;
    }

	public Double getTcMin() {
		return tcMin;
	}

	public void setTcMin(Double tcMin) {
		this.tcMin = tcMin;
	}

	public Integer getCond() {
		return cond;
	}

	public void setCond(Integer cond) {
		this.cond = cond;
	}
    
    

}
