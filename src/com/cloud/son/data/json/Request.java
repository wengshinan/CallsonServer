/**
 * 
 */
package com.cloud.son.data.json;


import com.cloud.son.data.constant.ReqRespConstant;
import org.json.JSONObject;

import com.cloud.son.data.ICreator;
import com.cloud.son.data.IParser;

/**
 * 请求类
 * 
 * @author fjfh-wengsn
 *
 */
public class Request implements ICreator<JSONObject>, IParser<JSONObject> {

	private ReqType type;
	private ReqParam reqParam;
	private Session session;
	private Location uLocation;
	private String requestBody;
	private String serialno;
	private Service service;
	public Request(){}
	public Request(JSONObject obj){
		this.parse(obj);
	}
	public Request(String str){
		this(new JSONObject(str));
	}

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

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	public String getRequestBody() {
		return requestBody;
	}

	public void setRequestBody(String requestBody) {
		this.requestBody = requestBody;
	}

	public String getSerialno() {
		return serialno;
	}

	public void setSerialno(String serialno) {
		this.serialno = serialno;
	}

	public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
	}
	
	@Override
	public JSONObject create() {
		JSONObject request = new JSONObject();
		request.put(ReqRespConstant.REQUEST_PARAM_TYPE, type==null ? null : type.toString());
		request.put(ReqRespConstant.REQUEST_PARAM_PARAM, reqParam==null ? null : reqParam.create());
		request.put(ReqRespConstant.REQUEST_PARAM_BODY, requestBody);
		request.put(ReqRespConstant.REQUEST_PARAM_LOCATION, uLocation == null ? null : uLocation.create());
		request.put(ReqRespConstant.REQUEST_PARAM_TOKEN, session == null ? null : session.create());
		request.put(ReqRespConstant.REQUEST_PARAM_SERIALNO, serialno);
		request.put(ReqRespConstant.REQUEST_PARAM_SERVICE, service);

		return request;
	}

	@Override
	public void parse(JSONObject obj) {
		this.type = obj.isNull(ReqRespConstant.REQUEST_PARAM_TYPE) ?
				null : ReqType.valueOf(obj.getString(ReqRespConstant.REQUEST_PARAM_TYPE));
		this.reqParam = obj.isNull(ReqRespConstant.REQUEST_PARAM_PARAM) ?
				null : new ReqParam(obj.getJSONObject(ReqRespConstant.REQUEST_PARAM_PARAM));
		this.requestBody = obj.isNull(ReqRespConstant.REQUEST_PARAM_BODY) ?
				null : obj.getString(ReqRespConstant.REQUEST_PARAM_BODY);
		this.session = obj.isNull(ReqRespConstant.REQUEST_PARAM_TOKEN) ?
				null : new Session(obj.getJSONObject(ReqRespConstant.REQUEST_PARAM_TOKEN));
		this.uLocation = obj.isNull(ReqRespConstant.REQUEST_PARAM_LOCATION) ?
				null : new Location(obj.getJSONObject(ReqRespConstant.REQUEST_PARAM_LOCATION));
		this.serialno = obj.isNull(ReqRespConstant.REQUEST_PARAM_SERIALNO) ?
				null : obj.getString(ReqRespConstant.REQUEST_PARAM_SERIALNO);
		this.service = obj.isNull(ReqRespConstant.REQUEST_PARAM_SERVICE) ?
				null : new Service(obj.getJSONObject(ReqRespConstant.REQUEST_PARAM_SERVICE));
	}


	/**
	 * 请求类型
	 */
	public enum ReqType {
		USER_LOGIN,            //
		USER_REGISTER,        //
		USER_LOGOUT,        //
		ADD_SERVICE,        //
		MODIFY_SERVICE,        //
		DELETE_SERVICE,        //
		PAY_SERVICE,        //
		;
		/*
		public ReqType getReqType(String type){
			if (ReqRespConstant.REQUEST_TYPE_UER_LOGIN.equals(type)) return USER_LOGIN;
			if (ReqRespConstant.REQUEST_TYPE_UER_REGISTER.equals(type)) return USER_REGISTER;
			if (ReqRespConstant.REQUEST_TYPE_UER_LOGOUT.equals(type)) return USER_LOGOUT;
			if (ReqRespConstant.REQUEST_TYPE_SERVICE_ADD.equals(type)) return ADD_SERVICE;
			if (ReqRespConstant.REQUEST_TYPE_SERVICE_MODIFY.equals(type)) return MODIFY_SERVICE;
			if (ReqRespConstant.REQUEST_TYPE_SERVICE_DELETE.equals(type)) return DELETE_SERVICE;
			if (ReqRespConstant.REQUEST_TYPE_SERVICE_PAY.equals(type)) return PAY_SERVICE;
			return null;
		}*/
	}

	/**
	 * 请求参数
	 */
	public class ReqParam implements ICreator<JSONObject>, IParser<JSONObject> {

		String reqDate;
		String reqTime;

		public ReqParam() {
		}

		public ReqParam(JSONObject obj) {
			this.parse(obj);
		}

		public ReqParam(String str) {
			this(new JSONObject(str));
		}

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
			reqParam.put(ReqRespConstant.REQUEST_PARAM_DATE, reqDate);
			reqParam.put(ReqRespConstant.REQUEST_PARAM_TIME, reqTime);
			return reqParam;
		}

		@Override
		public void parse(JSONObject data) {
			reqDate = data.isNull(ReqRespConstant.REQUEST_PARAM_DATE) ?
					null : data.getString(ReqRespConstant.REQUEST_PARAM_DATE);
			reqTime = data.isNull(ReqRespConstant.REQUEST_PARAM_TIME) ?
					null : data.getString(ReqRespConstant.REQUEST_PARAM_TIME);

		}
	}

}
