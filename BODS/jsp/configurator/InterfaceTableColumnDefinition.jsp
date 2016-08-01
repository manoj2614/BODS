<%@ page language="java"%>
<%@ taglib uri="struts-html" prefix="html"%>
<%@ taglib uri="struts-bean" prefix="bean"%>
<%@ taglib uri="struts-nested" prefix="nested"%>

<html:html>
	<head>
		<link href="css/basepagemaker.css" rel='stylesheet' type='text/css' />
	</head>
	<nested:root name="configuratorForm">
		<nested:nest property="configuratorVO">
			<div id="pageContentDivId">
				<div class="div-table">
					<div class="div-table-row">
						<div class="div-table-col">
							<span> Connection </span>
						</div>
						<div class="div-table-col">
							<nested:text styleId="concurrentProgramName" property="concurrentProgramName" />
							</div>
							<div class="div-table-col">
								<span> Description </span>
							</div>
							<div class="div-table-col">
								<nested:textarea styleId="description" property="description" />
							</div>
						</div>
					</div>
					<div style="border: 1px solid red;width:60%;height:50px;left: 40px;">
						<div style="border: 3px solid red;">
							<input type="text" name="configuratorColumnName" style="width: 32%;" value="ConfiguratorColumnName">
							<input type="text" name="interfaceTableName" style="width: 32%;" value="InterfaceTableName">
							<input type="text" name="interfaceColumnName" style="width: 32%;" value="InterfaceColumnName">
						</div>
					</div>
				</div>	
			</nested:nest>
	</nested:root>
</html:html>