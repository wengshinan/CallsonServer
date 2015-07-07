package com.cloud.son.data.entity;

/**
 * Created by wengshinan on 2015/7/7.
 */
public class Response {

    private int respCode;
    private String respMsg;
    private String respBody;

    public int getRespCode() {
        return respCode;
    }

    public void setRespCode(int respCode) {
        this.respCode = respCode;
    }

    public String getRespMsg() {
        return respMsg;
    }

    public void setRespMsg(String respMsg) {
        this.respMsg = respMsg;
    }

    public String getRespBody() {
        return respBody;
    }

    public void setRespBody(String respBody) {
        this.respBody = respBody;
    }
}
