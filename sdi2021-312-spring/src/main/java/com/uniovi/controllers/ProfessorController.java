package com.uniovi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.uniovi.entities.Professor;
import com.uniovi.services.ProfessorsService;

@Controller
public class ProfessorController {

	@Autowired
	private ProfessorsService profService;
	
	@RequestMapping("/prof/list")
	public String getList(Model model) {
		model.addAttribute("profList", profService.getList());
		return "prof/list";
	}

	@RequestMapping(value = "/prof/add")
	public String getProf() {
		return "prof/add";
	}

	@RequestMapping(value = "/prof/add", method = RequestMethod.POST)
	public String setProf(@ModelAttribute Professor prof) {
		profService.addProfessor(prof);
		return "redirect:/prof/list";
	}
	
	@RequestMapping(value = "/prof/edit/{id}")
	public String getEdit(Model model, @PathVariable Long id) {
		model.addAttribute("prof", profService.getProf(id));
		return "prof/edit";
	}

	@RequestMapping(value = "/prof/edit/{id}", method = RequestMethod.POST)
	public String setEdit(Model model, @PathVariable Long id, @ModelAttribute Professor prof) {
		prof.setId(id);
		profService.addProfessor(prof);
		return "redirect:/prof/details/" + id;
	}
	
	@RequestMapping("/prof/details/{id}")
	public String getDetail(Model model, @PathVariable Long id) {
		model.addAttribute("prof", profService.getProf(id));
		return "prof/details";
	}
	
	@RequestMapping("/prof/delete/{id}")
	public String deleteProf(@PathVariable Long id) {
		profService.deleteProfessor(id);
		return "redirect:/prof/list";
	}
}
