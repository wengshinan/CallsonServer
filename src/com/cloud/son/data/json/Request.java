/**
 * 
 */
package com.cloud.son.data.json;


import org.json.JSONObject;

import com.cloud.son.data.ICreator;
import com.cloud.son.data.IParser;
import com.cloud.son.entity.constant.RequestConstant;

/**
 * 请求类
 * 
 * @author fjfh-wengsn
 *
 */
public class Request implements ICreator<JSONObject>, IParser<JSONObject> {
	
	public Request(){}
	public Request(JSONObject obj){
		this.parse(obj);
	}
	public Request(String str){
		this(new JSONObject(str));
	}
	
	/**
	 * 请求参数
	 */
	public class ReqParam implements ICreator<JSONObject>, IParser<JSONObject>  {
		
		public ReqParam(){}
		public ReqParam(JSONObject obj){
			this.parse(obj);
		}
		public ReqParam(String str){
			this(new JSONObject(str));
		}
		
		String reqDate;
		String reqTime;
		
		public String getReqDate() {
			return reqDate;
		}

		public void setReqDate(String reqDate) {
			this.reqDate = reqDate;
		}

		public String getReqTime() {
			return reqTime;
		}

		public void setReqTime(String reqTime) {
			this.reqTime = reqTime;
		}

		@Override
		public JSONObject create() {
			JSONObject reqParam = new JSONObject();
			reqParam.put(RequestConstant.REQUEST_PARAM_DATE, reqDate);
			reqParam.put(RequestConstant.REQUEST_PARAM_TIME, reqTime);
			return reqParam;
		}

		@Override
		public void parse(JSONObject data) {
			reqDate = data.isNull(RequestConstant.REQUEST_PARAM_DATE) ? 
					null : data.getString(RequestConstant.REQUEST_PARAM_DATE);
			reqTime = data.isNull(RequestConstant.REQUEST_PARAM_TIME) ? 
					null : data.getString(RequestConstant.REQUEST_PARAM_TIME);
			
		}
	}


	/**
	 * 请求类型
	 */
	public enum ReqType {
		USER_LOGIN,			//
		USER_REGISTER,		//
		USER_LOGOUT,		//
		ADD_SERVICE,		//
		MODIFY_SERVICE,		//
		DELETE_SERVICE,		//
		PAY_SERVICE,		//
		;
		/*
		public ReqType getReqType(String type){
			if (RequestConstant.REQUEST_TYPE_UER_LOGIN.equals(type)) return USER_LOGIN;
			if (RequestConstant.REQUEST_TYPE_UER_REGISTER.equals(type)) return USER_REGISTER;
			if (RequestConstant.REQUEST_TYPE_UER_LOGOUT.equals(type)) return USER_LOGOUT;
			if (RequestConstant.REQUEST_TYPE_SERVICE_ADD.equals(type)) return ADD_SERVICE;
			if (RequestConstant.REQUEST_TYPE_SERVICE_MODIFY.equals(type)) return MODIFY_SERVICE;
			if (RequestConstant.REQUEST_TYPE_SERVICE_DELETE.equals(type)) return DELETE_SERVICE;
			if (RequestConstant.REQUEST_TYPE_SERVICE_PAY.equals(type)) return PAY_SERVICE;
			return null;
		}*/
	}


	private ReqType type;
	private ReqParam reqParam;
	private Session session;
	private Location uLocation;
	private String requestBody;
	private String serialno;
	private Service service;


	public ReqType getType() {
		return type;
	}


	public void setType(ReqType type) {
		this.type = type;
	}


	public ReqParam getReqParam() {
		return reqParam;
	}


	public void setReqParam(ReqParam reqParam) {
		this.reqParam = reqParam;
	}


	public Location getULocation() {
		return uLocation;
	}


	public void setULocation(Location location) {
		uLocation = location;
	}


	public void setSession(Session session) {
		this.session = session;
	}


	public Session getSession() {
		return session;
	}


	public void setRequestBody(String requestBody) {
		this.requestBody = requestBody;
	}


	public String getRequestBody() {
		return requestBody;
	}


	public void setSerialno(String serialno) {
		this.serialno = serialno;
	}


	public String getSerialno() {
		return serialno;
	}
	

	public void setService(Service service) {
		this.service = service;
	}


	public Service getService() {
		return service;
	}


	@Override
	public JSONObject create() {
		JSONObject request = new JSONObject();
		request.put(RequestConstant.REQUEST_PARAM_TYPE, type==null ? null : type.toString());
		request.put(RequestConstant.REQUEST_PARAM_PARAM, reqParam==null ? null : reqParam.create());
		request.put(RequestConstant.REQUEST_PARAM_BODY, requestBody);
		request.put(RequestConstant.REQUEST_PARAM_LOCATION, uLocation == null ? null : uLocation.create());
		request.put(RequestConstant.REQUEST_PARAM_SESSION, session == null ? null : session.create());
		request.put(RequestConstant.REQUEST_PARAM_SERIALNO, serialno);
		request.put(RequestConstant.REQUEST_PARAM_SERVICE, service);
		
		return request;
	}


	@Override
	public void parse(JSONObject obj) {
		this.type = obj.isNull(RequestConstant.REQUEST_PARAM_TYPE) ? 
				null : ReqType.valueOf(obj.getString(RequestConstant.REQUEST_PARAM_TYPE));
		this.reqParam = obj.isNull(RequestConstant.REQUEST_PARAM_PARAM) ? 
				null : new ReqParam(obj.getJSONObject(RequestConstant.REQUEST_PARAM_PARAM));
		this.requestBody = obj.isNull(RequestConstant.REQUEST_PARAM_BODY) ? 
				null : obj.getString(RequestConstant.REQUEST_PARAM_BODY);
		this.session = obj.isNull(RequestConstant.REQUEST_PARAM_SESSION) ? 
				null : new Session(obj.getJSONObject(RequestConstant.REQUEST_PARAM_SESSION)); 
		this.uLocation = obj.isNull(RequestConstant.REQUEST_PARAM_LOCATION) ? 
				null : new Location(obj.getJSONObject(RequestConstant.REQUEST_PARAM_LOCATION));
		this.serialno = obj.isNull(RequestConstant.REQUEST_PARAM_SERIALNO) ? 
				null : obj.getString(RequestConstant.REQUEST_PARAM_SERIALNO);
		this.service = obj.isNull(RequestConstant.REQUEST_PARAM_SERVICE) ? 
				null : new Service(obj.getJSONObject(RequestConstant.REQUEST_PARAM_SERVICE));
	}

}
