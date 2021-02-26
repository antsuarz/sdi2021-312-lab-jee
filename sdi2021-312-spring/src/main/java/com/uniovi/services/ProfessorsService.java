package com.uniovi.services;

import java.util.*;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uniovi.entities.Professor;
import com.uniovi.entities.User;
import com.uniovi.repositories.ProfessorRepository;

@Service
public class ProfessorsService {

	
	@Autowired
	private ProfessorRepository profrep;
	
	
	public List<Professor> getList(){
		List<Professor> profList = new ArrayList<Professor>();
		profrep.findAll().forEach(profList::add);
		return profList;
	}
	
	public Professor getProf(Long id) {
		return profrep.findById(id).get();
	}

	public void addProfessor(Professor prof) {
		profrep.save(prof);
	}

	public void deleteProfessor(Long id) {
		profrep.deleteById(id);
	}
	
	public Professor getUserByDni(String dni) {
		return profrep.findByDni(dni);
	}
}
