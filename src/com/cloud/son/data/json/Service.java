/**
 * 
 */
package com.cloud.son.data.json;

import com.cloud.son.data.entity.CallsonUser;
import org.json.JSONArray;
import org.json.JSONObject;

import com.cloud.son.data.ICreator;
import com.cloud.son.data.IParser;
import com.cloud.son.data.constant.ServiceConstant;

/**
 * 服务类
 * 
 * @author fjfh-wengsn
 *
 */
public class Service implements ICreator<JSONObject>, IParser<JSONObject> {

	private String serviceId;
	private ServiceType type;
	public Service(){}

	public Service(JSONObject obj){
		this.parse(obj);
	}

	public Service(String str) {
		this(new JSONObject(str));
	}

	public static void main(String[] args) {
		Service service = new Service();
		JSONObject obj = new JSONObject();
		String str = null;
		CallsonUser.UserType type = null;
		JSONArray historyArray = null;
		obj.put(ServiceConstant.SERVICE_PARAM_SERVICEID, str);
		obj.put("test", historyArray);

		Service service1 = new Service(obj);
		System.out.println(obj);

	}

	public String getServiceId() {
		return serviceId;
	}
	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}

	public ServiceType getType() {
		return type;
	}

	public void setType(ServiceType type) {
		this.type = type;
	}
	
	@Override
	public JSONObject create() {
		JSONObject serviceObj = new JSONObject();
		serviceObj.put(ServiceConstant.SERVICE_PARAM_SERVICEID, serviceId);
		serviceObj.put(ServiceConstant.SERVICE_PARAM_SERVICE_TYPE, type);
		return serviceObj;
	}

	@Override
	public void parse(JSONObject obj) {
		serviceId = obj.isNull(ServiceConstant.SERVICE_PARAM_SERVICEID) ? 
				null : obj.getString(ServiceConstant.SERVICE_PARAM_SERVICEID);
		type = obj.isNull(ServiceConstant.SERVICE_PARAM_SERVICE_TYPE) ? 
				null : ServiceType.valueOf(obj.getString(ServiceConstant.SERVICE_PARAM_SERVICE_TYPE));
		
	}


	/**
	 * 服务类型
	 */
	public enum ServiceType {
		ACCOMPANY_CARE, //陪护
		MEDICAL_CARE, //医疗
		HOUSEKEEPING, //家政
		FAMILY_EDUCATION, //家教
		HOUSE_REPAIREMENT, //维修
		OTHERS,         //其他
	}

}
