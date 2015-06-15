package com.cloud.son.data.json;

import org.json.JSONObject;

import com.cloud.son.data.ICreator;
import com.cloud.son.data.IParser;

/**
 * 地理位置类
 * 
 * @author fjfh-wengsn
 *
 */
public class Location implements ICreator<JSONObject>, IParser<JSONObject> {
	
	public Location(){}
	public Location(JSONObject obj){ 
		this.parse(obj);
	}
	public Location(String str){
		this(new JSONObject(str));
	}

	@Override
	public JSONObject create() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void parse(JSONObject data) {
		// TODO Auto-generated method stub
		
	}

}
