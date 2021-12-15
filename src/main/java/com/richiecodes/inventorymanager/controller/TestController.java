//package com.richiecodes.inventorymanager.controller;
//
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@CrossOrigin
//@RestController
//@RequestMapping("/api/test")
//public class TestController {
//
//    @GetMapping("/all")
//    public String allAccess() {
//        return "public content";
//    }
//
//    @GetMapping("/user")
//    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
//    public String userAccess() {
//        return "User content";
//    }
//
//    @GetMapping("/mod")
//    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
//    public String modAccess() {
//        return "Mod content";
//    }
//
//    @GetMapping("/admin")
//    @PreAuthorize("hasRole('ADMIN')")
//    public String adminAccess() {
//        return "Admin content";
//    }
//}
