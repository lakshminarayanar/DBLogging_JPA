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
        if(searchCriteria.getLogInterface()!=null)
        	booleanBuilder.and(auditMaster.logInterface.contains(searchCriteria.getLogInterface()));
        if(searchCriteria.getStatusCode()!=null)
        	booleanBuilder.and(auditMaster.statusCode.contains(searchCriteria.getStatusCode()));
        if(searchCriteria.getTransactionType()!=null)
        	booleanBuilder.and(auditMaster.transType.contains(searchCriteria.getTransactionType()));
        if(searchCriteria.getTransactionDateTime()!=null)
        	booleanBuilder.and(auditMaster.transDateTime.eq(searchCriteria.getTransactionDateTime()));
        return booleanBuilder;
    }
}
