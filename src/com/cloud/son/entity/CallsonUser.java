/**
 * 
 */
package com.cloud.son.entity;

import org.json.JSONObject;

import com.cloud.son.data.ICreator;
import com.cloud.son.data.IParser;

/**
 * @author fjfh-wengsn
 *
 */
public class CallsonUser implements ICreator<JSONObject>, IParser<JSONObject>  {
	
	public class UserProperty implements ICreator<JSONObject>, IParser<JSONObject>  {
		private String cnName = "";
		private String enName = "";
		private int age = 0;
		private String description = "";

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		private String password = "";

		public String getPhone() {
			return phone;
		}

		public void setPhone(String phone) {
			this.phone = phone;
		}

		private String phone = "";


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
			prop.put("cnname", cnName);
			prop.put("enname", enName);
			prop.put("age", age);
			prop.put("description", description);
			prop.put("phone", phone);
			prop.put("password", password);
			return prop;
		}


		@Override
		public void parse(JSONObject data) {
			cnName = data.getString("cnname");
			enName = data.getString("enname");
			age = data.getInt("age");
			description = data.getString("description");
			phone = data.getString("phone");
			password = data.getString("password");
			
		}
		
		
	}

	public enum UserType {
		CUSTOMER,
		PROVIDER,
		MANAGER,
		VISITOR,
	}

	private String uId = "";
	private UserType type; 
	private UserProperty uProp; 
	
	public class Customer extends CallsonUser{
		
	}

	@Override
	public JSONObject create() {
		JSONObject user = new JSONObject();
		user.put("userid", uId);
		user.put("type", type==null?null:type.toString());
		user.put("property", uProp==null?null:uProp.create());
		
		return user;
	}

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
	public void parse(JSONObject data) {
		this.uId = data.getString("userid");
		if (!data.isNull("type")) {
			String type = data.getString("type");
			if (null != type) {
				this.type = UserType.valueOf(type);
			}
		}
		this.uProp = new UserProperty();
		uProp.parse(data.getJSONObject("property"));
	}

	
}
