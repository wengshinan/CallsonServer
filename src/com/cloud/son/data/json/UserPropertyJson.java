package com.cloud.son.data.json;

import com.cloud.son.data.ICreator;
import com.cloud.son.data.IParser;
import com.cloud.son.data.constant.UserConstant;
import com.cloud.son.data.entity.UserProperty;
import org.json.JSONObject;

/**
 * Created by wengshinan on 15/6/28.
 */
public class UserPropertyJson implements ICreator<JSONObject>,
        IParser<JSONObject> {
    private UserProperty userProp;

    public UserPropertyJson(UserProperty userProp) {
        if (null == userProp) this.userProp = new UserProperty();
        this.userProp = userProp;
    }

    public UserPropertyJson(JSONObject object) {
        this.userProp = new UserProperty();
        this.parse(object);
    }

    public UserProperty getUserProp() {
        return this.userProp;
    }

    @Override
    public JSONObject create() {
        JSONObject prop = new JSONObject();
        prop.put(UserConstant.USER_PARAM_CNNAME, this.userProp.getCnName());
        prop.put(UserConstant.USER_PARAM_ENNAME, this.userProp.getEnName());
        prop.put(UserConstant.USER_PARAM_AGE, this.userProp.getAge());
        prop.put(UserConstant.USER_PARAM_DESCRIPTION, this.userProp.getDescription());
        prop.put(UserConstant.USER_PARAM_PHONE, this.userProp.getPhone());
        prop.put(UserConstant.USER_PARAM_PASSWORD, this.userProp.getPassword());
        return prop;
    }

    @Override
    public void parse(JSONObject data) {
        this.userProp.setCnName(data.isNull(UserConstant.USER_PARAM_CNNAME) ?
                null : data.getString(UserConstant.USER_PARAM_CNNAME));
        this.userProp.setEnName(data.isNull(UserConstant.USER_PARAM_ENNAME) ?
                null : data.getString(UserConstant.USER_PARAM_ENNAME));
        this.userProp.setAge(data.isNull(UserConstant.USER_PARAM_AGE) ?
                0 : data.getInt(UserConstant.USER_PARAM_AGE));
        this.userProp.setDescription(data.isNull(UserConstant.USER_PARAM_DESCRIPTION) ?
                null : data.getString(UserConstant.USER_PARAM_DESCRIPTION));
        this.userProp.setPhone(data.isNull(UserConstant.USER_PARAM_PHONE) ?
                null : data.getString(UserConstant.USER_PARAM_PHONE));
        this.userProp.setPassword(data.isNull(UserConstant.USER_PARAM_PASSWORD) ?
                null : data.getString(UserConstant.USER_PARAM_PASSWORD));

    }
}
