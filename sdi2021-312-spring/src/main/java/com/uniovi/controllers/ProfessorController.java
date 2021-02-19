package com.uniovi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.uniovi.entities.Professor;
import com.uniovi.services.ProfessorsService;

@RestController
public class ProfessorController {

	@Autowired
	private ProfessorsService profService;
	
	@RequestMapping("/prof/list")
	public String getList() {
		return profService.getList().toString();
	}

	@RequestMapping(value = "/prof/add", method = RequestMethod.POST)
	public String setProf(@ModelAttribute Professor prof) {
		profService.addProfessor(prof);
		return "Ok";
	}
	
	@RequestMapping("/prof/details/{id}")
	public String getDetail(@PathVariable Long id) {
		return profService.getProf(id).toString();
	}
	
	@RequestMapping("/prof/delete/{id}")
	public String deleteProf(@PathVariable Long id) {
		profService.deleteProfessor(id);
		return "Ok";
	}
}
