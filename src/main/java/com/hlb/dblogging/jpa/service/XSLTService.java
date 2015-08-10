package com.hlb.dblogging.jpa.service;

import java.util.List;

import com.hlb.dblogging.jpa.model.XSLT;

public interface XSLTService {
	
	List<XSLT> getAllXSLT();
	Boolean createNewXSLT(XSLT newXSLT);
	Boolean updateXSLT(XSLT xslt);
	Boolean deleteXSLT(XSLT xslt); 

}
