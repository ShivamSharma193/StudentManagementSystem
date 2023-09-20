package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.HomeDto;
import com.app.dto.LoginDto;
import com.app.entity.enums.Role;
import com.app.service.LoginService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
//@RequestMapping("/login")
public class LoginController {
	
    @Autowired
	private LoginService loginService;
    
//    @PostMapping("/login")
    @GetMapping("/login/{username}/{password}/{role}")
    public HomeDto validateLogin(@PathVariable String username,@PathVariable String password, @PathVariable String role){
    	
//    	try {	
//    	
//    	return new ResponseEntity<>(loginService.validateLogin(login),HttpStatus.OK);
//    	}
//    	catch(RuntimeException e){
//    		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage()));
//    	}
    	
    	
    	LoginDto login = new LoginDto(username,password,Role.valueOf(role));
    		return loginService.validateLogin(login);
    	
    }
	
	
	
	
}
