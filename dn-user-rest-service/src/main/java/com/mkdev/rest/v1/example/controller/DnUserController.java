package com.mkdev.rest.v1.example.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mkdev.rest.v1.example.exception.DnResourceNotFoundException;
import com.mkdev.rest.v1.example.model.DnUser;
import com.mkdev.rest.v1.example.service.DnUserService;

/**
 * @author Muthukumar Thangavinayagam
 * @date 2020-May-02 6:15:37 pm
 */
@RestController
@RequestMapping("/api/v1")
public class DnUserController {

	@Autowired
	DnUserService service;

	@GetMapping("/users")
	public List<DnUser> getAllUsers() throws DnResourceNotFoundException {
		return service.getUserList();
	}

	@GetMapping("/users/{id}")
	public ResponseEntity<DnUser> getUserById(@PathVariable("id") Optional<Long> id)
			throws DnResourceNotFoundException {
		if (id.isPresent()) {
			DnUser user = service.getUserById(id.get());
			return ResponseEntity.ok().body(user);
		} else {
			throw new DnResourceNotFoundException("User not found on :: " + id);
		}
	}

	@PostMapping("/users")
	public ResponseEntity<DnUser> createUser(@Valid @RequestBody DnUser user) {
		final DnUser updatedUser = service.createOrUpdateUser(user);

		return ResponseEntity.status(HttpStatus.CREATED).body(updatedUser);
	}

	@DeleteMapping("/user/{id}")
	public Map<String, Boolean> deleteUser(@PathVariable(value = "id") Long userId) throws Exception {

		service.deleteUserById(userId);
		Map<String, Boolean> response = new HashMap<String, Boolean>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

}
