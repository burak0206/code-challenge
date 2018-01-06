package com.datapine.model;

import javax.validation.constraints.NotNull;

public class StatisticRequestModel {
    private Integer last;

    @NotNull
    private String timeUnit;

    private Integer mavgPoints;

    public Integer getLast() {
        return last;
    }

    public void setLast(Integer last) {
        this.last = last;
    }

    public String getTimeUnit() {
        return timeUnit;
    }

    public void setTimeUnit(String timeUnit) {
        this.timeUnit = timeUnit;
    }

    public Integer getMavgPoints() {
        return mavgPoints;
    }

    public void setMavgPoints(Integer mavgPoints) {
        this.mavgPoints = mavgPoints;
    }
}
