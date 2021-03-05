package com.uniovi.services;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.uniovi.entities.Mark;
import com.uniovi.entities.User;
import com.uniovi.repositories.UsersRepository;

@Service
public class UsersService {
	@Autowired
	private UsersRepository usersRepository;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public List<User> getUsers() {
		List<User> users = new ArrayList<User>();
		usersRepository.findAll().forEach(users::add);
		return users;
	}

	public User getUser(Long id) {
		return usersRepository.findById(id).get();
	}

	public void addUser(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		usersRepository.save(user);
	}

	public User getUserByDni(String dni) {
		return usersRepository.findByDni(dni);
	}

	public void deleteUser(Long id) {
		usersRepository.deleteById(id);
	}
	
	public void editUser(User user) {
		usersRepository.save(user);
	}
	
	public List<User> getUserByName( String searchText) {
		searchText = "%"+searchText+"%";
		List<User> users = new ArrayList<User>();
		users =usersRepository.searchByName( searchText);
		return users;
	}
	
	public List<User> getUserByLastName(String searchText) {
		searchText = "%"+searchText+"%";
		List<User> users = new ArrayList<User>();
		users =usersRepository.searchByLastName( searchText);
		return users;
	}
	
	public List<User> getUserByNameAndLastName(String searchText) {
		searchText = "%"+searchText+"%";
		List<User> users = new ArrayList<User>();
		users =usersRepository.searchByNameAndLastName(searchText);
		return users;
	}
	
}
