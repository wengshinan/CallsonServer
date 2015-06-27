/**
 * 
 */
package com.cloud.son.data.json;

import com.cloud.son.entity.CallsonUser;
import org.json.JSONObject;

import com.cloud.son.data.ICreator;
import com.cloud.son.data.IParser;
import com.cloud.son.entity.constant.UserConstant;

/**
 * 用户类
 * 
 * @author fjfh-wengsn
 * 
 */
public class CallsonUserJson extends CallsonUser implements ICreator<JSONObject>, IParser<JSONObject> {

	public class UserPropertyJson extends CallsonUser.UserProperty implements ICreator<JSONObject>,
			IParser<JSONObject> {
		public UserPropertyJson(){}
		public UserPropertyJson(JSONObject obj){
			this.parse(obj);
		}
		public UserPropertyJson(String str){
			this(new JSONObject(str));
		}

		@Override
		public JSONObject create() {
			JSONObject prop = new JSONObject();
			prop.put(UserConstant.USER_PARAM_CNNAME, cnName);
			prop.put(UserConstant.USER_PARAM_ENNAME, enName);
			prop.put(UserConstant.USER_PARAM_AGE, age);
			prop.put(UserConstant.USER_PARAM_DESCRIPTION, description);
			prop.put(UserConstant.USER_PARAM_PHONE, phone);
			prop.put(UserConstant.USER_PARAM_PASSWORD, password);
			return prop;
		}

		@Override
		public void parse(JSONObject data) {
			cnName = data.isNull(UserConstant.USER_PARAM_CNNAME) ? 
					null : data.getString(UserConstant.USER_PARAM_CNNAME);
			enName = data.isNull(UserConstant.USER_PARAM_ENNAME) ? 
					null : data.getString(UserConstant.USER_PARAM_ENNAME);
			age = data.isNull(UserConstant.USER_PARAM_AGE) ? 
					0 : data.getInt(UserConstant.USER_PARAM_AGE);
			description = data.isNull(UserConstant.USER_PARAM_DESCRIPTION) ? 
					null : data.getString(UserConstant.USER_PARAM_DESCRIPTION);
			phone = data.isNull(UserConstant.USER_PARAM_PHONE) ? 
					null : data.getString(UserConstant.USER_PARAM_PHONE);
			password = data.isNull(UserConstant.USER_PARAM_PASSWORD) ? 
					null : data.getString(UserConstant.USER_PARAM_PASSWORD);

		}

	}

	@Override
	public JSONObject create() {
		JSONObject user = new JSONObject();
		user.put(UserConstant.USER_PARAM_USERID, uId);
		user.put(UserConstant.USER_PARAM_USERTYPE, type);
		user.put(UserConstant.USER_PARAM_USERPROPERTY, uProp == null ? null : uProp.create());

		return user;
	}

	@Override
	public void parse(JSONObject data) {
		this.uId = data.isNull(UserConstant.USER_PARAM_USERID) ? 
				null : data.getString(UserConstant.USER_PARAM_USERID);
		this.type = data.isNull(UserConstant.USER_PARAM_USERTYPE) ? 
				null : UserType.valueOf(data.getString(UserConstant.USER_PARAM_USERTYPE));
		this.uProp = data.isNull(UserConstant.USER_PARAM_USERPROPERTY) ? 
				null : new UserPropertyJson(data.getJSONObject(UserConstant.USER_PARAM_USERPROPERTY));
	}

}
