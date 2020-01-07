package com.professional.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.professional.dao.ProfessionalDao;
import com.professional.model.Professional;
import com.professional.service.ProfessionalService;

/**
 * @author Anil ProfessionalServiceImpl
 */
@Service("ProfessionalServiceImpl")
@Transactional
public class ProfessionalServiceImpl implements ProfessionalService {

	@Autowired
	private ProfessionalDao professionalDao;

	@Override
	public Integer createProfessional(Professional professional) {
		return professionalDao.createProfessional(professional);
	}

	@Override
	public Integer deleteProfessional(Professional professional) {
		return professionalDao.deleteProfessional(professional);
	}

	@Override
	public Integer updateProfessional(Professional professional) {
		return professionalDao.updateProfessional(professional);
	}

	@Override
	public Professional getOneProfessional(Professional professional) {
		return professionalDao.getOneProfessional(professional);
	}

	@Override
	public List<Professional> getProfessionalsByDuration(int daysCount) {
		return professionalDao.getProfessionalsByDuration(daysCount);
	}

	@Override
	public List<Professional> getProfessionalsByLatLong(String latLong, String longitude) {
		return professionalDao.getProfessionalsByLatLong(latLong, longitude);
	}

	@Override
	public List<Professional> getProfessionalsByType(String type) {
		return professionalDao.getProfessionalsByType(type);
	}

}
