package com.cloud.son.data.parser;

import com.cloud.son.data.DataProperty;
import com.cloud.son.data.entity.Response;
import com.cloud.son.data.json.ResponseJson;
import org.json.JSONObject;

/**
 * Created by wengshinan on 2015/7/7.
 */
public class ResponseParser {

    public static Response parse(DataProperty.DataType type, String source) {
        Response response = null;
        switch (type) {
            case JSON:
                response = new ResponseJson(new JSONObject(source)).getResponse();
                break;
            case XML:
                break;
            default:
                break;
        }
        return response;
    }

    public static String create(DataProperty.DataType type, Response response) {
        String result = null;
        switch (type) {
            case JSON:
                result = new ResponseJson(response).create().toString();
                break;
            case XML:
                break;
            default:
                break;
        }
        return result;
    }
}
