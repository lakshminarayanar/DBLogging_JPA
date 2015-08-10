
package com.hlb.dblogging.jpa.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.hlb.dblogging.jpa.model.XSLT;

public interface XSLTRepository extends CrudRepository<XSLT, Integer>{

	
	 @Query("select r from XSLT r where deleted = ?")
	 List<XSLT> findByIsDeleted(int x);
	
	@Query("select r from XSLT r where deleted = 0")
	 List<XSLT> findAllInSet();

	@Query("select r from XSLT r where name = 'DEFAULT'")
	 List<XSLT> findByDefaultXSLT(int x);
	
	@Query("select count(*) from XSLT r where vieworsave = ? and transtype= ?")
	 Integer findCountByViewOrSave(String type, String transtype);
	
	@Query("select r from XSLT r where vieworsave = ? and transtype= ?")
	 XSLT findByViewOrSave(String type, String transtype);
	
	@Query("select count(*) from XSLT r where vieworsave = ? and transtype= ? and deleted= ?")
	 Integer findCountByViewOrSaveAndDeleted(String type, String transtype,int deleted);
	
	@Query("select r from XSLT r where vieworsave = ? and transtype= ? and deleted= ?")
	 XSLT findByViewOrSaveAndDeleted(String type, String transtype,boolean deleted);
	
	@Query("select count(*) from XSLT r where vieworsave in ('VIEW','SAVE') and transtype= ?")
	 Integer findCountOfViewOrSaveOfTransType(String transtype);
	
}



