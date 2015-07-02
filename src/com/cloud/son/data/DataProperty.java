/**
 *
 */
package com.cloud.son.data;

/**
 * 传输数据配置参数
 *
 * @author fjfh-wengsn
 */
public final class DataProperty {

    /**
     * 数据结构
     */
    private static DataType dataType;
    private static int longestLength;


    /**
     * 读配置
     */
    public void readProperty() {
        DataProperty.dataType = DataType.JSON;
        DataProperty.longestLength = 65535;
    }

    public void readProperty(String configFilePath) {

    }

    public static DataType getDataType() {
        return dataType;
    }

    public static int getLongestLength() {
        return longestLength;
    }

    /**
     * 传输数据格式
     */
    public enum DataType {
        JSON,
        XML,
    }

}
