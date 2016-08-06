<%@ page language="java"%><%@ taglib uri="struts-html" prefix="html"%><%@ taglib uri="struts-bean" prefix="bean"%><%@ taglib uri="struts-nested" prefix="nested"%>
<html:html>
	<head>
		<link href="css/basepagemaker.css" rel='stylesheet' type='text/css' />
	</head>
	<script>
	function callExecute() {
		document.configuratorForm.action='/bods/TargetColumnMappingAction.etl';
		document.configuratorForm.submit();
	}
	</script>
	<style>
		#custom-edit, custom-delete {
			display: table-cell;
			font: normal normal normal 14px/1 FontAwesome;
    		font-size: inherit;
    		text-rendering: auto;
    		-webkit-font-smoothing: antialiased;
		}
		.fa-pencil-square-o:hover::before {
  			color: #FFA200;
		}
		.fa-trash-o:hover::before {
  			color: #FFA200;
		}
		.fa-plus-circle:hover::before {
			color: #FFA200;
		}
	</style>
	<nested:root name="configuratorForm">
		<html:form styleId="ldrForm" action="ConfiguratorColumnDefinition">
			<nested:nest property="configuratorVO">
				<nested:nest property="configuratorInterfaceColumnVO">
					<div id="pageContentDivId">
						<div class="div-table">
							<div class="div-table-row">
								<div class="div-table-col" style="width: 200px;">
									<span style="padding-left: 1px;"> Table Name </span>
								</div>
								<div class="div-table-col">
									<nested:text property="tableName" style="width: 150px;margin-left: -112px;"/>
								</div>
								<div class="div-table-col">
									<span style="padding-left: 5px;"> Column Name</span>
								</div>
								<div class="div-table-col">
									<nested:text property="columnName" style="width: 150px;margin-left: -104px;"/>
								</div>
								<div class="div-table-col">
									<span style="padding-left: 12px;"> Attribute Name </span>
								</div>
								<div class="div-table-col">
									<nested:text property="attributeName" style="width: 150px;margin-left: -78px;"/>	
								</div>
								<div class="div-table-col" style="cursor: pointer;" >
									<i class="fa fa-plus-circle fa-lg" style="color:#2699D0;"></i>
								</div>
							</div>
						</div>
						<br/>
						<table cellpadding="0" cellspacing="0" border="0" width="" style="border:1px solid black;width: 80%;margin-left: 120px;" class="cs-sap-table">
			        		 <thead>
			            		<tr>
					      			<th style="padding-left: 30px;">Table Name</th>
					               	<th style="padding-left: 20px;">Column Name</th>
					                <th style="padding-left: 45px;">Attribute Name</th>
					                <th style="padding-left: 165px;">Edit</th>
					                <th style="padding-left: 70px;">Delete</th>
					      		</tr>
			            	 </thead>
			            	 <tr>
                				<td style="padding-left: 30px;">Table Name</td>
				               	<td style="padding-left: 20px;">Column Name</td>
				                <td style="padding-left: 45px;">Attribute Name</td>
				                <td style="padding-left: 172px;" id="custom-edit">
				                	<i class="fa fa-pencil-square-o fa-lg" style="color:#2699D0;cursor: pointer;"></i>
				                </td>
				                <td style="padding-left: 85px;" id="custom-delete">
				                	<i class="fa fa-trash-o fa-lg" style="color:red;cursor: pointer;"></i>
				                </td>
               				</tr>
			               		<nested:present property="configuratorMappedColumnVOList">
			               			<nested:iterate property="configuratorMappedColumnVOList" id="configuratorMappedColumnVOListId" 
			               				type="com.dataprocess.bods.vo.ConfiguratorMappedColumnVO" indexId="count">
			               			</nested:iterate>
			               		</nested:present>
            			</table>
					</div>
					<center>
						<button class="btn waves-effect waves-light" type="button" onClick="doNextProcess()" name="action">Save</button>
					</center>
				</nested:nest>
			</nested:nest>
		</html:form>
	</nested:root>
</html:html>