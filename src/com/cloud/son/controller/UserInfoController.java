package com.cloud.son.controller;

import com.cloud.son.data.DataProperty;
import com.cloud.son.data.RequestType;
import com.cloud.son.data.entity.CallsonUser;
import com.cloud.son.data.entity.Request;
import com.cloud.son.data.parser.CallsonUserParser;
import com.cloud.son.data.parser.RequestParser;
import com.cloud.son.exception.MissingNecessaryFieldException;
import com.cloud.son.exception.UserDuplicatedException;
import com.cloud.son.module.UserInfoModule;

/**
 * Created by wengshinan on 2015/7/2.
 */
public class UserInfoController {

    private String phone;
    private String token;

    public UserInfoController(String phone, String token){
        this.phone = phone;
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    private boolean checkToken() {
        if (SessionController.checkToken(phone, token)) return true;
        else return false;
    }

    private boolean setToken() {
        String result = SessionController.resetToken(phone, token);
        if (null != result) {
            this.token = result;
            return true;
        } else return false;
    }

    private boolean unsetToken() {
        return SessionController.abandonToken(phone, token);
    }

    public String dealRequest(String reqStr) {

        Request request = RequestParser.parse(DataProperty.getDataType(), reqStr);

        RequestType.UserInfoReqType type = RequestType.UserInfoReqType.valueOf(request.getRequestType());

        String result = null;

        try {
            switch (type) {
                case REGISTER:
                    if (setToken()) {
                        result = dealRegister(request.getRequestBody());
                    }
                    break;
                case LOGIN:
                    if (setToken()) {
                        result = dealLogin(request.getRequestBody());
                    }
                    break;
                case LOGOUT:
                    if (unsetToken()) {
                        result = dealLogout(request.getRequestBody());
                    }
                    break;
                case PASSWORD_RESET:
                    break;
                case PHONE_CHANGE:
                    break;
                case INFO_MODIFY:
                    break;
            }
        } catch (UserDuplicatedException e) {
            e.printStackTrace();
        } catch (MissingNecessaryFieldException e) {
            e.printStackTrace();
        } finally {
        }

        return result;
    }

    private String dealLogout(String requestBody) {
        return null;
    }

    private String dealLogin(String requestBody) {
        return null;
    }

    private String dealRegister(String reqStr) throws UserDuplicatedException, MissingNecessaryFieldException {
        CallsonUser user = CallsonUserParser.parse(DataProperty.getDataType(), reqStr);

        String phone = user.getUProp().getPhone();
        if (null != phone) {
            if (!UserInfoModule.checkIfExist(phone)) {
                //TODO 处理用户注册
                int uid = UserInfoModule.addUser(user);
                user.setUId(uid);
            } else {
                throw new UserDuplicatedException();
            }
        } else {
            throw new MissingNecessaryFieldException();
        }
        String respStr = CallsonUserParser.create(DataProperty.getDataType(), user);

        return respStr;
    }


}
