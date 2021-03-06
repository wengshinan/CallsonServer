package com.cloud.son.server;

import org.json.JSONObject;

import com.cloud.son.data.DataProperty;

/**
 * 服务匹配类
 * 
 * @author fjfh-wengsn
 *
 */
public class ServiceMatcher {

	private String recvData;

	public ServiceMatcher(String recvData) {
		this.recvData = recvData;
	}

	public void findObject() throws Exception {
		if (recvData == null)
			throw new Exception("");
		
		if (DataProperty.getDataType() == DataProperty.DataType.JSON){
			JSONObject recvObject = getJSONObject();
		}

	}

	private JSONObject getJSONObject() {
		if (recvData == null)
			return null;

		return new JSONObject(recvData);
	}

}
