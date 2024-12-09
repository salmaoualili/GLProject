package Mp.example.demoM.controllers;

import Mp.example.demoM.Entities.Admin;
import Mp.example.demoM.Entities.User;
import Mp.example.demoM.payload.Request.LoginRequest;
import Mp.example.demoM.payload.Request.SignupRequest;
import Mp.example.demoM.services.AdminService;
import Mp.example.demoM.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class Authocontroller {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;

    @Autowired
    private AdminService adminService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        return ResponseEntity.ok("Authentication successful!");
    }

    @PostMapping("/signup/user")
    public ResponseEntity<?> registerUser(@RequestBody SignupRequest signupRequest) {
        if (userService.existsByemail(signupRequest.getEmail())) {
            return ResponseEntity.badRequest().body("Error: Email is already in use!");
        }

        User user = new User();
        user.setemail(signupRequest.getEmail());
        user.setpassword(passwordEncoder.encode(signupRequest.getPassword()));
        user.setnomComplet(signupRequest.getNomComplet());

        userService.saveUser(user);

        return ResponseEntity.ok("User registered successfully!");
    }

    @PostMapping("/signup/admin")
    public ResponseEntity<?> registerAdmin(@RequestBody SignupRequest signupRequest) {
        if (adminService.existsByEmail(signupRequest.getEmail())) {
            return ResponseEntity.badRequest().body("Error: Email is already in use!");
        }

        Admin admin = new Admin();
        admin.setemail(signupRequest.getEmail());
        admin.setPassword(passwordEncoder.encode(signupRequest.getPassword()));
        admin.setNomComplet(signupRequest.getNomComplet());

        adminService.saveAdmin(admin);

        return ResponseEntity.ok("Admin registered successfully!");
    }
}
