/**
 * 
 */
package com.cloud.son.data;

/**
 * ������������
 * 
 * @author fjfh-wengsn
 * 
 * @param <DataType> ������������
 */
public interface IParser<DataType> {
	public void parse(DataType obj);
	
	//public void parse(String data);
}
