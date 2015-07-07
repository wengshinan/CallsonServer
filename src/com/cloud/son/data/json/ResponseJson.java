package com.cloud.son.data.json;

import com.cloud.son.data.ICreator;
import com.cloud.son.data.IParser;
import com.cloud.son.data.constant.ReqRespConstant;
import com.cloud.son.data.entity.Response;
import org.json.JSONObject;

/**
 * Created by wengshinan on 2015/7/7.
 */
public class ResponseJson implements ICreator<JSONObject>, IParser<JSONObject> {

    private Response response;

    public ResponseJson(JSONObject object) {
        this.response = new Response();
        this.parse(object);

    }

    public ResponseJson(Response response) {
        if (null == response) this.response = new Response();
        else this.response = response;

    }

    public Response getResponse() {
        return response;
    }

    @Override
    public JSONObject create() {
        JSONObject respObj = new JSONObject();
        respObj.put(ReqRespConstant.RESPONSE_PARAM_RESPCODE, response.getRespCode());
        respObj.put(ReqRespConstant.RESPONSE_PARAM_RESPMSG, response.getRespMsg());
        respObj.put(ReqRespConstant.REQUEST_PARAM_BODY, response.getRespBody());

        return respObj;
    }

    @Override
    public void parse(JSONObject obj) {
        this.response.setRespCode(obj.getInt(ReqRespConstant.RESPONSE_PARAM_RESPCODE));
        this.response.setRespMsg(obj.getString(ReqRespConstant.RESPONSE_PARAM_RESPMSG));
        this.response.setRespBody(obj.getString(ReqRespConstant.RESPONSE_PARAM_BODY));
    }
}
