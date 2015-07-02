package com.cloud.son.data.parser;

import com.cloud.son.data.DataProperty;
import com.cloud.son.data.entity.Request;
import com.cloud.son.data.json.RequestJson;
import org.json.JSONObject;

/**
 * Created by wengshinan on 2015/7/2.
 */
public class RequestParser {

    public static Request parse(DataProperty.DataType type, String source){
        Request request = null;
        switch (type) {
            case JSON:
                request = new RequestJson(new JSONObject(source)).getRequest();
                break;
            case XML:
                break;
            default:
                break;
        }
        return request;
    }

    public static String create(DataProperty.DataType type, Request request){
        String result = null;
        switch (type) {
            case JSON:
                result = new RequestJson(request).create().toString();
                break;
            case XML:
                break;
            default:
                break;
        }
        return result;
    }
}
