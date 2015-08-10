package com.hlb.dblogging.jpa.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.hlb.dblogging.jpa.model.XSLT;
import com.hlb.dblogging.jpa.repository.XSLTRepository;
import com.hlb.dblogging.log.utility.ApplLogger;

@Service
public class XSLTServiceImpl implements XSLTService{
	
	@Resource
	private XSLTRepository xsltRepository;

	@Override
	public List<XSLT> getAllXSLT() {
		try{
		return xsltRepository.findAllInSet();
		}catch(Exception e){
			ApplLogger.getLogger().error("Error caught while getting all the xlsts from database ", e);
			throw new RuntimeException(e.getMessage());
		}
	}

	@Override
	public Boolean createNewXSLT(XSLT newXSLT) {
		try{
		Integer count =	 xsltRepository.findCountByViewOrSave(newXSLT.getViewOrSave(), newXSLT.getTransType());
		if(count!=null && count==0){
			// proceed saving the new xslt with the transtype
			xsltRepository.save(newXSLT);
			return Boolean.TRUE;
		 }else if(count==1){
			 XSLT existingXsltBean = xsltRepository.findByViewOrSaveAndDeleted(newXSLT.getViewOrSave(), newXSLT.getTransType(), true);
			 if(existingXsltBean!=null){
				 existingXsltBean.setName(newXSLT.getName());
					existingXsltBean.setXsltFile(newXSLT.getXsltFile());
					existingXsltBean.setEnabled(newXSLT.isEnabled());
					existingXsltBean.setDeleted(newXSLT.isDeleted());
					xsltRepository.save(existingXsltBean);
					return Boolean.TRUE;
			 }
			 else
				 throw new DataIntegrityViolationException("XSLT already existed in the System");
		 }
		 else
			 throw new DataIntegrityViolationException("XSLT already existed in the System");
		}catch(Exception e){
				if(e instanceof DataIntegrityViolationException)
					throw new DataIntegrityViolationException("XSLT already existed in the System");
				ApplLogger.getLogger().error("Error caught while inserting new xlst to database ", e);
				throw new RuntimeException(e.getMessage());
			}
	}

	@Override
	public Boolean updateXSLT(XSLT xslt) {
		try{
			XSLT existingXsltBean = xsltRepository.findByViewOrSave(xslt.getViewOrSave(), xslt.getTransType());
			if(existingXsltBean!=null){
				existingXsltBean.setName(xslt.getName());
				existingXsltBean.setXsltFile(xslt.getXsltFile());
				existingXsltBean.setEnabled(xslt.isEnabled());
				existingXsltBean.setDeleted(xslt.isDeleted());
				existingXsltBean.setLastModifiedBy(xslt.getLastModifiedBy());
				existingXsltBean.setLastModifiedTime(xslt.getLastModifiedTime());
				xsltRepository.save(existingXsltBean);
				return Boolean.TRUE;
			}
		}catch(Exception e){
			ApplLogger.getLogger().error("Error caught while updating the xlsts from database ", e);
			throw new RuntimeException(e.getMessage());
		}
		return Boolean.FALSE;
	}

	@Override
	public Boolean deleteXSLT(XSLT xslt) {
		try{
			XSLT existingXsltBean = xsltRepository.findByViewOrSave(xslt.getViewOrSave(), xslt.getTransType());
			if(existingXsltBean!=null){
				existingXsltBean.setDeleted(xslt.isDeleted());
				existingXsltBean.setLastModifiedBy(xslt.getLastModifiedBy());
				existingXsltBean.setLastModifiedTime(xslt.getLastModifiedTime());
				xsltRepository.save(existingXsltBean);
				return Boolean.TRUE;
			}
		}catch(Exception e){
			ApplLogger.getLogger().error("Error caught while deleting  the xlsts from database ", e);
			throw new RuntimeException(e.getMessage());
		}
		return Boolean.FALSE;
	}

}
