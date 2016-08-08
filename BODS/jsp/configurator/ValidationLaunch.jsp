<%@ page language="java" %><%@ taglib uri="struts-html" prefix="html"%>
<%@ taglib uri="struts-bean" prefix="bean"%>
<%@ taglib uri="struts-nested" prefix="nested"%>

<script>
	var queryColumnNameArr;
	var configuratorColumnVOArr;
	function callSubmit() {
		document.configuratorForm.action='/bods/ValidationSaveMapping.etl';
		document.configuratorForm.submit();
	}
	
	function doNextProcess() {
		document.configuratorForm.action='/bods/TargetColumnMappingLaunch.etl';
		document.configuratorForm.submit();
	}
	
	$(document).ready(function() {
		$('#queryParserId').click(function() {
			invokeQueryParse();
		})
	});
	
	function invokeQueryParse() {
		$.ajax({
			 async : false,
			 type: "POST",
		     dataType: "text",
		     url: "/bods/QueryValidationMapping.etl",
		     success: function(data) {
		    	 console.log(data);
		    	 var conditionVO = $.parseJSON(data);
		    	 queryColumnNameArr = conditionVO.configuratorVO.queryColumnNameList;
		    	 configuratorColumnVOArr = conditionVO.configuratorVO.configuratorColumnVOList;
		    	 //dynamicQueryColumnFormation();
		     }, error: function(xhr, status, error) {
		            console.log(xhr);
		            console.log(status);
		            console.log(error);
		       }
		})
	}
	
	
</script>
<html:html>
<head>
	<link href="css/basepagemaker.css" rel='stylesheet' type='text/css' />
</head>
	<nested:root name="configuratorForm">
		<nested:form styleId="configuratorForm1" action="/ValidationSaveMapping.etl">
			<nested:nest property="configuratorVO">
				<nested:nest property="configuratorValidationVO">
					<div id="pageContentDivId" style="visibility:visible;height:400px;width:100%;overflow-y: scroll;position:relative">
						<div class="div-table">
							<div class="div-table-row">
								<div class="div-table-col">
									<span> Validation Name </span>
								</div>
								<div class="div-table-col">
									<nested:text property="name"/>
								</div>
								<div class="div-table-col">
									<span> Display Name </span>
								</div>
								<div class="div-table-col">
									<nested:text property="displayName"/>	
								</div>
							</div>
							
							<div class="div-table-row">
								<div class="div-table-col">
									<span> Validation Inference </span>
								</div>
								<div class="div-table-col">
									<nested:radio property="validationInference" value="Success"> &nbsp; Success </nested:radio> &nbsp;
									<nested:radio property="validationInference" value="Error"> &nbsp; Error </nested:radio>
								</div>
								<div class="div-table-col" style="margin-left: 108px;">
										<span> Active </span>
									</div>
								<div class="div-table-col" style="margin-left: -52px;">
									<nested:radio property="active" value="Y"> &nbsp; Yes </nested:radio> &nbsp;
									<nested:radio property="active" value="N"> &nbsp; No </nested:radio>
								</div>
							</div>
							
							<div class="div-table-row">
								<div class="div-table-col">
									<span> Query </span>
								</div>
								<div class="div-table-col">
									<nested:textarea property="validationQuery" rows="4" cols="50" style="resize:none;" />
								</div>
								<div class="div-table-col" style="margin-left: 55px;margin-top: 40px;">
									<button class="btn waves-effect waves-light" name="action" id="queryParserId">Query Parse</button>
								</div>	
							</div>
							
							<div>
								<h4><b><u> Condition </u></b></h4>
								<div class="div-table-row">
									<div class="div-table-col">
										<span style="padding-left: 12px;"> Left Expression </span>
									</div>
									<div class="div-table-col">
										<nested:select styleId="leftExpressionType" property="leftExpressionType" style="width: 150px;margin-left: -91px;">
											<html:option value="">--Select--</html:option>
											<html:option value="Query">Query Column</html:option>
										</nested:select>
									</div>
									<div class="div-table-col">
										<span style="padding-left: 12px;">Operator</span>
									</div>
									<div class="div-table-col">
											<nested:select styleId="operator" property="operator" style="width: 150px;margin-left: -143px;">
											<html:option value="">--Select--</html:option>
											<html:option value="IS NULL">IS NULL</html:option>
											<html:option value="IS NOT NULL">IS NOT NULL</html:option>
											<html:option value="IN">IN</html:option>
											<html:option value="NOT EQUAL">!=</html:option>
											<html:option value="EQUAL">=</html:option>
											<html:option value="GREATER THAN"> < </html:option>
											<html:option value="GREATER THAN EQAL"> <= </html:option>
											<html:option value="LESSER THAN"> > </html:option>
											<html:option value="LESSER THAN EQAL"> >= </html:option>
										</nested:select>
									</div>
									<div class="div-table-col">
										<span style="padding-left: 12px;"> Right Expression </span>
									</div>
									<div class="div-table-col">
										<nested:select styleId="rightExpressionType" property="rightExpressionType" style="width: 150px;margin-left: -78px;">
											<html:option value="">--Select--</html:option>
											<html:option value="Constant">Constant</html:option>
											<html:option value="Configurator">Configurator Column</html:option>
										</nested:select>
									</div>
								</div>
								
								<div class="div-table-row">
									<div class="div-table-col">
										<span style="padding-left: 12px;"> Left Column </span>
									</div>
									<div class="div-table-col" id="dynamicLeftExpressionValueId">
										<%-- <nested:text property="leftExpressionValue" style="width: 150px;margin-left: -91px;"/> --%>
									</div>
									<div class="div-table-col">
										<span style="padding-left: 12px;"></span>
									</div>
									<div class="div-table-col">
										<nested:hidden property="operator" styleClass="width: 150px;margin-left: -143px;"/>	
									</div>
									<div class="div-table-col">
										<span style="padding-left: 20px;"> Right Column </span>
									</div>
									<div class="div-table-col" id="dynamicRightExpressionValueId">
										<%-- <nested:text property="rightExpressionValue" style="width: 150px;margin-left: -71px;"/>	 --%>
									</div>
								</div>
								<div class="div-table-row">
									<div class="div-table-col">
										<span></span>
									</div>
									<div class="div-table-col">
										<nested:textarea property="validationConditionString" rows="4" cols="50" style="resize:none;" />
									</div>
									<div class="div-table-col" style="margin-left: 38px;margin-top: 40px;">
										<button class="btn waves-effect waves-light" type="submit" name="action">Add Condition</button>
									</div>
								</div>
								
								<h4><b><u> Error Message </u></b></h4>
								<div class="div-table-row">
									<div class="div-table-col" style="margin-left: 250px;">
										<nested:textarea property="validationErrorMessage" rows="2" cols="50" style="resize:none;" />
									</div>
								</div>		
							</div>
						</div>
						<center>
							<button class="btn waves-effect waves-light" type="submit" name="action">Save</button> &nbsp; &nbsp;
							<button class="btn waves-effect waves-light" type="button" onClick="doNextProcess()" name="action">Next</button>
						</center> &nbsp;
					</div>
				</nested:nest>
			</nested:nest>
		</nested:form>
	</nested:root>
</html:html>