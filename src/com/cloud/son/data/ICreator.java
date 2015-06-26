/**
 * 
 */
package com.cloud.son.data;

/**
 * 生成交互数据
 * 
 * @author fjfh-wengsn
 *
 * @param <DataType> 交互数据类型
 */
public interface ICreator<DataType> {
	DataType create();
}
