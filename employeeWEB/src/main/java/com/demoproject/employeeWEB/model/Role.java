package com.demoproject.employeeWEB.model;

public class Role {

    private String roleName;
    private double bandMin;
    private double bandMax;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public double getBandMin() {
        return bandMin;
    }

    public void setBandMin(double bandMin) {
        this.bandMin = bandMin;
    }

    public double getBandMax() {
        return bandMax;
    }

    public void setBandMax(double bandMax) {
        this.bandMax = bandMax;
    }
}
