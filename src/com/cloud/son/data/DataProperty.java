/**
 * 
 */
package com.cloud.son.data;

/**
 * �����������ò���
 * 
 * @author fjfh-wengsn
 * 
 */
public final class DataProperty {

	/**
	 * ���ݽṹ
	 */
	public static DataType dataType;
	public static int longestLength;
	
	
	/**
	 * ������
	 */
	public void readProperty(){
		DataProperty.dataType = DataType.JSON;
		DataProperty.longestLength = 65535;
	}
	public void readProperty(String configFilePath){
		
	}
	

	/**
	 * �������ݸ�ʽ
	 */
	public enum DataType {
		JSON,
		XML,
	}

}
