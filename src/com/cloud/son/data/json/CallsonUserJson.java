/**
 *
 */
package com.cloud.son.data.json;

import com.cloud.son.data.ICreator;
import com.cloud.son.data.IParser;
import com.cloud.son.data.constant.UserConstant;
import com.cloud.son.data.entity.CallsonUser;
import org.json.JSONObject;

/**
 * 用户类
 *
 * @author fjfh-wengsn
 */
public class CallsonUserJson implements ICreator<JSONObject>, IParser<JSONObject> {

    private CallsonUser user;

    public CallsonUserJson(CallsonUser user) {
        if (null == user) this.user = new CallsonUser();
        else this.user = user;
    }

    public CallsonUserJson(JSONObject object) {
        this.user = new CallsonUser();
        this.parse(object);
    }

    public CallsonUser getUser() {
        return this.user;
    }

    @Override
    public JSONObject create() {
        JSONObject userObj = new JSONObject();
        userObj.put(UserConstant.USER_PARAM_USERID, user.getUId());
        userObj.put(UserConstant.USER_PARAM_USERTYPE, user.getType());
        userObj.put(UserConstant.USER_PARAM_USERPROPERTY, user.getUProp() == null ? null :
                new UserPropertyJson(user.getUProp()).create());

        return userObj;
    }

    @Override
    public void parse(JSONObject data) {
        this.user.setUId(data.isNull(UserConstant.USER_PARAM_USERID) ?
                null : data.getString(UserConstant.USER_PARAM_USERID));
        this.user.setType(data.isNull(UserConstant.USER_PARAM_USERTYPE) ?
                null : CallsonUser.UserType.valueOf(data.getString(UserConstant.USER_PARAM_USERTYPE)));
        this.user.setUProp(data.isNull(UserConstant.USER_PARAM_USERPROPERTY) ?
                null : new UserPropertyJson(data.getJSONObject(UserConstant.USER_PARAM_USERPROPERTY)).getUserProp());
    }


}
