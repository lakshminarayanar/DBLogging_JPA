package com.hlb.dblogging.dsl.predicates;

import com.hlb.dblogging.jpa.model.QAuditMaster;
import com.hlb.dblogging.jpa.model.SearchBean;
import com.hlb.dblogging.log.utility.ApplLogger;
import com.mysema.query.BooleanBuilder;
import com.mysema.query.types.Predicate;

public class AuditMasterPredicates {

	public static Predicate getSearchFilterPredicate(final SearchBean searchCriteria) {
		BooleanBuilder booleanBuilder = new BooleanBuilder();
        QAuditMaster auditMaster = QAuditMaster.auditMaster;
        try{
        if(searchCriteria.getApplicationName()!=null)
        	booleanBuilder.and(auditMaster.applName.contains(searchCriteria.getApplicationName()));
        if(searchCriteria.getSegment()!=null)
        	booleanBuilder.and(auditMaster.segment.eq(searchCriteria.getSegment()));
        if(searchCriteria.getTransactionType()!=null)
        	booleanBuilder.and(auditMaster.transType.contains(searchCriteria.getTransactionType()));
        if(searchCriteria.getUniqueProcessId()!=null)
        	booleanBuilder.and(auditMaster.uniqueProcessID.eq(searchCriteria.getUniqueProcessId()));
        
        if(searchCriteria.getMessageFormat()!=null)
        	booleanBuilder.and(auditMaster.messageFormat.contains(searchCriteria.getMessageFormat()));
        if(searchCriteria.getJournalSequence()!=null)
        	booleanBuilder.and(auditMaster.journalSeq.eq(Integer.parseInt(searchCriteria.getJournalSequence())));
        if(searchCriteria.getApplicationTransactionId()!=null)
        	booleanBuilder.and(auditMaster.applicationTransactionId.contains(searchCriteria.getApplicationTransactionId()));
      
        if(searchCriteria.getTransactionStartDateTime()!=null && searchCriteria.getTransactionEndDateTime()==null)
        	booleanBuilder.and(auditMaster.transDateTime.after(searchCriteria.getTransactionStartDateTime()));
        if(searchCriteria.getTransactionStartDateTime()==null && searchCriteria.getTransactionEndDateTime()!=null)
        	booleanBuilder.and(auditMaster.transDateTime.before(searchCriteria.getTransactionEndDateTime()));
        if(searchCriteria.getTransactionStartDateTime()!=null && searchCriteria.getTransactionEndDateTime()!=null)
        	booleanBuilder.and(auditMaster.transDateTime.between(searchCriteria.getTransactionStartDateTime(), searchCriteria.getTransactionEndDateTime()));
        }catch(Exception e){
        		ApplLogger.getLogger().info("Error caught while preparing advanced search criteria to query database ",e);
        }
        return booleanBuilder;
    }
}
