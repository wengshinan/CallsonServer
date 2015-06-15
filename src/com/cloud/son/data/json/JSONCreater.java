/**
 * 
 */
package com.cloud.son.data.json;

import org.json.JSONObject;

import com.cloud.son.entity.CallsonUser;
import com.cloud.son.entity.ServiceRequest;
import com.cloud.son.entity.CallsonUser.UserProperty;
import com.cloud.son.entity.ServiceRequest.ReqParam;

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
		
		ServiceRequest req = new ServiceRequest();
		req.setType(ServiceRequest.ReqType.AddReqest);
		
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
		req.setUser(user);
		
		
		JSONObject obj = req.create();
		String str = obj.toString();
		System.out.println(str);
		
		ServiceRequest request = new ServiceRequest();
		request.parse(new JSONObject(str));
		System.out.println(request.getType());
	}

}
