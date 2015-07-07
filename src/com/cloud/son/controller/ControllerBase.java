package com.cloud.son.controller;

import com.cloud.son.data.DataProperty;
import com.cloud.son.data.entity.Response;
import com.cloud.son.data.parser.ResponseParser;

/**
 * Created by wengshinan on 2015/7/7.
 */
public abstract class ControllerBase {

    protected int uid;
    protected String token;

    protected ControllerBase(int uid, String token) {
        this.uid = uid;
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    protected boolean checkToken() {
        if (SessionController.checkTokenValid(uid, token)) return true;
        else return false;
    }

    protected boolean setToken() {
        String result = SessionController.resetToken(uid, token);
        if (null != result) {
            this.token = result;
            return true;
        } else return false;
    }

    protected boolean unsetToken() {
        return SessionController.abandonToken(uid);
    }

    protected Response genResponse(int respCode, String respMsg, String respBody) {
        Response response = new Response();
        response.setRespCode(respCode);
        response.setRespMsg(respMsg);
        response.setRespBody(respBody);

        return response;
    }

    protected abstract String dealRequest(String reqStr);
}
