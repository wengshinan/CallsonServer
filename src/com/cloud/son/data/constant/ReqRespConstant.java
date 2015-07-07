package com.cloud.son.data.constant;



/**
 * 请求返回常量
 * 
 * @author fjfh-wengsn
 *
 */
public class ReqRespConstant {
	
	public static final String REQUEST_PARAM_DATE = "date";
	public static final String REQUEST_PARAM_TIME = "time";
	public static final String REQUEST_PARAM_TYPE = "type";
	public static final String REQUEST_PARAM_PARAM = "param";
	public static final String REQUEST_PARAM_BODY = "body";
	public static final String REQUEST_PARAM_TOKEN = "session";
	public static final String REQUEST_PARAM_LOCATION = "location";
	public static final String REQUEST_PARAM_SERIALNO = "serialno";
	public static final String REQUEST_PARAM_SERVICE = "service";
	
	public static final String REQUEST_TYPE_UER_LOGIN = "UserLogin";
	public static final String REQUEST_TYPE_UER_REGISTER = "UserRegister";
	public static final String REQUEST_TYPE_UER_LOGOUT = "UserLogout";
	public static final String REQUEST_TYPE_SERVICE_ADD = "AddService";
	public static final String REQUEST_TYPE_SERVICE_MODIFY = "ModifyService";
	public static final String REQUEST_TYPE_SERVICE_DELETE = "DeleteService";
	public static final String REQUEST_TYPE_SERVICE_PAY = "PayService";


	public static final String RESPONSE_PARAM_RESPCODE = "respCode";
	public static final String RESPONSE_PARAM_RESPMSG = "respMsg";
	public static final String RESPONSE_PARAM_BODY = "body";


	public static final int RESPONSE_CODE_SUCCESS = 0;
	public static final int RESPONSE_CODE_MISSING_NECESSARY_FIELD = -1;
	public static final int RESPONSE_CODE_DUPLICATED_USER = -2;
	public static final int RESPONSE_CODE_USER_NOT_EXIST = -3;
	public static final int RESPONSE_CODE_NOT_CORRECT_PASSWORD = -4;

	public static final String RESPONSE_MSG_REGISTER_SUCCESS = "注册成功";
	public static final String RESPONSE_MSG_DUPLICATED_USER = "用户已存在";
	public static final String RESPONSE_MSG_MISSING_PHONE = "缺少手机号";

	public static final String RESPONSE_MSG_LOGON_SUCCESS = "登录成功";
	public static final String RESPONSE_MSG_USER_NOT_EXIST = "该手机对应的用户不存在";
	public static final String RESPONSE_MSG_NOT_CORRECT_PASSWORD = "密码不正确";
}
