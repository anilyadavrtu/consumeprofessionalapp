package com.professional.dao;

import java.util.List;

import com.professional.model.Professional;



/**
 * @author Anil
 *ProfessionalDao
 */
public interface ProfessionalDao {

	public Integer createProfessional(Professional professional);

	public Integer deleteProfessional(Professional professional);

	public Integer updateProfessional(Professional professional);

	public Professional getOneProfessional(Professional professional);

	public List<Professional> getProfessionalsByDuration(int daysCount);

	public List<Professional> getProfessionalsByLatLong(String latLong,String longitude);

	public List<Professional> getProfessionalsByType(String type);
}
