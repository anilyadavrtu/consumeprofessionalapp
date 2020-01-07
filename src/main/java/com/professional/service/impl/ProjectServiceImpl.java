package com.professional.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.professional.dao.ProjectDao;
import com.professional.model.Professional;
import com.professional.model.Project;
import com.professional.service.ProjectService;

/**
 * @author Anil
 *
 */
@Service("ProjectServiceImpl")
public class ProjectServiceImpl implements ProjectService {

	private ProjectDao projectDao;

	@Autowired
	public ProjectDao getProjectDao() {
		return projectDao;
	}

	@Override
	public Project getOneProject(Project project) {
		return getProjectDao().getOneProject(project);
	}

	@Override
	public List<Project> getProjectByProfessional(Professional professional) {
		return getProjectDao().getProjectByProfessional(professional);
	}

	@Override
	public List<Project> getProjectByDuration(int duratuion) {
		return getProjectDao().getProjectByDuration(duratuion);
	}

	@Override
	public List<Project> getProjectByType(String type) {
		return getProjectDao().getProjectByType(type);
	}

	@Override
	public Integer createProject(Project project) {
		return getProjectDao().createProject(project);
	}

	@Override
	public Integer deleteProject(Project project) {

		return getProjectDao().deleteProject(project);
	}

	@Override
	public Integer updateProject(Project project) {
		return getProjectDao().updateProject(project);
	}

}
