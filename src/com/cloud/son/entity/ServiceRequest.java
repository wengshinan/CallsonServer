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
public class ServiceRequest implements ICreator<JSONObject>, IParser<JSONObject> {
	
	/**
	 * @author fjfh-wengsn
	 *
	 */
	public class ReqParam implements ICreator<JSONObject>, IParser<JSONObject>  {
		String reqDate = "";
		String reqTime = "";
		
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
			reqParam.put("date", reqDate);
			reqParam.put("time", reqTime);
			return reqParam;
		}

		@Override
		public void parse(JSONObject data) {
			reqDate = data.getString("date");
			reqTime = data.getString("time");
			
		}
	}


	/**
	 * 请求类型
	 */
	public enum ReqType {
		AddReqest,
		ModifyReqest,
		DeleteRequest;
		
		public ReqType getReqType(String type){
			if ("AddReqest".equals(type)) return AddReqest;
			if ("ModifyReqest".equals(type)) return ModifyReqest;
			else return DeleteRequest;
		}
	}


	private ReqType type;
	private ReqParam reqParam;
	private CallsonUser user;
	private UserHistory uHistory;
	private Location uLocation;
	private ServiceParam sParam;


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


	public CallsonUser getUser() {
		return user;
	}


	public void setUser(CallsonUser user) {
		this.user = user;
	}


	public UserHistory getUHistory() {
		return uHistory;
	}


	public void setUHistory(UserHistory history) {
		uHistory = history;
	}


	public Location getULocation() {
		return uLocation;
	}


	public void setULocation(Location location) {
		uLocation = location;
	}


	public ServiceParam getSParam() {
		return sParam;
	}


	public void setSParam(ServiceParam param) {
		sParam = param;
	}
	

	@Override
	public JSONObject create() {
		JSONObject request = new JSONObject();
		request.put("type", type==null?null:type.toString());
		request.put("param", reqParam==null?null:reqParam.create());
		request.put("user", user==null?null:user.create());
		
		return request;
	}


	@Override
	public void parse(JSONObject obj) {
		this.type = ReqType.valueOf(obj.getString("type"));
		this.reqParam = new ReqParam();
		this.reqParam.parse(obj.getJSONObject("param"));
		this.user = new CallsonUser();
		this.user.parse(obj.getJSONObject("user"));		
	}

}
