package com.professional.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.professional.model.Professional;
import com.professional.service.ProfessionalService;

/**
 * @author Anil
 *
 */
@RestController
@RequestMapping(value = "/professional")
public class ProfessionalController {

	@Autowired
	private ProfessionalService professionalService;

	@RequestMapping(value = "/createProfessional", method = RequestMethod.POST)
	@ResponseBody
	public String createProfessional(@RequestBody Professional professional) {
		String status;
		Integer integer = getProfessionalService().createProfessional(professional);
		if (integer == 1) {
			status = "success";
		} else {
			status = "fail";
		}
		return status;
	}

	@RequestMapping(value = "/updateProfessional", method = RequestMethod.PUT)
	@ResponseBody
	public String updateProfessional(@RequestBody Professional professional) {
		Integer integer = getProfessionalService().updateProfessional(professional);
		String status;
		if (integer == 1) {
			status = "success";
		} else {
			status = "fail";
		}
		return status;
	}

	@RequestMapping(value = "/deleteProfessional", method = RequestMethod.DELETE)
	@ResponseBody
	public Professional deleteProject(int professionalId) {
		Professional professional = new Professional();
		professional.setId(new Integer(professionalId));
		getProfessionalService().deleteProfessional(professional);
		return professional;

	}

	@RequestMapping(value = "/getProfessionalById")
	@ResponseBody
	public Professional getOneProfessional(int professionalId) {
		Professional professionalData = new Professional();
		professionalData.setId(new Integer(professionalId));
		Professional professionalDetail = getProfessionalService().getOneProfessional(professionalData);
		return professionalDetail;
	}

	@RequestMapping(value = "/getProfessionalsByDuration")
	@ResponseBody
	public List<Professional> getProfessionalsByDuration(int duration) {
		List<Professional> Professionas = getProfessionalService().getProfessionalsByDuration(duration);
		return Professionas;

	}

	@RequestMapping(value = "/getProfessionalsByLatLong")
	@ResponseBody
	public List<Professional> getProfessionalsByLatLong(String latLong, String longitude) {
		List<Professional> professionals = getProfessionalService().getProfessionalsByLatLong(latLong, longitude);
		return professionals;
	}

	@RequestMapping(value = "/getProfessionalsByType")
	@ResponseBody
	public List<Professional> getProfessionalsByType(String type) {
		List<Professional> professionals = getProfessionalService().getProfessionalsByType(type);
		return professionals;

	}

	public ProfessionalService getProfessionalService() {
		return professionalService;
	}

	public void setProfessionalService(ProfessionalService professionalService) {
		this.professionalService = professionalService;
	}

}
