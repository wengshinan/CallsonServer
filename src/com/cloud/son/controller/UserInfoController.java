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


    public String dealRequest(String reqStr) {

        Request request = RequestParser.parse(DataProperty.getDataType(), reqStr);

        RequestType.UserInfoReqType type = RequestType.UserInfoReqType.valueOf(request.getRequestType());

        String result = null;

        try {
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

    private String dealRegister(String reqStr) throws UserDuplicatedException, MissingNecessaryFieldException {
        CallsonUser user = CallsonUserParser.parse(DataProperty.getDataType(), reqStr);

        String phone = user.getUProp().getPhone();
        if (null != phone) {
            if (UserInfoModule.checkIfExist(phone)) {
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
