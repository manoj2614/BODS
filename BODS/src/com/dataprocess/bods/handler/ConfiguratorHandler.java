package com.dataprocess.bods.handler;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.json.JSONObject;

import com.dataprocess.bods.business.Configurator;
import com.dataprocess.bods.business.ConfiguratorExecutor;
import com.dataprocess.bods.util.BODSException;
import com.dataprocess.bods.vo.ConfiguratorColumnDefinitionVO;
import com.dataprocess.bods.vo.ConfiguratorInterfaceColumnVO;
import com.dataprocess.bods.vo.ConfiguratorVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ConfiguratorHandler.
 */
public final class ConfiguratorHandler {

	/**
	 * Gets the source configurator column.
	 * 
	 * @param configuratorVO
	 *            the configurator vo
	 * @return the source configurator column
	 * @throws BODSException
	 *             the bODS exception
	 */
	public ConfiguratorVO getSourceConfiguratorColumn(ConfiguratorVO configuratorVO) throws BODSException {
		List<ConfiguratorColumnDefinitionVO> configuratorColDefnList = null;
		Set<ConfiguratorColumnDefinitionVO> configuratorColumnDefinitionVOSet = null;
		Configurator configurator = null;
		try {
			configurator = new Configurator();
			configuratorColDefnList = configurator
					.getSourceConfiguratorColumn(configuratorVO.getSourceConfigurationId());
			configuratorColumnDefinitionVOSet = new HashSet<ConfiguratorColumnDefinitionVO>(configuratorColDefnList);
			configuratorVO.setConfiguratorColumnDefinitionVOSet(configuratorColumnDefinitionVOSet);
			configuratorVO.setConfiguratorColumnDefinitionVOList(configuratorColDefnList);
		} catch (BODSException bodsException) {
			throw bodsException;
		} catch (Exception exception) {
			throw new BODSException("ConfiguratorHandler", "getSourceConfiguratorColumn", exception.getMessage());
		}
		return configuratorVO;
	}

	/**
	 * Gets the interface table column info.
	 * 
	 * @param configuratorVO
	 *            the configurator vo
	 * @return the interface table column info
	 * @throws BODSException
	 *             the bODS exception
	 */
	public ConfiguratorVO getInterfaceTableColumnInfo(ConfiguratorVO configuratorVO) throws BODSException {
		Configurator configurator = null;
		List<ConfiguratorInterfaceColumnVO> configuratorInterfaceColumnVOList = null;
		try {
			configurator = new Configurator();
			configuratorInterfaceColumnVOList = configurator.getInterfaceTableColumnList(configuratorVO);
			configuratorVO.setConfiguratorInterfaceColumnVOList(configuratorInterfaceColumnVOList);
		} catch (BODSException bodsException) {
			throw bodsException;
		} catch (Exception exception) {
			throw new BODSException("ConfiguratorHandler", "getSourceConfiguratorColumn", exception.getMessage());
		}
		return configuratorVO;
	}

	/**
	 * Parses the query.
	 *
	 * @param configuratorVO
	 *            the configurator vo
	 * @return the string
	 * @throws BODSException
	 *             the bODS exception
	 */
	public JSONObject parseQuery(ConfiguratorVO configuratorVO) throws BODSException {
		String jsonString = "";
		JSONObject valueObject = null;
		Configurator configurator = null;
		try {
			configurator = new Configurator();
			jsonString = configurator.parseQuery(configuratorVO);
			valueObject = new JSONObject(jsonString);
		} catch (Exception exception) {
			throw new BODSException("ConfiguratorHandler", "getSourceConfiguratorColumn", exception.getMessage());
		}
		return valueObject;

	}

	public ArrayList<ConfiguratorVO> getConfigConnectionList() {
		ArrayList<ConfiguratorVO> configConnectionList = null;
		Configurator configurator = null;

		try {
			configurator = new Configurator();
			configConnectionList = configurator.getConfigConnectionList();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return configConnectionList;
	}

	public ArrayList<ConfiguratorVO> getSourceConfigConnectionList() {
		ArrayList<ConfiguratorVO> sourceConfigConnectionList = null;
		Configurator configurator = null;

		try {
			configurator = new Configurator();
			sourceConfigConnectionList = configurator.getSourceConfigConnectionList();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return sourceConfigConnectionList;
	}

	public ArrayList<ConfiguratorVO> getSourceConfigurationNameList() {
		ArrayList<ConfiguratorVO> sourceConfigurationNameList = null;
		Configurator configurator = null;

		try {
			configurator = new Configurator();
			sourceConfigurationNameList = configurator.getSourceConfigurationNameList();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return sourceConfigurationNameList;
	}

	public void saveConfiguratorDetails(ConfiguratorVO configuratorVO) {
		Configurator configurator = null;

		try {
			configurator = new Configurator();
			configurator.saveConfiguratorDetails(configuratorVO);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void execute(int configuratorId,int configuratorConnId) {
		ConfiguratorExecutor configuratorExecutor = null;
		try {
			configuratorExecutor = new ConfiguratorExecutor();
			configuratorExecutor.loaderStagingTableInsert(configuratorId,configuratorConnId);

		} catch (Exception exception) {

		}

	}
}
