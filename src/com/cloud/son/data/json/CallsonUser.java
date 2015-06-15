/**
 * 
 */
package com.cloud.son.data.json;

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
public class CallsonUser implements ICreator<JSONObject>, IParser<JSONObject> {

	public class UserProperty implements ICreator<JSONObject>,
			IParser<JSONObject> {
		public UserProperty(){}
		public UserProperty(JSONObject obj){
			this.parse(obj);
		}
		public UserProperty(String str){
			this(new JSONObject(str));
		}
		
		String cnName;
		String enName;
		int age;
		String description;
		String password;
		String phone;

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getPhone() {
			return phone;
		}

		public void setPhone(String phone) {
			this.phone = phone;
		}

		public String getCnName() {
			return cnName;
		}

		public void setCnName(String cnName) {
			this.cnName = cnName;
		}

		public String getEnName() {
			return enName;
		}

		public void setEnName(String enName) {
			this.enName = enName;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
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

	/**
	 * 用户类型
	 */
	public enum UserType {
		CUSTOMER, //需求客户 
		PROVIDER, //服务者
		MANAGER, //管理员
		VISITOR, //游客
	}

	private String uId;
	private UserType type;
	private UserProperty uProp;

	public String getUId() {
		return uId;
	}

	public void setUId(String id) {
		uId = id;
	}

	public UserType getType() {
		return type;
	}

	public void setType(UserType type) {
		this.type = type;
	}

	public UserProperty getUProp() {
		return uProp;
	}

	public void setUProp(UserProperty prop) {
		uProp = prop;
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
				null : new UserProperty(data.getJSONObject(UserConstant.USER_PARAM_USERPROPERTY));
	}

}
