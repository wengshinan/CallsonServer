/**
 * 
 */
package com.cloud.son.data.json;

import org.json.JSONObject;

import com.cloud.son.data.ICreator;
import com.cloud.son.data.IParser;
import com.cloud.son.entity.constant.SessionConstant;

/**
 * 会话记录
 * 
 * @author fjfh-wengsn
 *
 */
public class Session implements ICreator<JSONObject>, IParser<JSONObject> {
	
	public Session(){}
	public Session(JSONObject obj){
		this.parse(obj);
	}
	public Session(String str){
		this(new JSONObject(str));
	}
	
	
	private String sessionId;
	private String uId;
	
	
	public String getSessionId() {
		return sessionId;
	}
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	public String getUId() {
		return uId;
	}
	public void setUId(String id) {
		uId = id;
	}
	
	@Override
	public JSONObject create() {
		JSONObject sessionObj = new JSONObject();
		sessionObj.put(SessionConstant.SESSION_PARAM_SESSIONID, sessionId);
		sessionObj.put(SessionConstant.SESSION_PARAM_USERID, uId);
		return sessionObj;
	}
	@Override
	public void parse(JSONObject obj) {
		this.sessionId = obj.isNull(SessionConstant.SESSION_PARAM_SESSIONID) ? 
				null : obj.getString(SessionConstant.SESSION_PARAM_SESSIONID);
		this.uId = obj.isNull(SessionConstant.SESSION_PARAM_USERID) ? 
				null : obj.getString(SessionConstant.SESSION_PARAM_USERID);
		
	}
	
	
}
