/**
 * 
 */
package com.cloud.son.data.json;

import org.json.JSONObject;

import com.cloud.son.data.ICreator;
import com.cloud.son.data.IParser;
import com.cloud.son.entity.constant.OrderConstant;
import com.cloud.son.entity.constant.ServiceConstant;

/**
 * 订单类
 * 
 * @author fjfh-wengsn
 *
 */
public class Order implements ICreator<JSONObject>, IParser<JSONObject> {
	
	public Order(){}
	public Order(JSONObject obj){
		this.parse(obj);
	}
	public Order(String str){
		this(new JSONObject(str));
	}
	
	private String orderId;
	private String paySerialno;
	private String serviceId;
	

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getPaySerialno() {
		return paySerialno;
	}

	public void setPaySerialno(String paySerialno) {
		this.paySerialno = paySerialno;
	}

	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}

	public String getServiceId() {
		return serviceId;
	}

	@Override
	public JSONObject create() {
		JSONObject orderObj = new JSONObject();
		orderObj.put(OrderConstant.ORDER_PARAM_ORDERID, orderId);
		orderObj.put(OrderConstant.ORDER_PARAM_PAY_SERIALNO, paySerialno);
		orderObj.put(ServiceConstant.SERVICE_PARAM_SERVICEID, serviceId);
		return orderObj;
	}

	@Override
	public void parse(JSONObject obj) {
		orderId = obj.isNull(OrderConstant.ORDER_PARAM_ORDERID) ? 
				null : obj.getString(OrderConstant.ORDER_PARAM_ORDERID);
		paySerialno = obj.isNull(OrderConstant.ORDER_PARAM_PAY_SERIALNO) ? 
				null : obj.getString(OrderConstant.ORDER_PARAM_PAY_SERIALNO);	
		serviceId = obj.isNull(ServiceConstant.SERVICE_PARAM_SERVICEID) ? 
				null : obj.getString(ServiceConstant.SERVICE_PARAM_SERVICEID);
	}

}
