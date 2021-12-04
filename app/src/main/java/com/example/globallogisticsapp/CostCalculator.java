package com.example.globallogisticsapp;

public class CostCalculator {
    private float rebate;
    private float wm;

    CostCalculator(){
        rebate = 0;
        wm = 0;
    }

    public void setRebate(float wm) {
        rebate = (15 * wm) + 25;
    }

    public float getRebate() {
        return rebate;
    }

    public void setWm(float volume, float weight) {
        //Convert weight in kg to weight in tons
        weight *= 0.00110231;//Kg to Tons conversion

        //W/M (the weight measurement) is set to whichever value is greater.
        wm = Math.max(volume, weight);
    }

    public float getWm() {
        return wm;
    }
}
