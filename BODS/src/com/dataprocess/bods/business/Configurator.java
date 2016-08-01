package com.dataprocess.bods.business;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.json.JSONObject;

import com.dataprocess.bods.dao.ConfiguratorDAO;
import com.dataprocess.bods.dao.ConfiguratorValidationDAO;
import com.dataprocess.bods.entity.ConfiguratorEO;
import com.dataprocess.bods.entity.QueryDefinitionEO;
import com.dataprocess.bods.util.BODSException;
import com.dataprocess.bods.util.SpringBeanUtils;
import com.dataprocess.bods.util.connectionutil.TargetSchemaConnection;
import com.dataprocess.bods.vo.ConfiguratorColumnDefinitionVO;
import com.dataprocess.bods.vo.ConfiguratorInterfaceColumnVO;
import com.dataprocess.bods.vo.ConfiguratorVO;
import com.dataprocess.bods.vo.QueryDefinitionLineVO;
import com.dataprocess.bods.vo.QueryDefinitionVO;

// TODO: Auto-generated Javadoc
/**
 * The Class Configurator.
 */
public final class Configurator {

	/**
	 * Gets the source configurator column.
	 * 
	 * @param sourceConfiguratorId
	 *            the source configurator id
	 * @return the source configurator column
	 * @throws BODSException
	 *             the bODS exception
	 */
	public List<ConfiguratorColumnDefinitionVO> getSourceConfiguratorColumn(int sourceConfiguratorId)
			throws BODSException {
		QueryDefinitionVO queryDefinitionVO = null;
		List<ConfiguratorColumnDefinitionVO> configuratorColDefnList = null;
		QueryDefinitionEO queryDefinitionEO = null;
		ConfiguratorDAO configuratorDAO = null;
		try {
			queryDefinitionVO = new QueryDefinitionVO();
			configuratorDAO = new ConfiguratorDAO();
			queryDefinitionEO = configuratorDAO.getSourceConfigurator(sourceConfiguratorId);
			queryDefinitionVO = (QueryDefinitionVO) new SpringBeanUtils().populateToDTOObject(queryDefinitionEO,
					queryDefinitionVO);
			configuratorColDefnList = fillConfiguratorColumnDefinitionVOList(
					queryDefinitionVO.getSourceConfiguratorLineVOSet());

		} catch (BODSException bodsException) {
			throw bodsException;
		} catch (Exception exception) {
			throw new BODSException("Configurator", "getSourceConfiguratorColumn", exception.getMessage());
		}
		return configuratorColDefnList;
	}

	/**
	 * Fill configurator column definition vo list.
	 * 
	 * @param sourceConfiguratorLineVO
	 *            the source configurator line vo
	 * @return the list
	 * @throws BODSException
	 *             the bODS exception
	 */
	private List<ConfiguratorColumnDefinitionVO> fillConfiguratorColumnDefinitionVOList(
			Set<QueryDefinitionLineVO> queryDefinitionLineVO) throws BODSException {
		ConfiguratorColumnDefinitionVO configuratorColumnDefinitionVO = null;
		List<ConfiguratorColumnDefinitionVO> configuratorColDefnList = null;
		try {
			configuratorColDefnList = new ArrayList<>();
			for (QueryDefinitionLineVO sourceConfiguratorLineVO1 : queryDefinitionLineVO) {
				configuratorColumnDefinitionVO = new ConfiguratorColumnDefinitionVO();
				configuratorColumnDefinitionVO.setColumnName(sourceConfiguratorLineVO1.getColumnName());
				configuratorColumnDefinitionVO.setColumnId(sourceConfiguratorLineVO1.getSourceConfiguratorLineId());
				configuratorColumnDefinitionVO.setDataType(sourceConfiguratorLineVO1.getDataType());
				configuratorColumnDefinitionVO.setConversionColumn(sourceConfiguratorLineVO1.getConversionColumn());
				configuratorColumnDefinitionVO.setMandatory(sourceConfiguratorLineVO1.getColumnMandatoryFlag());
				configuratorColumnDefinitionVO.setUnique(sourceConfiguratorLineVO1.getColumnUniqueFlag());
				configuratorColDefnList.add(configuratorColumnDefinitionVO);
			}
		} catch (Exception exception) {
			throw new BODSException("Configurator", "fillConfiguratorColumnDefinitionVOList", exception.getMessage());
		}
		return configuratorColDefnList;

	}

	/**
	 * Gets the interface table column list.
	 * 
	 * @param configuratorVO
	 *            the configurator vo
	 * @return the interface table column list
	 * @throws BODSException
	 *             the bODS exception
	 */
	public List<ConfiguratorInterfaceColumnVO> getInterfaceTableColumnList(ConfiguratorVO configuratorVO)
			throws BODSException {
		ConfiguratorDAO configuratorDAO = null;
		List<ConfiguratorInterfaceColumnVO> configuratorInterfaceColumnVOList = null;
		try {
			configuratorDAO = new ConfiguratorDAO();
			configuratorInterfaceColumnVOList = configuratorDAO.getInterfaceTableColumnList(
					configuratorVO.getConfiguratorConnectionId(), configuratorVO.getInterfaceTableName());
		} catch (BODSException bodsException) {
			throw bodsException;
		} catch (Exception exception) {
			throw new BODSException("Configurator", "getInterfaceTableColumnList", exception.getMessage());
		}
		return configuratorInterfaceColumnVOList;
	}

	/**
	 * Creates the staging table.
	 * 
	 * @param configuratorVO
	 *            the configurator vo
	 * @throws BODSException
	 *             the bODS exception
	 */
	public void createStagingTable(ConfiguratorVO configuratorVO) throws BODSException {
		String stagingTableScript = "";
		String tableName = "";
		ConfiguratorDAO configuratorDAO = null;
		try {
			configuratorDAO = new ConfiguratorDAO();
			tableName = "STG_" + configuratorVO.getConfiguratorConnectionId() + "_"
					+ configuratorVO.getConfiguratorId();
			stagingTableScript = "CREATE TABLE " + tableName;
			stagingTableScript += getColumnList(configuratorVO.getConfiguratorColumnDefinitionVOList());
			configuratorDAO.createStagingTable(configuratorVO.getConfiguratorConnectionId(), stagingTableScript,
					tableName);
		} catch (BODSException bodsException) {
			throw bodsException;
		} catch (Exception exception) {
			throw new BODSException("Configurator", "getInterfaceTableColumnList", exception.getMessage());
		}
	}

	/**
	 * Gets the column list.
	 * 
	 * @param configuratorColumnDefinitionVOList
	 *            the configurator column definition vo list
	 * @return the column list
	 * @throws BODSException
	 *             the bODS exception
	 */
	private String getColumnList(List<ConfiguratorColumnDefinitionVO> configuratorColumnDefinitionVOList)
			throws BODSException {
		int index = 0;
		String columnName = "";
		String finalColumnName = "";
		try {
			for (ConfiguratorColumnDefinitionVO configuratorColumnDefinitionVO : configuratorColumnDefinitionVOList) {
				if (index == 0) {
					if ("String".equalsIgnoreCase(configuratorColumnDefinitionVO.getDataType())) {
						columnName = configuratorColumnDefinitionVO.getColumnName() + " VARCHAR2(2000) ";
					} else {
						columnName = configuratorColumnDefinitionVO.getColumnName() + " "
								+ configuratorColumnDefinitionVO.getDataType();
					}
				} else {
					if ("String".equalsIgnoreCase(configuratorColumnDefinitionVO.getDataType())) {
						columnName += ", " + configuratorColumnDefinitionVO.getColumnName() + " VARCHAR2(2000) ";
					} else {
						columnName += ", " + configuratorColumnDefinitionVO.getColumnName() +" "
								+ configuratorColumnDefinitionVO.getDataType();
					}
				}
				index++;
			}
			finalColumnName = " ( " + columnName + " ) ";
		} catch (Exception exception) {
			throw new BODSException("Configurator", "getInterfaceTableColumnList", exception.getMessage());
		}
		return finalColumnName;
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
	public String parseQuery(ConfiguratorVO configuratorVO) throws BODSException {
		int connectionId = 0;
		String prevalidationQuery = "";
		String prevalidationType = "";
		String jsonString = "";
		JSONObject valueObject = null;
		JSONObject oracleValidationVOJSON = null;
		Connection connection = null;
		TargetSchemaConnection targetSchemaConnection = null;
		ConfiguratorValidationDAO configuratorValidationDAO = null;
		List<String> referenceColumnNameList = null;
		try {
			valueObject = new JSONObject();
			configuratorValidationDAO = new ConfiguratorValidationDAO();
			targetSchemaConnection = new TargetSchemaConnection();
			connection = targetSchemaConnection.getTargetSchemaConnection(connectionId);
			prevalidationType = configuratorVO.getCurrentConfiguratorValidationVO().getType();
			referenceColumnNameList = configuratorValidationDAO.parseQuery(connection, prevalidationType,
					prevalidationQuery);
			valueObject.append("queryColumnNameList", referenceColumnNameList);
			valueObject.append("configuratorColumnVOList", configuratorVO.getConfiguratorColumnDefinitionVOList());
			oracleValidationVOJSON = new JSONObject();
			oracleValidationVOJSON.put("configuratorVO", valueObject);
			jsonString = oracleValidationVOJSON.toString();
		} catch (BODSException bodsException) {
			throw bodsException;
		} catch (Exception exception) {
			throw new BODSException("Configurator", "parseQuery", exception.getMessage());
		}
		return jsonString;
	}

	public ArrayList<ConfiguratorVO> getConfigConnectionList() {
		ArrayList<ConfiguratorVO> configConnectionList = null;
		ConfiguratorDAO configuratorDAO = null;

		try {
			configuratorDAO = new ConfiguratorDAO();
			configConnectionList = configuratorDAO.getConfigConnectionList();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return configConnectionList;
	}

	public ArrayList<ConfiguratorVO> getSourceConfigConnectionList() {
		ArrayList<ConfiguratorVO> sourceConfigConnectionList = null;
		ConfiguratorDAO configuratorDAO = null;

		try {
			configuratorDAO = new ConfiguratorDAO();
			sourceConfigConnectionList = configuratorDAO.getSourceConfigConnectionList();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return sourceConfigConnectionList;
	}

	public ArrayList<ConfiguratorVO> getSourceConfigurationNameList() {
		ArrayList<ConfiguratorVO> sourceConfigurationNameList = null;
		ConfiguratorDAO configuratorDAO = null;

		try {
			configuratorDAO = new ConfiguratorDAO();
			sourceConfigurationNameList = configuratorDAO.getSourceConfigurationNameList();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return sourceConfigurationNameList;
	}

	public void saveConfiguratorDetails(ConfiguratorVO configuratorVO) {
		String procedureValue = "";
		ConfiguratorDAO configuratorDAO = null;
		SpringBeanUtils beanUtils = null;
		ConfiguratorEO configuratorEO = null;
		ConfiguratorProcedureCreation configuratorProcedureCreation = null;

		try {
			beanUtils = new SpringBeanUtils();
			configuratorDAO = new ConfiguratorDAO();
			configuratorProcedureCreation = new ConfiguratorProcedureCreation();
			configuratorEO = new ConfiguratorEO();
			procedureValue = configuratorProcedureCreation.createStagingProcedure(configuratorVO);
			configuratorEO = (ConfiguratorEO) beanUtils.populateToEntityObject(configuratorVO, configuratorEO);
			System.out.println("Procedure Value : " + procedureValue);
			configuratorEO.setProcedureValue(procedureValue);
			configuratorEO  = configuratorDAO.saveConfiguratorDetails(configuratorEO);
			if (configuratorEO.getConfiguratorId() > 0) {
				configuratorVO.setConfiguratorId(configuratorEO.getConfiguratorId());
				createStagingTable(configuratorVO);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
