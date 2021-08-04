package com.example.user.controller;

import java.net.URI;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.user.entity.State;
import com.example.user.entity.User;
import com.example.user.exception_handler.InvalidEnumException;
import com.example.user.exception_handler.UserException;
import com.example.user.repository.UserRepository;
import com.example.user.service.SequenceGeneratorService;

@RestController

public class UserController {
	
	@Autowired
	public UserRepository repo;
	
	@Autowired
	public SequenceGeneratorService service;
	
	@PostMapping("/user")
	public User saveUser(@Valid @RequestBody User user) {
		
		user.setId(service.getSequenceNumber("user_sequence"));
		User u = repo.save(user);
		if(u==null)
				throw new UserException("exception");
		/*
		 * URI location = ServletUriComponentsBuilder.fromCurrentRequest()
		 * .path("/user") .buildAndExpand(u.getId()).toUri(); return
		 * ResponseEntity.created(location).build();
		 */
		
		return u;
	}
	
	@GetMapping("/user/{id}")
	public User getUser(@PathVariable int id) {
		return repo.findById(id).get();
	}
	
	@PutMapping("/user/{id}")
	public Optional<Object> updateUser(@PathVariable int id,@RequestBody User user) {
		Optional<User> old = repo.findById(id);
		if(old.isPresent()) {
			old.get().setId(user.getId());
			old.get().setAddress(user.getAddress());
			old.get().setAge(user.getAge());
			old.get().setEmail(user.getEmail());
			old.get().setPhone(user.getPhone());
			old.get().setState(user.getState());
			repo.save(old.get());
			return Optional.of(old);
		}
		return Optional.empty();
	}
	
	@DeleteMapping("/user/{id}")
	public void deleteUser(@PathVariable int id) {
		repo.deleteById(id);
	}

}
