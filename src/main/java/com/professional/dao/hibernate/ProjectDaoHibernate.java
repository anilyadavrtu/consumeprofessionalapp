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

import com.professional.dao.ProjectDao;
import com.professional.model.Professional;
import com.professional.model.Project;

/**
 * @author Anil
 *ProjectDaoHibernate
 */
@Repository("ProjectDaoHibernate")
@Transactional
public class ProjectDaoHibernate implements ProjectDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Project getOneProject(Project project) {
		Criteria criteria = getSession().createCriteria(Project.class);
		Project projectDetails = (Project) criteria.add(Restrictions.eq("id", project.getId()));
		return projectDetails;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Project> getProjectByProfessional(Professional professional) {
		List<Project> projects = new ArrayList<Project>();
		Criteria criteria = getSession().createCriteria(Project.class);
		projects = criteria.add(Restrictions.eq("professional", professional)).list();
		return projects;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Project> getProjectByDuration(int duratuion) {
		List<Project> projects = new ArrayList<Project>();
		Criteria criteria = getSession().createCriteria(Project.class);
		projects = criteria.add(Restrictions.eq("duration", duratuion)).list();
		return projects;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Project> getProjectByType(String type) {
		List<Project> projects = new ArrayList<Project>();
		Criteria criteria = getSession().createCriteria(Project.class);
		projects = criteria.add(Restrictions.eq("type", type)).list();
		return projects;
	}

	@Override
	public Integer createProject(Project project) {
		try {
			getSession().save(project);
			return 1;
		} catch (Exception e) {
			return 0;
		}
	}

	@Override
	public Integer deleteProject(Project project) {
		Criteria criteria = getSession().createCriteria(Project.class);
		Project projectData = (Project) criteria.add(Restrictions.eq("id", project.getId())).uniqueResult();
		try {
			getSession().delete(projectData);
			return 1;
		} catch (Exception e) {
		}
		return 0;
	}

	@Override
	public Integer updateProject(Project project) {
		try {
			getSession().saveOrUpdate(project);
			return 1;
		} catch (Exception e) {
			return 0;
		}
	}

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

}
