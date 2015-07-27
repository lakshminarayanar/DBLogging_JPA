package com.hlb.dblogging.dsl.predicates;

import com.hlb.dblogging.jpa.model.QAuditMaster;
import com.hlb.dblogging.jpa.model.SearchBean;
import com.mysema.query.BooleanBuilder;
import com.mysema.query.types.Predicate;

public class AuditMasterPredicates {

	public static Predicate getSearchFilterPredicate(final SearchBean searchCriteria) {
		BooleanBuilder booleanBuilder = new BooleanBuilder();
        QAuditMaster auditMaster = QAuditMaster.auditMaster;
        if(searchCriteria.getApplicationName()!=null)
        	booleanBuilder.and(auditMaster.applName.contains(searchCriteria.getApplicationName()));
        if(searchCriteria.getSegment()!=null)
        	booleanBuilder.and(auditMaster.segment.eq(searchCriteria.getSegment()));
        if(searchCriteria.getTransactionType()!=null)
        	booleanBuilder.and(auditMaster.transType.contains(searchCriteria.getTransactionType()));
        if(searchCriteria.getUniqueProcessId()!=null)
        	booleanBuilder.and(auditMaster.uniqueProcessID.eq(searchCriteria.getUniqueProcessId()));
        
        if(searchCriteria.getTransactionStartDateTime()!=null && searchCriteria.getTransactionEndDateTime()==null)
        	booleanBuilder.and(auditMaster.transDateTime.after(searchCriteria.getTransactionStartDateTime()));
        if(searchCriteria.getTransactionStartDateTime()==null && searchCriteria.getTransactionEndDateTime()!=null)
        	booleanBuilder.and(auditMaster.transDateTime.before(searchCriteria.getTransactionEndDateTime()));
        if(searchCriteria.getTransactionStartDateTime()!=null && searchCriteria.getTransactionEndDateTime()!=null)
        	booleanBuilder.and(auditMaster.transDateTime.between(searchCriteria.getTransactionStartDateTime(), searchCriteria.getTransactionEndDateTime()));
        
        return booleanBuilder;
    }
}
