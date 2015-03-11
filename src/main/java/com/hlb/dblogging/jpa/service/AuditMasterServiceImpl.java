package com.hlb.dblogging.jpa.service;

import static com.hlb.dblogging.dsl.predicates.AuditMasterPredicates.getSearchFilterPredicate;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hlb.dblogging.jpa.model.AuditMaster;
import com.hlb.dblogging.jpa.model.SearchBean;
import com.hlb.dblogging.jpa.repository.AuditMasterRepository;
import com.hlb.dblogging.log.utility.ApplLogger;
@Service
public class AuditMasterServiceImpl implements AuditMasterService{

	@Resource
	AuditMasterRepository auditMasterRepo;

	@Transactional(rollbackFor = { Exception.class })
	public void create(AuditMaster auditMaster) {
		try {
			AuditMaster auditMasterToBeCreated = auditMaster;
			auditMasterRepo.save(auditMasterToBeCreated);
			ApplLogger.getLogger().info("AuditMaster is saved in Database...!!! : "+auditMasterToBeCreated.getUniqueProcessID());

		} catch (Exception e) {
			ApplLogger.getLogger().error("Error caught while saving the AuditMaster instance to Database",e);
			if(auditMasterRepo==null)
				ApplLogger.getLogger().info("Repository is not instantiated by Spring container...");
		}

	}
	@Transactional(readOnly = true)
	@Override
	public List<AuditMaster> getListOfMessages() {
		return	auditMasterRepo.findTop10ByLogInterfaceOrderByTransDateTimeDesc("MBASE");
	}

	@Transactional(readOnly = true)
	@Override
	public List<AuditMaster> getSearchResultList(SearchBean searchCriteria) {
	
		if(checkSearchCriteriaIsEmpty(searchCriteria))
			return	getListOfMessages();
		ApplLogger.getLogger().info("Search criteria is not empty, so results are filtered..");
		searchCriteria = trimInputSearchCriteria(searchCriteria);
		
		Iterable<AuditMaster> searchResultList =  auditMasterRepo.findAll(getSearchFilterPredicate(searchCriteria));
		//Iterable<AuditMaster> searchResultList =  auditMasterRepo.findAll(QAuditMaster.auditMaster.logInterface.contains(searchCriteria.getLogInterface()));
		return constructList(searchResultList);
	}
	
	private List<AuditMaster> constructList(Iterable<AuditMaster> auditMasterIterable) {
        List<AuditMaster> list = new ArrayList<AuditMaster>();
        for (AuditMaster auditMasterBean: auditMasterIterable) {
            list.add(auditMasterBean);
        }
        ApplLogger.getLogger().info("Filtered results list size is : "+list.size());
        return list;
    }
	
	
	private SearchBean trimInputSearchCriteria(SearchBean searchCriteria){
		// Trimming all the properties of the Search criteria
		searchCriteria.setApplicationName(StringUtils.trimToNull(searchCriteria.getApplicationName()));
		searchCriteria.setLogInterface(StringUtils.trimToNull(searchCriteria.getLogInterface()));
		searchCriteria.setStatusCode(StringUtils.trimToNull(searchCriteria.getStatusCode()));
		searchCriteria.setTransactionType(StringUtils.trimToNull(searchCriteria.getTransactionType()));
		searchCriteria.setTransactionDateTime(searchCriteria.getTransactionDateTime());
		
		return searchCriteria;
	}
	
	private boolean checkSearchCriteriaIsEmpty(SearchBean searchCriteria){
	 return StringUtils.trimToNull(searchCriteria.getApplicationName())==null && StringUtils.trimToNull(searchCriteria.getLogInterface())==null &&
			StringUtils.trimToNull(searchCriteria.getStatusCode())==null && StringUtils.trimToNull(searchCriteria.getTransactionType())==null &&
			 searchCriteria.getTransactionDateTime() == null;
	}
	
}
