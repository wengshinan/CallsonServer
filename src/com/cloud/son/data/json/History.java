package com.cloud.son.data.json;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.cloud.son.data.ICreator;
import com.cloud.son.data.IParser;
import com.cloud.son.entity.constant.OrderConstant;

/**
 * 历史订单类
 * 
 * @author fjfh-wengsn
 *
 */
public class History implements ICreator<JSONObject>, IParser<JSONObject> {
	
	public History(){}
	public History(JSONObject obj){
		this.parse(obj);
	}
	public History(String str){
		this(new JSONObject(str));
	}
	
	List<Order> orderList = null;

	@Override
	public JSONObject create() {
		JSONObject historyObj = new JSONObject();
		JSONArray historyArray = null;
		if (null != orderList && orderList.size() != 0) {
			historyArray = new JSONArray();
			for (Order order : orderList){
				historyArray.put(order.create());
			}
		}
		historyObj.put(OrderConstant.ORDER_PARAM_ORDERLIST, historyArray);
		return historyObj;
	}

	@Override
	public void parse(JSONObject obj) {
		
		JSONArray historyArray = obj.isNull(OrderConstant.ORDER_PARAM_ORDERLIST) ? 
				null : obj.getJSONArray(OrderConstant.ORDER_PARAM_ORDERLIST);
		
		if (null != historyArray && historyArray.length() > 0) {
			this.orderList = new ArrayList<Order>();
			for (int i = 1; i <= historyArray.length(); i++){
				JSONObject orderObj = historyArray.getJSONObject(i);
				Order order = new Order();
				order.parse(orderObj);
				orderList.add(order);
			}
		}
	}
	
}
