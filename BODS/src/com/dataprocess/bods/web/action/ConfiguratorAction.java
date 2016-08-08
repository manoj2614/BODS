package com.dataprocess.bods.web.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.json.JSONObject;

import com.dataprocess.bods.handler.ConfiguratorHandler;
import com.dataprocess.bods.vo.ConfiguratorVO;
import com.dataprocess.bods.web.form.ConfiguratorForm;

// TODO: Auto-generated Javadoc
/**
 * The Class ConfiguratorAction.
 */
public final class ConfiguratorAction extends Action {

    /*
     * (non-Javadoc)
     * @see org.apache.struts.action.Action#execute(org.apache.struts.action. ActionMapping,
     * org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest,
     * javax.servlet.http.HttpServletResponse)
     */
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
        HttpServletResponse response) throws Exception {
        JSONObject convertedJson = null;
        JSONObject valueObject = new JSONObject();
        String forwardName = "forward.success";
        ConfiguratorForm configuratorForm = (ConfiguratorForm) form;
        ConfiguratorHandler configuratorHandler = null;
        ConfiguratorVO configuratorVO = null;
        PrintWriter printWriter = null;

        if (mapping.getPath().equals("/ConfiguratorLaunch")) {
            configuratorHandler = new ConfiguratorHandler();
            configuratorForm.setConfiguratorVO(new ConfiguratorVO());
            configuratorForm.getConfiguratorVO().setConfigConnectionList(configuratorHandler.getConfigConnectionList());

        } else if (mapping.getPath().equals("/ConfiguratorColumnDefinition")) {
            configuratorHandler = new ConfiguratorHandler();
            configuratorVO = configuratorForm.getConfiguratorVO();
            configuratorForm.getConfiguratorVO().setSourceConfigConnectionList(
                configuratorHandler.getSourceConfigConnectionList());
            configuratorForm.getConfiguratorVO().setSourceConfigurationNameList(
                configuratorHandler.getSourceConfigurationNameList());
            if (configuratorVO.getSourceConfigurationId() > 0) {
                configuratorHandler.getSourceConfiguratorColumn(configuratorVO);
                configuratorForm.setConfiguratorVO(configuratorVO);
            }
        } else if (mapping.getPath().equals("")) {

        } else if (mapping.getPath().equals("/InterfaceColumnMapping")) {

        } else if (mapping.getPath().equals("/ConfiguratorSaveMapping")) {
            configuratorHandler = new ConfiguratorHandler();
            configuratorVO = configuratorForm.getConfiguratorVO();
            configuratorHandler.saveConfiguratorDetails(configuratorVO);

        } else if (mapping.getPath().equals("/ValidationLaunch")) {

        } else if (mapping.getPath().equals("/QueryValidationMapping")) {
            configuratorHandler = new ConfiguratorHandler();
            configuratorVO = configuratorForm.getConfiguratorVO();
            convertedJson = configuratorHandler.parseQuery(configuratorVO);
            valueObject.put("convertedJson", convertedJson);
            printWriter = response.getWriter();
            printWriter.print(valueObject.get("convertedJson").toString());
            printWriter.flush();
            printWriter.close();
            forwardName = null;
        } else if (mapping.getPath().equals("/ValidationSaveMapping")) {

        } else if (mapping.getPath().equals("/ConfiguratorExecuteMapping")) {
            int configuratorConnId = Integer.parseInt(request.getParameter("configuratorConnId"));
            int configuratorId = Integer.parseInt(request.getParameter("configuratorId"));
            configuratorHandler = new ConfiguratorHandler();
            configuratorHandler.execute(configuratorId, configuratorConnId);
        }
        return mapping.findForward(forwardName);
    }
}
