package com.cloud.son.data.parser;

import com.cloud.son.data.DataProperty;
import com.cloud.son.data.entity.CallsonUser;
import com.cloud.son.data.json.CallsonUserJson;
import org.json.JSONObject;

/**
 * Created by wengshinan on 15/6/28.
 */
public class CallsonUserParser {

    public static CallsonUser parse(DataProperty.DataType type, String source) {
        CallsonUser user = null;
        switch (type) {
            case JSON:
                user = new CallsonUserJson(new JSONObject(source)).getUser();
                break;
            case XML:
                break;
            default:
                break;
        }


        return user;
    }

    public static String create(DataProperty.DataType type, CallsonUser user) {
        String result = null;
        switch (type) {
            case JSON:
                result = new CallsonUserJson(user).create().toString();
                break;
            case XML:
                break;
            default:
                break;
        }


        return result;
    }
}
