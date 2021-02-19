package com.uniovi.services;

import java.util.*;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.uniovi.entities.Professor;

@Service
public class ProfessorsService {

	private List<Professor> profList = new LinkedList<Professor>();
	
	@PostConstruct
	public void init() {
		profList.add(new Professor(1L,"1234","Pepe","Perez","Matematicas"));
		profList.add(new Professor(2L,"5678","Jose","Crespo","Literatura"));
	}
	
	public List<Professor> getList(){
		return profList;
	}
	
	public Professor getProf(Long id) {
		return profList.stream().filter(prof -> prof.getId().equals(id)).findFirst().get();
	}

	public void addProfessor(Professor prof) {
		// Si en Id es null le asignamos el ultimo + 1 de la lista
		if (prof.getDni() == null) {
			prof.setId(profList.get(profList.size() - 1).getId() + 1);
		}

		profList.add(prof);
	}

	public void deleteProfessor(Long id) {
		profList.removeIf(prof -> prof.getId().equals(id));
	}
}
