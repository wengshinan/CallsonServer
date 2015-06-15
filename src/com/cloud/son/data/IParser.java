/**
 * 
 */
package com.cloud.son.data;

/**
 * 解析交互数据
 * 
 * @author fjfh-wengsn
 * 
 * @param <DataType> 交互数据类型
 */
public interface IParser<DataType> {
	public void parse(DataType obj);
	
	//public void parse(String data);
}
