package com.richiecodes.inventorymanager.controller;

import com.richiecodes.inventorymanager.service.JwtUserDetailsService;
import com.richiecodes.inventorymanager.util.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class JwtAuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private JwtUserDetailsService userDetailsService;

//    @PostMapping("/api/authenticate")
//    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequestToken)
}
