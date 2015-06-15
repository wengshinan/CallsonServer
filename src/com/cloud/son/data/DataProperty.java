/**
 * 
 */
package com.cloud.son.data;

/**
 * 传输数据配置参数
 * 
 * @author fjfh-wengsn
 * 
 */
public final class DataProperty {

	/**
	 * 数据结构
	 */
	public static DataType dataType;
	public static int longestLength;
	
	
	/**
	 * 读配置
	 */
	public void readProperty(){
		DataProperty.dataType = DataType.JSON;
		DataProperty.longestLength = 65535;
	}
	public void readProperty(String configFilePath){
		
	}
	

	/**
	 * 传输数据格式
	 */
	public enum DataType {
		JSON,
		XML,
	}

}
