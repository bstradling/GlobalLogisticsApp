package com.example.globallogisticsapp;

import java.io.Serializable;

public class CostCalculator implements Serializable {
    private float rebate;
    private float wm;
    private float customsCost;
    private float transportCost;
    private float transportManpowerCost;
    private float dischargeCost;
    private float dischargeManpowerCost;
    private float loadingCost;
    private float loadingManpowerCost;
    private float warehousingCost;
    private float warehousingManpowerCost;
    private float demurrageCost;
    private float detentionCost;
    private float tariffCost;
    private float total;

    CostCalculator(){
        rebate = 0;
        wm = 0;
    }

    public void setRebate(float wm) {
        rebate = (15 * wm) + 25;
    }

    public void setRebate() {
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

    public void setCustomsCost(float customsCost) {
        this.customsCost = customsCost;
    }

    public void setDemurrageCost(float demurrageCost) {
        this.demurrageCost = demurrageCost;
    }

    public void setDetentionCost(float detentionCost) {
        this.detentionCost = detentionCost;
    }

    public void setDischargeCost(float dischargeCost) {
        this.dischargeCost = dischargeCost;
    }

    public void setDischargeManpowerCost(float dischargeManpowerCost) {
        this.dischargeManpowerCost = dischargeManpowerCost;
    }

    public void setLoadingCost(float loadingCost) {
        this.loadingCost = loadingCost;
    }

    public void setLoadingManpowerCost(float loadingManpowerCost) {
        this.loadingManpowerCost = loadingManpowerCost;
    }

    public void setTariffCost(float tariffCost) {
        this.tariffCost = tariffCost;
    }

    public void setTransportCost(float transportCost) {
        this.transportCost = transportCost;
    }

    public void setTransportManpowerCost(float transportManpowerCost) {
        this.transportManpowerCost = transportManpowerCost;
    }

    public void setWarehousingCost(float warehousingCost) {
        this.warehousingCost = warehousingCost;
    }

    public void setWarehousingManpowerCost(float warehousingManpowerCost) {
        this.warehousingManpowerCost = warehousingManpowerCost;
    }

    public float getCustomsCost() {
        return customsCost;
    }

    public float getDemurrageCost() {
        return demurrageCost;
    }

    public float getDetentionCost() {
        return detentionCost;
    }

    public float getDischargeCost() {
        return dischargeCost;
    }

    public float getDischargeManpowerCost() {
        return dischargeManpowerCost;
    }

    public float getLoadingCost() {
        return loadingCost;
    }

    public float getLoadingManpowerCost() {
        return loadingManpowerCost;
    }

    public float getTariffCost() {
        return tariffCost;
    }

    public float getTransportCost() {
        return transportCost;
    }

    public float getTransportManpowerCost() {
        return transportManpowerCost;
    }

    public float getWarehousingCost() {
        return warehousingCost;
    }

    public float getWarehousingManpowerCost() {
        return warehousingManpowerCost;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public float getTotal() {
        return total;
    }
}
