package com.dataprocess.bods.business;

import java.util.List;

import com.dataprocess.bods.util.BODSException;
import com.dataprocess.bods.vo.ConfiguratorColumnDefinitionVO;
import com.dataprocess.bods.vo.ConfiguratorVO;

/**
 * The Class ConfiguratorProcedureCreation.
 */
public final class ConfiguratorProcedureCreation {

    /**
     * Creates the staging procedure.
     * 
     * @param configuratorVO the configurator vo
     * @return the string
     * @throws BODSException the bODS exception
     */
    public void createStagingProcedure(ConfiguratorVO configuratorVO) throws BODSException {
        String procedureValue = "";
        StringBuffer procedureContent = null;
        try {
            procedureContent = new StringBuffer();
            variableDeclareBlock(procedureContent, configuratorVO);
            procedureValue = procedureContent.toString();
            configuratorVO.setProcedureValue(procedureValue);
        } catch (BODSException bodsException) {
            throw bodsException;
        } catch (Exception exception) {
            throw new BODSException("ConfiguratorProcedureCreation", "getSourceConfigurator", exception.getMessage());
        }
    }

    /**
     * Creates the validation procedure.
     *
     * @param configuratorVO the configurator vo
     * @return the string
     * @throws BODSException the bODS exception
     */
    public String createValidationProcedure(ConfiguratorVO configuratorVO) throws BODSException {
        StringBuffer procedureContent = null;
        try {
            procedureContent = new StringBuffer();
            buildValidationMergeBlock(procedureContent, configuratorVO);
        } catch (BODSException bodsException) {
            throw bodsException;
        } catch (Exception exception) {
            throw new BODSException("ConfiguratorProcedureCreation", "createValidationProcedure",
                exception.getMessage());
        }
        return procedureContent.toString();
    }

    /**
     * Builds the validation merge block.
     *
     * @param procedureContent the procedure content
     * @param configuratorVO the configurator vo
     * @throws BODSException the bODS exception
     */
    private void buildValidationMergeBlock(StringBuffer procedureContent, ConfiguratorVO configuratorVO)
        throws BODSException {
        try {

        } catch (Exception exception) {
            throw new BODSException("ConfiguratorProcedureCreation", "buildValidationMergeBlock",
                exception.getMessage());
        }
    }

    /**
     * Variable declare block.
     * 
     * @param procedureContent the procedure content
     * @param configuratorVO the configurator vo
     * @throws BODSException the bODS exception
     */
    private void variableDeclareBlock(StringBuffer procedureContent, ConfiguratorVO configuratorVO)
        throws BODSException {
        String stagingTable = "";
        List<ConfiguratorColumnDefinitionVO> configuratorColumnDefinitionVOList = null;
        try {
            stagingTable =
                "STG_" + configuratorVO.getConfiguratorConnectionId() + "_" + configuratorVO.getConfiguratorId();
            configuratorColumnDefinitionVOList = configuratorVO.getConfiguratorColumnDefinitionVOList();
            procedureContent.append(" DECLARE \n");
            for (ConfiguratorColumnDefinitionVO configuratorColumnDefinitionVO : configuratorColumnDefinitionVOList) {
                if ("String".equalsIgnoreCase(configuratorColumnDefinitionVO.getDataType())) {
                    procedureContent.append(configuratorColumnDefinitionVO.getColumnName() + "_L"
                        + " VARCHAR2(2000); \n");
                } else {
                    procedureContent.append(configuratorColumnDefinitionVO.getColumnName() + "_L "
                        + configuratorColumnDefinitionVO.getDataType() + "; \n");
                }
            }
            buildProcedureBlock(stagingTable, procedureContent, configuratorColumnDefinitionVOList);
        } catch (BODSException bodsException) {
            throw bodsException;
        } catch (Exception exception) {
            throw new BODSException("ConfiguratorProcedureCreation", "variableDeclareBlock", exception.getMessage());
        }
    }

    /**
     * Builds the procedure block.
     * 
     * @param stagingTable the staging table
     * @param procedureContent the procedure content
     * @param configuratorColumnDefinitionVOList the configurator column definition vo list
     * @throws BODSException the bODS exception
     */
    private void buildProcedureBlock(String stagingTable, StringBuffer procedureContent,
        List<ConfiguratorColumnDefinitionVO> configuratorColumnDefinitionVOList) throws BODSException {
        int index = 0;
        int curIndex = 0;
        String columnName = "";
        String columnValue = "";
        try {
            procedureContent.append(" CURSOR BODS \n");
            procedureContent.append(" IS \n");
            for (ConfiguratorColumnDefinitionVO configuratorColumnDefinitionVO : configuratorColumnDefinitionVOList) {
                if (index == 0) {
                    procedureContent.append(" SELECT BODS." + configuratorColumnDefinitionVO.getColumnName() + "\n");
                } else {
                    procedureContent.append(" , BODS." + configuratorColumnDefinitionVO.getColumnName() + "\n");
                }
                index++;
            }
            procedureContent.append(" FROM ##stagingTableName## BODS ; \n");
            procedureContent.append(" BEGIN \n");
            procedureContent.append(" FOR CUR_BODS IN BODS \n");
            procedureContent.append(" LOOP \n");
            for (ConfiguratorColumnDefinitionVO configuratorColumnDefinitionVO : configuratorColumnDefinitionVOList) {
                if (curIndex == 0) {
                    columnName += configuratorColumnDefinitionVO.getColumnName();
                    columnValue += configuratorColumnDefinitionVO.getColumnName() + "_L";
                } else {
                    columnName += ", " + configuratorColumnDefinitionVO.getColumnName();
                    columnValue += ", " + configuratorColumnDefinitionVO.getColumnName() + "_L";
                }
                procedureContent.append(configuratorColumnDefinitionVO.getColumnName() + "_L := CUR_BODS."
                    + configuratorColumnDefinitionVO.getColumnName() + "; \n");
                curIndex++;
            }
            procedureContent.append(" BEGIN \n");
            procedureContent.append(" INSERT INTO \n");
            procedureContent.append(" BODS_EMP_DEPT (" + columnName + ") \n");
            procedureContent.append(" VALUES (" + columnValue + "); \n");
            procedureContent.append(" COMMIT ; \n");
            procedureContent.append(" END ; \n");
            procedureContent.append(" END LOOP; \n");
            procedureContent.append(" END ; \n");
        } catch (Exception exception) {
            throw new BODSException("ConfiguratorProcedureCreation", "cursorDeclareBlock", exception.getMessage());
        }
    }
}
