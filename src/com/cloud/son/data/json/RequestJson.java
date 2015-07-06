package com.cloud.son.data.json;

import com.cloud.son.data.ICreator;
import com.cloud.son.data.IParser;
import com.cloud.son.data.constant.RequestConstant;
import org.json.JSONObject;
import com.cloud.son.data.entity.Request;

/**
 * Created by wengshinan on 2015/7/2.
 */
public class RequestJson implements ICreator<JSONObject>, IParser<JSONObject> {

    private Request request;

    public RequestJson(Request request){
        if(request == null) this.request = new Request();
        else this.request = request;
    }

    public RequestJson(JSONObject object){
        this.request = new Request();
        this.parse(object);
    }

    public Request getRequest() {
        return request;
    }

    @Override
    public JSONObject create() {
        JSONObject reqObj = new JSONObject();
        reqObj.put(RequestConstant.REQUEST_PARAM_TYPE, request.getRequestType());
        reqObj.put(RequestConstant.REQUEST_PARAM_BODY, request.getRequestBody());
        reqObj.put(RequestConstant.REQUEST_PARAM_TOKEN, request.getToken());

        return reqObj;
    }

    @Override
    public void parse(JSONObject obj) {
        this.request.setRequestType(obj.getString(RequestConstant.REQUEST_PARAM_TYPE));
        this.request.setRequestBody(obj.getString(RequestConstant.REQUEST_PARAM_BODY));
        this.request.setToken(obj.getString(RequestConstant.REQUEST_PARAM_TOKEN));
    }
}
