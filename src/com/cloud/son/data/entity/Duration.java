package com.cloud.son.data.entity;

/**
 * Created by wengshinan on 15/6/28.
 */
public class Duration extends EntityBase {

    private String startDate;
    private String startTime;
    private String endDate;
    private String endTime;

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    @Override
    public Object newInstance() {
        return new Duration();
    }
}
