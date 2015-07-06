package com.cloud.son.data;

/**
 * Created by wengshinan on 2015/7/2.
 */
public class RequestType {
    public enum UserInfoReqType{
        REGISTER,
        LOGIN,
        LOGOUT,
        PASSWORD_RESET,
        PHONE_CHANGE,
        INFO_MODIFY,
    }

    public enum ServiceReqType{

    }
}
