package com.professional.dao;

import java.util.List;

import com.professional.model.Professional;
import com.professional.model.Project;


/**
 * @author Anil
 *ProjectDao
 */
public interface ProjectDao {

	public Integer createProject(Project project);

	public Integer deleteProject(Project project);

	public Integer updateProject(Project project);

	public Project getOneProject(Project project);

	public List<Project> getProjectByProfessional(Professional professional);

	public List<Project> getProjectByDuration(int duratuion);

	public List<Project> getProjectByType(String type);
}
