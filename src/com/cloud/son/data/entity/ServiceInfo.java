package com.cloud.son.data.entity;

/**
 * Created by wengshinan on 15/6/28.
 */
public class ServiceInfo {


    private Duration duration;
    private String location;
    private CallsonUser customer;
    private CallsonUser provider;
    private ServiceType type;

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public CallsonUser getCustomer() {
        return customer;
    }

    public void setCustomer(CallsonUser customer) {
        this.customer = customer;
    }

    public CallsonUser getProvider() {
        return provider;
    }

    public void setProvider(CallsonUser provider) {
        this.provider = provider;
    }

    public ServiceType getType() {
        return type;
    }

    public void setType(ServiceType type) {
        this.type = type;
    }

    /**
     * 服务类型
     */
    public enum ServiceType {
        ACCOMPANY_CARE, //陪护
        MEDICAL_CARE, //医疗
        HOUSEKEEPING, //家政
        FAMILY_EDUCATION, //家教
        HOUSE_REPAIREMENT, //维修
        OTHERS,         //其他
    }
}
