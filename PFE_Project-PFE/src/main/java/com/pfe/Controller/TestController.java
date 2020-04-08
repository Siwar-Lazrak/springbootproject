package com.pfe.Controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Optional;
import java.util.Set;

import javax.management.relation.RelationNotFoundException;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.pfe.Model.ERole;
import com.pfe.Model.Role;
import com.pfe.Model.User;
import com.pfe.Repository.RoleRepository;
import com.pfe.Repository.SousModuleRepository;
import com.pfe.Repository.UserRepository;
import com.pfe.Request.SignupRequest;
import com.pfe.Response.MessageResponse;
import com.pfe.Service.JwtUtils;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class TestController {
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	RoleRepository roleRepository;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	JwtUtils jwtUtils;
	
	@Autowired
	SousModuleRepository sousModuleRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@ApiOperation(value = "interface access")
	@GetMapping("/all")
	public String allAccess() {
		return "Public Content.";
	}
	
	@GetMapping("/user")
	@PreAuthorize("hasRole('USER')")
	public String userAccess() {
		return "User Content.";
	}

	@GetMapping("/superadmin")
	@PreAuthorize("hasRole('SUPERADMIN')")
	public String moderatorAccess() {
		return "Moderator Board.";
	}

	@GetMapping("/admin")
	@PreAuthorize("hasRole('ADMIN')")
	public String adminAccess() {
		return "Admin";
	}
	

		@PostMapping("/signup")
		@PreAuthorize("hasRole('ADMIN')")
		public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
			if (userRepository.existsByUsername(signUpRequest.getUsername())) {
				return ResponseEntity
						.badRequest()
						.body(new MessageResponse("Error: Username is already taken!"));
			}

			if (userRepository.existsByEmail(signUpRequest.getEmail())) {
				return ResponseEntity
						.badRequest()
						.body(new MessageResponse("Error: Email is already in use!"));
			}

			// Create new user's account
			User user = new User(signUpRequest.getUsername(), 
								 signUpRequest.getEmail(),
								 encoder.encode(signUpRequest.getPassword()),
								 null);
	
			Set<String> strRoles = signUpRequest.getRole();
			Set<Role> roles = new HashSet<>();
			
			
			if (strRoles == null) {
				Role userRole = roleRepository.findByName(ERole.ROLE_USER)
						.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
				roles.add(userRole);
			} else {
				strRoles.forEach(role -> {
					switch (role) {
					case "admin":
						Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
								.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
						roles.add(adminRole);

						break;
					case "superadmin":
						Role modRole = roleRepository.findByName(ERole.ROLE_SUPERADMIN)
								.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
						roles.add(modRole);

						break;
					default:
						Role userRole = roleRepository.findByName(ERole.ROLE_USER)
								.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
						roles.add(userRole);
					}
				});
			}

			user.setRoles(roles);
			userRepository.save(user);

			return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
		}
	
	 
	@GetMapping("/getAllusers")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	  public ResponseEntity<List<User>> getAllUsers() {
	    List<User> users = new ArrayList<>();
	    try {
	      userRepository.findAll().forEach(users::add);
	      
	      if (users.isEmpty()) {
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	      }
	      return new ResponseEntity<>(users, HttpStatus.OK);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	
	/*
	 * @GetMapping("/getUserById/{id}")
	 * 
	 * @PreAuthorize("hasRole('ADMIN')") public ResponseEntity<User>
	 * getUserById(@PathVariable("id") Integer id) { Optional<User> userData =
	 * userRepository.findById(id);
	 * 
	 * if (userData.isPresent()) { return new ResponseEntity<>(userData.get(),
	 * HttpStatus.OK); } else { return new ResponseEntity<>(HttpStatus.NOT_FOUND); }
	 * }
	 */
	
	//
	@GetMapping("/user/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<User> getUserById(@PathVariable(value = "id") Integer id)
			throws RelationNotFoundException {
		User user = userRepository.findById(id)
				.orElseThrow(() -> new RelationNotFoundException("Employee not found for this id :: " + id));
		return ResponseEntity.ok().body(user);
	}
	//
	
	
	
	
	
	
	 @DeleteMapping("/users/{id}")
	 @PreAuthorize("hasRole('ADMIN')")
	  public ResponseEntity<HttpStatus> deleteUser(@PathVariable("id") Integer id) {
	    try {
	      userRepository.deleteById(id);
	      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
	    }
	  }
	  @DeleteMapping("/users")
	  @PreAuthorize("hasRole('ADMIN')")
	  public ResponseEntity<HttpStatus> deleteAllUsers() {
	    try {
	      userRepository.deleteAll();
	      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
	    }
	 
	  }
	  
	  @GetMapping(value = "users/email/{email}")
	  @PreAuthorize("hasRole('ADMIN')")
	  public ResponseEntity<List<User>> findByEmail(@PathVariable String email) {
	    try {
	      List<User> users = userRepository.findByEmail(email);
	 
	      if (users.isEmpty()) {
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	      }
	      return new ResponseEntity<>(users, HttpStatus.OK);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
	    }
	  }
	  
	  @PutMapping("/update/{id}")
	  @PreAuthorize("hasRole('ADMIN')")
	  public ResponseEntity<User> updateUser(@PathVariable("id") Integer id, @RequestBody User user) {
	    Optional<User> userData = userRepository.findById(id);
	 
	    if (userData.isPresent()) {
	    	User _user = userData.get();
	      _user.setUsername(user.getUsername());
	      _user.setEmail(user.getEmail());
	      _user.setPassword(encoder.encode(user.getPassword()));
	      
	  
	      
	      return new ResponseEntity<>(userRepository.save(_user), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
	

}
