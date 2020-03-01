package com.iotproject.smartem.model;

public class Data {
    private float voltage, current, appPower, realPower;
    private String timestamp;

    public Data(float voltage, float current, float appPower, float realPower, String timestamp) {
        this.voltage = voltage;
        this.current = current;
        this.appPower = appPower;
        this.realPower = realPower;
        this.timestamp = timestamp;
    }

    public float getVoltage() {
        return voltage;
    }

    public float getCurrent() {
        return current;
    }

    public float getAppPower() {
        return appPower;
    }

    public float getRealPower() {
        return realPower;
    }

    public String getTimestamp() {
        return timestamp;
    }
}
