package com.cloud.son.controller;

import com.cloud.son.data.DataProperty;
import com.cloud.son.data.RequestType;
import com.cloud.son.data.constant.ReqRespConstant;
import com.cloud.son.data.entity.CallsonUser;
import com.cloud.son.data.entity.Request;
import com.cloud.son.data.entity.Response;
import com.cloud.son.data.parser.CallsonUserParser;
import com.cloud.son.data.parser.RequestParser;
import com.cloud.son.exception.MissingNecessaryFieldException;
import com.cloud.son.exception.UserDuplicatedException;
import com.cloud.son.module.UserInfoModule;

/**
 * Created by wengshinan on 2015/7/2.
 */
public class UserInfoController extends ControllerBase {

    public UserInfoController(int uid, String token) {
        super(uid, token);
    }

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
                    result = dealLogin(request.getRequestBody());
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

    private String dealLogout(String reqStr) {
        return null;
    }

    // 处理登录请求
    private String dealLogin(String reqStr) {
        CallsonUser user = CallsonUserParser.parse(DataProperty.getDataType(), reqStr);

        String phone = user.getUProp().getPhone();
        String password = user.getUProp().getPassword();
        if (null != phone) {
            int uid = UserInfoModule.getUidIfValid(phone, password);
            if (uid > 0) {
                user.setUId(uid);
                this.uid = uid;
                this.setToken();
                return genResponse(ReqRespConstant.RESPONSE_CODE_SUCCESS,
                        ReqRespConstant.RESPONSE_MSG_LOGON_SUCCESS,
                        CallsonUserParser.create(DataProperty.getDataType(), user));
            } else if (uid == 0) { //不存在该用户
                return genResponse(ReqRespConstant.RESPONSE_CODE_USER_NOT_EXIST,
                        ReqRespConstant.RESPONSE_MSG_USER_NOT_EXIST,
                        CallsonUserParser.create(DataProperty.getDataType(), user));
            } else { //密码错误
                return genResponse(ReqRespConstant.RESPONSE_CODE_NOT_CORRECT_PASSWORD,
                        ReqRespConstant.RESPONSE_MSG_NOT_CORRECT_PASSWORD,
                        CallsonUserParser.create(DataProperty.getDataType(), user));
            }
        }


        return null;
    }

    // 处理注册请求
    private String dealRegister(String reqStr) throws UserDuplicatedException, MissingNecessaryFieldException {
        Response response = new Response();

        CallsonUser user = CallsonUserParser.parse(DataProperty.getDataType(), reqStr);

        String phone = user.getUProp().getPhone();
        if (null != phone) {
            if (!UserInfoModule.checkIfExist(phone)) {
                int uid = UserInfoModule.addUser(user);
                user.setUId(uid);
                this.uid = uid;
                this.setToken();
                return genResponse(ReqRespConstant.RESPONSE_CODE_SUCCESS,
                        ReqRespConstant.RESPONSE_MSG_REGISTER_SUCCESS,
                        CallsonUserParser.create(DataProperty.getDataType(), user));
            } else {
                return genResponse(ReqRespConstant.RESPONSE_CODE_DUPLICATED_USER,
                        ReqRespConstant.RESPONSE_MSG_DUPLICATED_USER,
                        CallsonUserParser.create(DataProperty.getDataType(), user));
            }
        } else {
            return genResponse(ReqRespConstant.RESPONSE_CODE_MISSING_NECESSARY_FIELD,
                    ReqRespConstant.RESPONSE_MSG_MISSING_PHONE,
                    CallsonUserParser.create(DataProperty.getDataType(), user));
        }
    }


}
