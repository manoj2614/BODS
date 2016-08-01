package com.dataprocess.bods.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.Formula;

/**
 * The Class ConfiguratorEO.
 */
@Entity
@Table(name = "BODS_CONFIGURATOR_CFG")
public class ConfiguratorEO {

	@SequenceGenerator(name = "generator", sequenceName = "CONFIGURATOR_CFG_ID_SEQ")
	@Id
	@Column(name = "CONFIGURATOR_ID")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "generator")
    private int configuratorId;

	@Column(name = "CONFIGURATOR_CONN_ID")
	private int configuratorConnectionId;

	@Column(name = "CONFIGURATOR_NAME")
	private String configuratorName;

	@Formula("(SELECT CONN.CONNECTION_NAME FROM BODS_CONNECTION_CFG CONN WHERE CONN.CONNECTION_ID = CONFIGURATOR_CONN_ID)")
	private String configuratorConnectionName;

	@Column(name = "DISPLAY_NAME")
	private String displayName;

	@Column(name = "DESCRIPTION")
	private String description;

	@Column(name = "REDUNDANTREDUCER")
    private String redundantReducer;

	@Column(name = "CONVERSION")
    private String conversion;

    @Column(name = "SOURCE_CONFIGURATOR_CONN_ID")
    private int sourceConfigurationConnectionId;

    @Column(name = "SOURCE_CONFIGURATOR_ID")
    private int sourceConfigurationId;

   /* @Formula("(SELECT SOUR_CONN.CONNECTION_NAME FROM BODS_CONNECTION_CFG SOUR_CONN WHERE SOUR_CONN.CONNECTION_ID = SOURCE_CONFIGURATOR_CONN_ID)")
    private String sourceConfigurationConnectionName;

    @Formula("(SELECT SOURCE_CFG.SOURCE_CFG_NAME FROM BODS_SOURCE_CFG SOUR_CFG WHERE SOURCE_CFG.SOURCE_CFG_ID = SOURCE_CONFIGURATOR_ID)")
    private String sourceConfigurationName;
    */
    @Column(name = "PROCEDUREVALUE")
	private String procedureValue;
    
	@JoinColumn(name = "CONFIGURATOR_ID")
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@Fetch(FetchMode.JOIN)
	private Set<ConfiguratorColumnDefinitionEO> configuratorColumnDefinitionEOSet;
	
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
     * @param configuratorId the new configurator id
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
     * @param configuratorConnectionId the new configurator connection id
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
     * @param configuratorName the new configurator name
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
     * @param configuratorConnectionName the new configurator connection name
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
     * @param displayName the new display name
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
     * @param description the new description
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
     * @param redundantReducer the new redundant reducer
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
     * @param conversion the new conversion
     */
    public void setConversion(String conversion) {
        this.conversion = conversion;
    }

	public int getSourceConfigurationConnectionId() {
		return sourceConfigurationConnectionId;
	}

	public void setSourceConfigurationConnectionId(int sourceConfigurationConnectionId) {
		this.sourceConfigurationConnectionId = sourceConfigurationConnectionId;
	}

	public int getSourceConfigurationId() {
		return sourceConfigurationId;
	}

	public void setSourceConfigurationId(int sourceConfigurationId) {
		this.sourceConfigurationId = sourceConfigurationId;
	}

	/*public String getSourceConfigurationConnectionName() {
		return sourceConfigurationConnectionName;
	}

	public void setSourceConfigurationConnectionName(String sourceConfigurationConnectionName) {
		this.sourceConfigurationConnectionName = sourceConfigurationConnectionName;
	}

	public String getSourceConfigurationName() {
		return sourceConfigurationName;
	}

	public void setSourceConfigurationName(String sourceConfigurationName) {
		this.sourceConfigurationName = sourceConfigurationName;
	}*/

	public Set<ConfiguratorColumnDefinitionEO> getConfiguratorColumnDefinitionEOSet() {
		return configuratorColumnDefinitionEOSet;
	}

	public void setConfiguratorColumnDefinitionEOSet(
			Set<ConfiguratorColumnDefinitionEO> configuratorColumnDefinitionEOSet) {
		this.configuratorColumnDefinitionEOSet = configuratorColumnDefinitionEOSet;
	}

	public String getProcedureValue() {
		return procedureValue;
	}

	public void setProcedureValue(String procedureValue) {
		this.procedureValue = procedureValue;
	}
}