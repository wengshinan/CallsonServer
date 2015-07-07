/**
 *
 */
package com.cloud.son.data;

import com.cloud.son.utils.PropertyUtil;

/**
 * 传输数据配置参数
 *
 * @author fjfh-wengsn
 */
public final class DataProperty {

    /**
     * 数据结构
     */
    private DataType dataType;
    private int longestLength;

    private DataProperty() {
        dataType = DataType.valueOf(PropertyUtil.getProperty(PropertyUtil.KEY_DATA_TYPE));
        longestLength = Integer.parseInt(PropertyUtil.getProperty(PropertyUtil.KEY_DATA_LONGEST_LENGTH));
    }

    public static DataType getDataType() {
        return DataPropertyHolder.dataProperty.getType();
    }

    public static int getLongestLength() {
        return DataPropertyHolder.dataProperty.getLength();
    }

    private DataType getType() {
        return dataType;
    }

    private int getLength() {
        return longestLength;
    }

    /**
     * 传输数据格式
     */
    public enum DataType {
        JSON,
        XML,
    }

    private static class DataPropertyHolder {
        private static final DataProperty dataProperty = new DataProperty();
    }

}
