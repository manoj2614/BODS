package com.dataprocess.bods.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.dataprocess.bods.util.EntityProperty;

// TODO: Auto-generated Javadoc
/**
 * The Class ConfiguratorVO.
 */
public class ConfiguratorVO implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -7844236478716570078L;

	@EntityProperty(columnName = "configuratorId")
	private int configuratorId;

	@EntityProperty(columnName = "configuratorConnectionId")
	private int configuratorConnectionId;

	@EntityProperty(columnName = "configuratorName")
	private String configuratorName;

	@EntityProperty(columnName = "configuratorConnectionName")
	private String configuratorConnectionName;

	@EntityProperty(columnName = "displayName")
	private String displayName;

	@EntityProperty(columnName = "description")
	private String description;

	@EntityProperty(columnName = "redundantReducer")
	private String redundantReducer;

	@EntityProperty(columnName = "conversion")
	private String conversion;

	private ArrayList<ConfiguratorVO> sourceConfigConnectionList;

	private ArrayList<ConfiguratorVO> configConnectionList;

	private ArrayList<ConfiguratorVO> sourceConfigurationNameList;

	/* Column Definition Header Content and Column Definition */

	@EntityProperty(columnName = "sourceConfigurationConnectionId")
	private int sourceConfigurationConnectionId;

	@EntityProperty(columnName = "sourceConfigurationId")
	private int sourceConfigurationId;

	@EntityProperty(columnName = "sourceConfigurationConnectionName")
	private String sourceConfigurationConnectionName;

	@EntityProperty(columnName = "sourceConfigurationName")
	private String sourceConfigurationName;

	@EntityProperty(columnName = "procedureValue")
	private String procedureValue;
	
	/** The configurator column definition vo list. */
	private List<ConfiguratorColumnDefinitionVO> configuratorColumnDefinitionVOList;

	@EntityProperty(columnName = "configuratorColumnDefinitionEOSet", entity = "com.dataprocess.bods.entity.ConfiguratorColumnDefinitionEO")
	private Set<ConfiguratorColumnDefinitionVO> configuratorColumnDefinitionVOSet;

	/* Interface Column Definition */

	/** The interface table name. */
	private String interfaceTableName;

	/** The configurator interface column vo list. */
	private List<ConfiguratorInterfaceColumnVO> configuratorInterfaceColumnVOList;

	/* Concurrent Program Definition */

	/** The concurrent program name. */
	private String concurrentProgramName;

	/** The concurrent parameter vo list. */
	private List<ConcurrentParameterVO> concurrentParameterVOList;

	/* Interface Column Mapped List */
	/** The configurator mapped column vo list. */
	private List<ConfiguratorMappedColumnVO> configuratorMappedColumnVOList;

	/* Validation Process Definition */

	/** The current configurator validation vo. */
	private ConfiguratorValidationVO configuratorValidationVO;

	/** The configurator validation vo list. */
	private List<ConfiguratorValidationVO> configuratorValidationVOList;
	
	
	public ConfiguratorVO() {
	    configuratorValidationVO = new ConfiguratorValidationVO();
	}
	

	/**
	 * Gets the configurator id.
	 * 
	 * @return the configurator id
	 */
	public int getConfiguratorId() {
		return configuratorId;
	}

	/**
	 * Sets the configurator id.
	 * 
	 * @param configuratorId
	 *            the new configurator id
	 */
	public void setConfiguratorId(int configuratorId) {
		this.configuratorId = configuratorId;
	}

	/**
	 * Gets the configurator connection id.
	 * 
	 * @return the configurator connection id
	 */
	public int getConfiguratorConnectionId() {
		return configuratorConnectionId;
	}

	/**
	 * Sets the configurator connection id.
	 * 
	 * @param configuratorConnectionId
	 *            the new configurator connection id
	 */
	public void setConfiguratorConnectionId(int configuratorConnectionId) {
		this.configuratorConnectionId = configuratorConnectionId;
	}

	/**
	 * Gets the configurator name.
	 * 
	 * @return the configurator name
	 */
	public String getConfiguratorName() {
		return configuratorName;
	}

	/**
	 * Sets the configurator name.
	 * 
	 * @param configuratorName
	 *            the new configurator name
	 */
	public void setConfiguratorName(String configuratorName) {
		this.configuratorName = configuratorName;
	}

	/**
	 * Gets the configurator connection name.
	 * 
	 * @return the configurator connection name
	 */
	public String getConfiguratorConnectionName() {
		return configuratorConnectionName;
	}

	/**
	 * Sets the configurator connection name.
	 * 
	 * @param configuratorConnectionName
	 *            the new configurator connection name
	 */
	public void setConfiguratorConnectionName(String configuratorConnectionName) {
		this.configuratorConnectionName = configuratorConnectionName;
	}

	/**
	 * Gets the display name.
	 * 
	 * @return the display name
	 */
	public String getDisplayName() {
		return displayName;
	}

	/**
	 * Sets the display name.
	 * 
	 * @param displayName
	 *            the new display name
	 */
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	/**
	 * Gets the description.
	 * 
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Sets the description.
	 * 
	 * @param description
	 *            the new description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Gets the redundant reducer.
	 * 
	 * @return the redundant reducer
	 */
	public String getRedundantReducer() {
		return redundantReducer;
	}

	/**
	 * Sets the redundant reducer.
	 * 
	 * @param redundantReducer
	 *            the new redundant reducer
	 */
	public void setRedundantReducer(String redundantReducer) {
		this.redundantReducer = redundantReducer;
	}

	/**
	 * Gets the conversion.
	 * 
	 * @return the conversion
	 */
	public String getConversion() {
		return conversion;
	}

	/**
	 * Sets the conversion.
	 * 
	 * @param conversion
	 *            the new conversion
	 */
	public void setConversion(String conversion) {
		this.conversion = conversion;
	}

	/**
	 * Gets the source configuration connection id.
	 * 
	 * @return the source configuration connection id
	 */
	public int getSourceConfigurationConnectionId() {
		return sourceConfigurationConnectionId;
	}

	/**
	 * Sets the source configuration connection id.
	 * 
	 * @param sourceConfigurationConnectionId
	 *            the new source configuration connection id
	 */
	public void setSourceConfigurationConnectionId(int sourceConfigurationConnectionId) {
		this.sourceConfigurationConnectionId = sourceConfigurationConnectionId;
	}

	/**
	 * Gets the source configuration id.
	 * 
	 * @return the source configuration id
	 */
	public int getSourceConfigurationId() {
		return sourceConfigurationId;
	}

	/**
	 * Sets the source configuration id.
	 * 
	 * @param sourceConfigurationId
	 *            the new source configuration id
	 */
	public void setSourceConfigurationId(int sourceConfigurationId) {
		this.sourceConfigurationId = sourceConfigurationId;
	}

	/**
	 * Gets the source configuration connection name.
	 * 
	 * @return the source configuration connection name
	 */
	public String getSourceConfigurationConnectionName() {
		return sourceConfigurationConnectionName;
	}

	/**
	 * Sets the source configuration connection name.
	 * 
	 * @param sourceConfigurationConnectionName
	 *            the new source configuration connection name
	 */
	public void setSourceConfigurationConnectionName(String sourceConfigurationConnectionName) {
		this.sourceConfigurationConnectionName = sourceConfigurationConnectionName;
	}

	/**
	 * Gets the source configuration name.
	 * 
	 * @return the source configuration name
	 */
	public String getSourceConfigurationName() {
		return sourceConfigurationName;
	}

	/**
	 * Sets the source configuration name.
	 * 
	 * @param sourceConfigurationName
	 *            the new source configuration name
	 */
	public void setSourceConfigurationName(String sourceConfigurationName) {
		this.sourceConfigurationName = sourceConfigurationName;
	}

	/**
	 * Gets the configurator column definition vo list.
	 * 
	 * @return the configurator column definition vo list
	 */
	public List<ConfiguratorColumnDefinitionVO> getConfiguratorColumnDefinitionVOList() {
		return configuratorColumnDefinitionVOList;
	}

	/**
	 * Sets the configurator column definition vo list.
	 * 
	 * @param configuratorColumnDefinitionVOList
	 *            the new configurator column definition vo list
	 */
	public void setConfiguratorColumnDefinitionVOList(
			List<ConfiguratorColumnDefinitionVO> configuratorColumnDefinitionVOList) {
		this.configuratorColumnDefinitionVOList = configuratorColumnDefinitionVOList;
	}

	public Set<ConfiguratorColumnDefinitionVO> getConfiguratorColumnDefinitionVOSet() {
		return configuratorColumnDefinitionVOSet;
	}

	public void setConfiguratorColumnDefinitionVOSet(
			Set<ConfiguratorColumnDefinitionVO> configuratorColumnDefinitionVOSet) {
		this.configuratorColumnDefinitionVOSet = configuratorColumnDefinitionVOSet;
	}

	/**
	 * Gets the interface table name.
	 * 
	 * @return the interface table name
	 */
	public String getInterfaceTableName() {
		return interfaceTableName;
	}

	/**
	 * Sets the interface table name.
	 * 
	 * @param interfaceTableName
	 *            the new interface table name
	 */
	public void setInterfaceTableName(String interfaceTableName) {
		this.interfaceTableName = interfaceTableName;
	}

	/**
	 * Gets the configurator interface column vo list.
	 * 
	 * @return the configurator interface column vo list
	 */
	public List<ConfiguratorInterfaceColumnVO> getConfiguratorInterfaceColumnVOList() {
		return configuratorInterfaceColumnVOList;
	}

	/**
	 * Sets the configurator interface column vo list.
	 * 
	 * @param configuratorInterfaceColumnVOList
	 *            the new configurator interface column vo list
	 */
	public void setConfiguratorInterfaceColumnVOList(
			List<ConfiguratorInterfaceColumnVO> configuratorInterfaceColumnVOList) {
		this.configuratorInterfaceColumnVOList = configuratorInterfaceColumnVOList;
	}

	/**
	 * Gets the concurrent program name.
	 * 
	 * @return the concurrent program name
	 */
	public String getConcurrentProgramName() {
		return concurrentProgramName;
	}

	/**
	 * Sets the concurrent program name.
	 * 
	 * @param concurrentProgramName
	 *            the new concurrent program name
	 */
	public void setConcurrentProgramName(String concurrentProgramName) {
		this.concurrentProgramName = concurrentProgramName;
	}

	/**
	 * Gets the concurrent parameter vo list.
	 * 
	 * @return the concurrent parameter vo list
	 */
	public List<ConcurrentParameterVO> getConcurrentParameterVOList() {
		return concurrentParameterVOList;
	}

	/**
	 * Sets the concurrent parameter vo list.
	 * 
	 * @param concurrentParameterVOList
	 *            the new concurrent parameter vo list
	 */
	public void setConcurrentParameterVOList(List<ConcurrentParameterVO> concurrentParameterVOList) {
		this.concurrentParameterVOList = concurrentParameterVOList;
	}

	/**
	 * Gets the configurator mapped column vo list.
	 * 
	 * @return the configurator mapped column vo list
	 */
	public List<ConfiguratorMappedColumnVO> getConfiguratorMappedColumnVOList() {
		return configuratorMappedColumnVOList;
	}

	/**
	 * Sets the configurator mapped column vo list.
	 * 
	 * @param configuratorMappedColumnVOList
	 *            the new configurator mapped column vo list
	 */
	public void setConfiguratorMappedColumnVOList(List<ConfiguratorMappedColumnVO> configuratorMappedColumnVOList) {
		this.configuratorMappedColumnVOList = configuratorMappedColumnVOList;
	}

	/**
	 * Gets the configurator validation vo list.
	 *
	 * @return the configurator validation vo list
	 */
	public List<ConfiguratorValidationVO> getConfiguratorValidationVOList() {
		return configuratorValidationVOList;
	}


	/**
	 * Sets the configurator validation vo list.
	 *
	 * @param configuratorValidationVOList
	 *            the new configurator validation vo list
	 */
	public void setConfiguratorValidationVOList(List<ConfiguratorValidationVO> configuratorValidationVOList) {
		this.configuratorValidationVOList = configuratorValidationVOList;
	}

	public ArrayList<ConfiguratorVO> getConfigConnectionList() {
		return configConnectionList;
	}

	public void setConfigConnectionList(ArrayList<ConfiguratorVO> configConnectionList) {
		this.configConnectionList = configConnectionList;
	}

	public ArrayList<ConfiguratorVO> getSourceConfigConnectionList() {
		return sourceConfigConnectionList;
	}

	public void setSourceConfigConnectionList(ArrayList<ConfiguratorVO> sourceConfigConnectionList) {
		this.sourceConfigConnectionList = sourceConfigConnectionList;
	}

	public ArrayList<ConfiguratorVO> getSourceConfigurationNameList() {
		return sourceConfigurationNameList;
	}

	public void setSourceConfigurationNameList(ArrayList<ConfiguratorVO> sourceConfigurationNameList) {
		this.sourceConfigurationNameList = sourceConfigurationNameList;
	}

	public String getProcedureValue() {
		return procedureValue;
	}

	public void setProcedureValue(String procedureValue) {
		this.procedureValue = procedureValue;
	}

    public ConfiguratorValidationVO getConfiguratorValidationVO() {
        return configuratorValidationVO;
    }

    public void setConfiguratorValidationVO(ConfiguratorValidationVO configuratorValidationVO) {
        this.configuratorValidationVO = configuratorValidationVO;
    }
}