/**
 * 
 */
package com.cloud.son.data;

/**
 * ���ɽ�������
 * 
 * @author fjfh-wengsn
 *
 * @param <DataType> ������������
 */
public interface ICreator<DataType> {
	public DataType create();
}
