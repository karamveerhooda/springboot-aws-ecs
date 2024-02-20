package com.integrationninjas.springbootexample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.integrationninjas.springbootexample.dto.UserDto;
import com.integrationninjas.springbootexample.dto.DeptDto;
import com.integrationninjas.springbootexample.service.DeptService;
import com.integrationninjas.springbootexample.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private DeptService deptService;

	@GetMapping("/users")
	public ResponseEntity<List<UserDto>> getUsers() {
		List<UserDto> usersList = userService.getUsers();
		return new ResponseEntity<>(usersList, HttpStatus.OK);
	}

	@PostMapping("/users")
	public ResponseEntity<String> createUser(@RequestBody UserDto userDto) {
		try {
			String status = userService.createUser(userDto);
			return new ResponseEntity<>(status, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	/////////
	
	@GetMapping("/dept")
	public ResponseEntity<List<DeptDto>> getDept() {
		List<DeptDto> deptList = deptService.getDept();
		return new ResponseEntity<>(deptList, HttpStatus.OK);
	}

	@PostMapping("/dept")
	public ResponseEntity<String> createDept(@RequestBody DeptDto deptDto) {
		try {
			String status = deptService.createDept(deptDto);
			return new ResponseEntity<>(status, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
