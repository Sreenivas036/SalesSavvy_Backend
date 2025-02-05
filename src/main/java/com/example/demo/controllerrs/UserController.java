package com.example.demo.controllerrs;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.User;
import com.example.demo.services.UserService;

@RestController
@CrossOrigin
@RequestMapping("/api/users")
public class UserController {
	private UserService userService;
	public UserController(UserService userService) {
		// TODO Auto-generated constructor stub
		this.userService=userService;
	}
	@PostMapping("/register")
	public ResponseEntity<?> registerUser(@RequestBody User user) {
		try {
			User registeredUser = userService.userRegister(user);
			return ResponseEntity.ok(Map.of("message","User registered successfully", "user", registeredUser));
		}
		catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.badRequest().body(Map.of("Error", e.getMessage()));
		}
		
		
	}
}