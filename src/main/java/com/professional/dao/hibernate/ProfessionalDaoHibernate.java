package com.professional.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.professional.dao.ProfessionalDao;
import com.professional.model.Professional;
import com.professional.model.Project;

/**
 * @author Anil
 *ProfessionalDaoHibernate
 */
@Repository("ProfessionalDaoHibernate")
@Transactional
public class ProfessionalDaoHibernate implements ProfessionalDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Integer createProfessional(Professional professional) {
		try {
			getSession().save(professional);
			return 1;
		} catch (Exception e) {
			return 0;
		}

	}

	@Override
	public Integer deleteProfessional(Professional professional) {
		try {
			getSession().delete(professional);
			return 1;
		} catch (Exception e) {
			return 0;
		}
	}

	@Override
	public Integer updateProfessional(Professional professional) {
		try {
			getSession().update(professional);
			return 1;
		} catch (Exception e) {
			return 0;
		}

	}

	@Override
	public Professional getOneProfessional(Professional professional) {
		Criteria criteria = getSession().createCriteria(Project.class);
		Professional professionalData = (Professional) criteria.add(Restrictions.eq("professional", professional));
		return professionalData;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Professional> getProfessionalsByDuration(int daysCount) {
		List<Professional> professionals = new ArrayList<Professional>();
		Criteria criteria = getSession().createCriteria(Project.class);
		criteria.add(Restrictions.eq("updatedDate", daysCount));
		professionals = criteria.list();
		return professionals;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Professional> getProfessionalsByLatLong(String lat, String longitude) {
		List<Professional> professionals = new ArrayList<Professional>();
		Criteria criteria = getSession().createCriteria(Project.class);
		criteria.add(Restrictions.eq("latitude", lat));
		criteria.add(Restrictions.eq("longitude", longitude));
		professionals = criteria.list();
		return professionals;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Professional> getProfessionalsByType(String type) {
		List<Professional> professionals = new ArrayList<Professional>();
		Criteria criteria = getSession().createCriteria(Project.class);
		professionals = criteria.add(Restrictions.eq("type", type)).list();
		return professionals;
	}

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}
}
