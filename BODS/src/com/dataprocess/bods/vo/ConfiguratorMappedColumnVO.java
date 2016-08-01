package com.dataprocess.bods.vo;

/**
 * The Class ConfiguratorMappedColumnVO.
 */
public final class ConfiguratorMappedColumnVO {

    /** The source column name. */
    private String sourceColumnName;

    /** The source data type. */
    private String sourceDataType;

    /** The Target column name. */
    private String targetColumnName;

    /** The target data type. */
    private String targetDataType;

    /**
     * Gets the source column name.
     * 
     * @return the source column name
     */
    public String getSourceColumnName() {
        return sourceColumnName;
    }

    /**
     * Sets the source column name.
     * 
     * @param sourceColumnName the new source column name
     */
    public void setSourceColumnName(String sourceColumnName) {
        this.sourceColumnName = sourceColumnName;
    }

    /**
     * Gets the source data type.
     * 
     * @return the source data type
     */
    public String getSourceDataType() {
        return sourceDataType;
    }

    /**
     * Sets the source data type.
     * 
     * @param sourceDataType the new source data type
     */
    public void setSourceDataType(String sourceDataType) {
        this.sourceDataType = sourceDataType;
    }

    /**
     * Gets the target column name.
     * 
     * @return the target column name
     */
    public String getTargetColumnName() {
        return targetColumnName;
    }

    /**
     * Sets the target column name.
     * 
     * @param targetColumnName the new target column name
     */
    public void setTargetColumnName(String targetColumnName) {
        this.targetColumnName = targetColumnName;
    }

    /**
     * Gets the target data type.
     * 
     * @return the target data type
     */
    public String getTargetDataType() {
        return targetDataType;
    }

    /**
     * Sets the target data type.
     * 
     * @param targetDataType the new target data type
     */
    public void setTargetDataType(String targetDataType) {
        this.targetDataType = targetDataType;
    }

}
