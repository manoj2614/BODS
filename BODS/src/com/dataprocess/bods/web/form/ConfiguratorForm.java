package com.dataprocess.bods.web.form;

import org.apache.struts.action.ActionForm;

import com.dataprocess.bods.vo.ConfiguratorVO;

public class ConfiguratorForm extends ActionForm {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8478746882959582363L;
	private ConfiguratorVO configuratorVO;

	public ConfiguratorForm() {
		configuratorVO = new ConfiguratorVO();
	}

	public ConfiguratorVO getConfiguratorVO() {
		return configuratorVO;
	}

	public void setConfiguratorVO(ConfiguratorVO configuratorVO) {
		this.configuratorVO = configuratorVO;
	}
}
