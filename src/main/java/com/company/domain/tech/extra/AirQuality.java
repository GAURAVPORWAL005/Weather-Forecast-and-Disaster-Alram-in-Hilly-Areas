package com.company.domain.tech.extra;


//import com.fasterxml.jackson.annotation.JsonProperty;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AirQuality{
    public double co;
    public double no2;
    public double o3;
    public double so2;
    public double pm2_5;
    public double pm10;
    @JsonProperty("us-epa-index")
    public int usEpaIndex;
    @JsonProperty("gb-defra-index")
    public int gbDefraIndex;

    public double getCo() {
        return co;
    }

    public void setCo(double co) {
        this.co = co;
    }

    public double getNo2() {
        return no2;
    }

    public void setNo2(double no2) {
        this.no2 = no2;
    }

    public double getO3() {
        return o3;
    }

    public void setO3(double o3) {
        this.o3 = o3;
    }

    public double getSo2() {
        return so2;
    }

    public void setSo2(double so2) {
        this.so2 = so2;
    }

    public double getPm2_5() {
        return pm2_5;
    }

    public void setPm2_5(double pm2_5) {
        this.pm2_5 = pm2_5;
    }

    public double getPm10() {
        return pm10;
    }

    public void setPm10(double pm10) {
        this.pm10 = pm10;
    }

    public int getUsEpaIndex() {
        return usEpaIndex;
    }

    public void setUsEpaIndex(int usEpaIndex) {
        this.usEpaIndex = usEpaIndex;
    }

    public int getGbDefraIndex() {
        return gbDefraIndex;
    }

    public void setGbDefraIndex(int gbDefraIndex) {
        this.gbDefraIndex = gbDefraIndex;
    }
}