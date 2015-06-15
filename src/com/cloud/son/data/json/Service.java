/**
 * 
 */
package com.cloud.son.data.json;

import org.json.JSONArray;
import org.json.JSONObject;

import com.cloud.son.data.ICreator;
import com.cloud.son.data.IParser;
import com.cloud.son.entity.constant.ServiceConstant;

/**
 * ������
 * 
 * @author fjfh-wengsn
 *
 */
public class Service implements ICreator<JSONObject>, IParser<JSONObject> {
	
	public Service(){}
	public Service(JSONObject obj){
		this.parse(obj);
	}
	public Service(String str) {
		this(new JSONObject(str));
	}
	
	/**
	 * ��������
	 */
	public enum ServiceType{
		ACCOMPANY_CARE, //�㻤
		MEDICAL_CARE, //ҽ��
		HOUSEKEEPING, //����
		FAMILY_EDUCATION, //�ҽ�
		HOUSE_REPAIREMENT, //ά��
		OTHERS,		 //����
	}
	
	private String serviceId;
	private ServiceType type;

	public String getServiceId() {
		return serviceId;
	}
	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}
	public void setType(ServiceType type) {
		this.type = type;
	}
	public ServiceType getType() {
		return type;
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

	
	public static void main(String[] args){
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
	
}
