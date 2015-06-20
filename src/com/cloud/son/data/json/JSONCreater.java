/**
 * 
 */
package com.cloud.son.data.json;

import org.json.JSONObject;

import com.cloud.son.data.json.CallsonUser;
import com.cloud.son.data.json.Request;
import com.cloud.son.data.json.CallsonUser.UserProperty;
import com.cloud.son.data.json.Request.ReqParam;

/**
 * 用于生成JSON对象
 * 
 * @author fjfh-wengsn
 * 
 */
public class JSONCreater {

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		
		Request req = new Request();
		req.setType(Request.ReqType.USER_REGISTER);
		
		ReqParam reqParam = req.new ReqParam();
		reqParam.setReqDate("2015-06-05");
		reqParam.setReqTime("10:31:00");
		req.setReqParam(reqParam);
		
		CallsonUser user = new CallsonUser();
		//user.setType(CallsonUser.UserType.CUSTOMER);
		//user.setUId("0000001");
		UserProperty up = user.new UserProperty();
		up.setAge(19);
		up.setCnName("爸爸");
		up.setEnName("Bob");
		up.setDescription("客户就是我们的爸爸");
		user.setUProp(up);
		req.setRequestBody(user.create().toString());
		//req.set(user).;
		
		
		JSONObject obj = req.create();
		String str = obj.toString();
		System.out.println(str);
		
		Request request = new Request();
		request.parse(new JSONObject(str));
		System.out.println(request.getType());
	}

}
