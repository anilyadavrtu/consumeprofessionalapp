package com.professional.service;

import java.util.List;

import com.professional.model.Professional;

/**
 * @author Anil
 *ProfessionalService
 */
public interface ProfessionalService {

	public Integer createProfessional(Professional professional);

	public Integer deleteProfessional(Professional professional);

	public Integer updateProfessional(Professional professional);

	public Professional getOneProfessional(Professional professional);

	public List<Professional> getProfessionalsByDuration(int daysCount);

	public List<Professional> getProfessionalsByLatLong(String latLong,String longitude);

	public List<Professional> getProfessionalsByType(String type);

}
