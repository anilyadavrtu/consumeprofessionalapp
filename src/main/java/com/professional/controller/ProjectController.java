package com.professional.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.professional.model.Professional;
import com.professional.model.Project;
import com.professional.service.ProjectService;

/**
 * @author Anil
 *ProjectController
 */
@RestController
@RequestMapping(value = "/project")
public class ProjectController {

	@Autowired
	private ProjectService projectService;
	

	@RequestMapping(value = "/createProject", method = RequestMethod.POST)
	public String createProject(@RequestBody Project project) {
		String status;
		Integer integer = getProjectService().createProject(project);
		if (integer == 1) {
			status = "success";
		} else {
			status = "fail";
		}
		return status;
	}

	@RequestMapping(value = "/updateProject", method = RequestMethod.PUT)
	public String updateProject(@RequestBody Project project) {
		Integer integer = getProjectService().updateProject(project);
		String status;
		if (integer == 1) {
			status = "success";
		} else {
			status = "fail";
		}
		return status;
	}

	@RequestMapping(value = "/deleteProject", method = RequestMethod.DELETE)
	public Project deleteProject(int projectId) {
		Project project = new Project();
		project.setId(new Integer(projectId));
		getProjectService().deleteProject(project);
		return project;

	}

	@RequestMapping(value = "/getProjectById")
	public Project getOneProject(int projectId) {
		Project projectData = new Project();
		projectData.setId(new Integer(projectId));
		Project projectDetail = getProjectService().getOneProject(projectData);
		return projectDetail;
	}

	@RequestMapping(value = "/getAllProjectsByProfessional")

	public List<Project> getProjectByProfessional(Professional professional) {
		List<Project> projects = getProjectService().getProjectByProfessional(professional);
		return projects;
	}

	@RequestMapping(value = "/getAllProjectsByDuration")

	public List<Project> getProjectByDuration(int duration) {
		List<Project> projects = getProjectService().getProjectByDuration(duration);
		return projects;

	}

	@RequestMapping(value = "/getProjectsByType")

	public List<Project> getProjectByType(String type) {
		List<Project> projects = getProjectService().getProjectByType(type);
		return projects;

	}
	
	public ProjectService getProjectService() {
		return projectService;
	}

	public void setProjectService(ProjectService projectService) {
		this.projectService = projectService;
	}

	
}
