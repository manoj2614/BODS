package com.dataprocess.bods.business;

import java.util.ArrayList;

import com.dataprocess.bods.dao.QueryDefinitionDAO;
import com.dataprocess.bods.entity.QueryDefinitionEO;
import com.dataprocess.bods.util.SpringBeanUtils;
import com.dataprocess.bods.vo.ConfiguratorVO;
import com.dataprocess.bods.vo.QueryDefinitionVO;

public class QueryDefinitionBusiness {

	public boolean validateQueryDefinition(QueryDefinitionVO queryDefinitionVO) {
		QueryDefinitionDAO queryDefinitionDAO = null;
		boolean hasCompleted = false;

		try {
			queryDefinitionDAO = new QueryDefinitionDAO();
			hasCompleted = queryDefinitionDAO.validateQueryDefinition(queryDefinitionVO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return hasCompleted;
	}

	public boolean saveQueryDefinition(QueryDefinitionVO queryDefinitionVO) {
		QueryDefinitionDAO queryDefinitionDAO = null;
		SpringBeanUtils beanUtils = null;
		QueryDefinitionEO queryDefinitionEO = null;
		boolean hasCompleted = false;
		try {
			beanUtils = new SpringBeanUtils();
			queryDefinitionDAO = new QueryDefinitionDAO();
			queryDefinitionEO = new QueryDefinitionEO();
			queryDefinitionEO = (QueryDefinitionEO) beanUtils.populateToEntityObject(queryDefinitionVO, queryDefinitionEO);
			hasCompleted = queryDefinitionDAO.saveQueryDefinition(queryDefinitionEO);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return hasCompleted;
	}

	public ArrayList<QueryDefinitionVO> getSourceConfigConnectionList() {
		QueryDefinitionDAO queryDefinitionDAO = null;
		ArrayList<QueryDefinitionVO> sourceConfigConnectionList = null;
		
		try {
			queryDefinitionDAO = new QueryDefinitionDAO();
			sourceConfigConnectionList = queryDefinitionDAO.getSourceConfigConnectionList();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sourceConfigConnectionList;
	}

	public void fetchQueryDefinitionList(QueryDefinitionVO queryDefinitionVO) {
		QueryDefinitionDAO queryDefinitionDAO = null;
		
		try {
			queryDefinitionDAO = new QueryDefinitionDAO();
			queryDefinitionDAO.fetchQueryDefinitionList(queryDefinitionVO);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public QueryDefinitionVO fetchQueryDefinitionDetails(QueryDefinitionVO queryDefinitionVO) {
		QueryDefinitionEO queryDefinitionEO = null;
		QueryDefinitionDAO queryDefinitionDAO = null;
		
		try {
			queryDefinitionDAO = new QueryDefinitionDAO();
			queryDefinitionEO = queryDefinitionDAO.fetchQueryDefinitionDetails(queryDefinitionVO);
			queryDefinitionVO = (QueryDefinitionVO) new SpringBeanUtils().populateToDTOObject(queryDefinitionEO, queryDefinitionVO);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return queryDefinitionVO;
	}
}
