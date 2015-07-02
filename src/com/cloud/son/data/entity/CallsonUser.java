package com.cloud.son.data.entity;

/**
 * Created by wengshinan on 2015/6/26.
 */
public class CallsonUser {


    private String uId;
    private UserType type;
    private UserProperty uProp;

    public String getUId() {
        return uId;
    }

    public void setUId(String id) {
        uId = id;
    }

    public UserType getType() {
        return type;
    }

    public void setType(UserType type) {
        this.type = type;
    }

    public UserProperty getUProp() {
        return uProp;
    }

    public void setUProp(UserProperty prop) {
        uProp = prop;
    }

    /**
     * 用户类型
     */
    public enum UserType {
        CUSTOMER, //需求客户
        PROVIDER, //服务者
        MANAGER, //管理员
        VISITOR, //游客
    }

}
