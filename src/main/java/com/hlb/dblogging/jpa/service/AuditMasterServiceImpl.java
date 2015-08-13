package com.hlb.dblogging.jpa.service;

import static com.hlb.dblogging.dsl.predicates.AuditMasterPredicates.getSearchFilterPredicate;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hlb.dblogging.jpa.model.AuditMaster;
import com.hlb.dblogging.jpa.model.QAuditMaster;
import com.hlb.dblogging.jpa.model.SearchBean;
import com.hlb.dblogging.jpa.repository.AuditMasterRepository;
import com.hlb.dblogging.log.utility.ApplLogger;
import com.mysema.query.types.OrderSpecifier;
@Service
public class AuditMasterServiceImpl implements AuditMasterService{

	@Resource
	AuditMasterRepository auditMasterRepo;

	@Transactional(rollbackFor = { Exception.class })
	public long create(AuditMaster auditMaster) {
		try {
			AuditMaster auditMasterToBeCreated = auditMaster;
			ApplLogger.getLogger().info("AuditMaster is saved in Database...!!! : "+auditMasterToBeCreated.getUniqueProcessID());
			auditMasterToBeCreated = auditMasterRepo.save(auditMasterToBeCreated);
			return auditMasterToBeCreated.getId();

		} catch (Exception e) {
			ApplLogger.getLogger().error("Error caught while saving the AuditMaster instance to Database",e);
			if(auditMasterRepo==null)
				ApplLogger.getLogger().info("Repository is not instantiated by Spring container...");
			return 0;
		}

	}
	@Transactional(readOnly = true)
	@Override
	public List<AuditMaster> getListOfMessages() {
		return	auditMasterRepo.findFirst10ByLogInterfaceOrderByTransDateTimeDesc("MBASE");
	}
	
	/**
     * Returns an OrderSpecifier object which sorts person in ascending order by using the last name.
     * @return
     */
    private OrderSpecifier<Date> orderByTranscationDateAsc() {
        return QAuditMaster.auditMaster.transDateTime.asc();
    }
 

	@Transactional(readOnly = true)
	@Override
	public List<AuditMaster> getSearchResultList(SearchBean searchCriteria) {
	
		if(checkSearchCriteriaIsEmpty(searchCriteria))
			return	getListOfMessagesByTime(new Date());
		ApplLogger.getLogger().info("Search criteria is not empty, so results are filtered..");
		searchCriteria = trimInputSearchCriteria(searchCriteria);
		
		Iterable<AuditMaster> searchResultList =  auditMasterRepo.findAll(getSearchFilterPredicate(searchCriteria),orderByTranscationDateAsc());
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
		searchCriteria.setUniqueProcessId((StringUtils.trimToNull(searchCriteria.getUniqueProcessId())));
		searchCriteria.setTransactionType(StringUtils.trimToNull(searchCriteria.getTransactionType()));
		searchCriteria.setSegment(StringUtils.trimToNull(searchCriteria.getSegment()));
		searchCriteria.setMessageFormat(StringUtils.trimToNull(searchCriteria.getMessageFormat()));
		searchCriteria.setJournalSequence(StringUtils.trimToNull(searchCriteria.getJournalSequence()));
		searchCriteria.setApplicationTransactionId(StringUtils.trimToNull(searchCriteria.getApplicationTransactionId()));
		searchCriteria.setTransactionStartDateTime(getTimeWithOneSecondLess(searchCriteria.getTransactionStartDateTime()));
		return searchCriteria;
	}
	
	private Date getTimeWithOneSecondLess(Date transactionStartTime){
		if(transactionStartTime==null)
			return null;
		Calendar cal = Calendar.getInstance();
		cal.setTime(transactionStartTime);
		cal.add(Calendar.SECOND, -1);
		return cal.getTime();
	}
	
	
	
	private boolean checkSearchCriteriaIsEmpty(SearchBean searchCriteria){
	 return StringUtils.trimToNull(searchCriteria.getApplicationName())==null && StringUtils.trimToNull(searchCriteria.getUniqueProcessId())==null &&
			StringUtils.trimToNull(searchCriteria.getTransactionType())==null && StringUtils.trimToNull(searchCriteria.getMessageFormat())==null &&
			StringUtils.trimToNull(searchCriteria.getJournalSequence())==null && StringUtils.trimToNull(searchCriteria.getApplicationTransactionId())==null &&
			StringUtils.trimToNull(searchCriteria.getSegment())==null && searchCriteria.getTransactionStartDateTime() == null  && searchCriteria.getTransactionEndDateTime() == null;
	}
	
	
	@Override
	public List<AuditMaster> getListOfMessagesByTime(Date date) {
		List<AuditMaster> searchResultList = new ArrayList<>();
		ApplLogger.getLogger().info("Date input passing is : "+date);
		List<AuditMaster> tempList = auditMasterRepo.findFirst20ByTransDateTimeOrderByTransDateTimeDesc(getDateWithoutTime(date));
		ApplLogger.getLogger().info("Size of the List with Today Transactions: "+tempList.size());
		if(tempList.size()>0)
			searchResultList.addAll(tempList);
		
		for(int i=0;i<=10;i++){
			if(searchResultList.size()>=20)
				break;
			date = decreaseOneDayFromDate(date);
			ApplLogger.getLogger().info("Date input with one day less passing is : "+date);
			tempList = auditMasterRepo.findFirst20ByTransDateTimeOrderByTransDateTimeDesc(getDateWithoutTime(date));
			ApplLogger.getLogger().info("Size of the List with one day before Transactions: "+tempList.size());
			if(tempList.size()>0)
				searchResultList.addAll(tempList);
			
			}
		ApplLogger.getLogger().info("Size of the List Total Transactions: "+searchResultList.size());
		return searchResultList;
	}
	
	
	private Date getDateWithoutTime(Date date){
		DateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
		Date todayWithZeroTime = null;
		try {
			 todayWithZeroTime =formatter.parse(formatter.format(date));
			 return todayWithZeroTime;
		} catch (ParseException e) {
			ApplLogger.getLogger().info("Error while removing time from date in Search Message ",e);
		}
		return new Date();
	}
	
	
	private Date decreaseOneDayFromDate(Date date){
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, -1);
		/*cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.HOUR, 0);*/
		return cal.getTime();
	}
	@Override
	public List<AuditMaster> getResultByUniqueProcessId(String uniqueProcessId) {
		try{
			if(uniqueProcessId==null){
				return new ArrayList<AuditMaster>();
			}
			return auditMasterRepo.findSearchListByUniqueProcessId(uniqueProcessId);
		}catch(Exception e){
			ApplLogger.getLogger().error("Error while fetching data for uniqueprocessid : "+uniqueProcessId, e);
			return new ArrayList<AuditMaster>();
		}
	}
	
	
	
}
