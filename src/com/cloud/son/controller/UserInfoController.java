package com.cloud.son.controller;

import com.cloud.son.data.DataProperty;
import com.cloud.son.data.RequestType;
import com.cloud.son.data.entity.CallsonUser;
import com.cloud.son.data.entity.Request;
import com.cloud.son.data.parser.CallsonUserParser;
import com.cloud.son.data.parser.RequestParser;

/**
 * Created by wengshinan on 2015/7/2.
 */
public class UserInfoController {


    public String dealRequest(String reqStr) {

        Request request = RequestParser.parse(DataProperty.getDataType(), reqStr);

        RequestType.UserInfoReqType type = RequestType.UserInfoReqType.valueOf(request.getRequestType());

        String result = null;
        switch (type) {
            case REGISTER:
                result = dealRegister(request.getRequestBody());
                break;
            case LOGIN:
                break;
            case LOGOUT:
                break;
            case PASSWORD_RESET:
                break;
            case PHONE_CHANGE:
                break;
            case INFO_EDIT:
                break;
        }

        return result;
    }

    private String dealRegister(String reqStr){
        CallsonUser user = CallsonUserParser.parse(DataProperty.getDataType(), reqStr);
        return null;
    }
}
