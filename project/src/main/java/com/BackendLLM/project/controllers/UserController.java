package com.BackendLLM.project.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.BackendLLM.project.entity.User;
import com.BackendLLM.project.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
    
    @Autowired
    private UserService userService;

    //  Signup API
    @PostMapping("/signup")
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        User savedUser = userService.registerUser(user);
        return ResponseEntity.ok(savedUser);
    }

    //  Profile Completion API
    @PutMapping("/{userId}/complete-profile")
    public ResponseEntity<String> completeProfile(@PathVariable Long userId) {
        boolean success = userService.markProfileCompleted(userId);
        if (success) {
            return ResponseEntity.ok("Profile completed successfully.");
        }
        return ResponseEntity.badRequest().body("User not found.");
    }
    
    // It list out Successfull referral only the one who completed their profile
    @GetMapping("/{userId}/referrals")
    public ResponseEntity<List<User>> getUserReferrals(@PathVariable Long userId) {
        List<User> referrals = userService.getReferrals(userId);
        return ResponseEntity.ok(referrals);
    }
    
    //Provide the referral-report in json
    @GetMapping("/referral-report")
    public ResponseEntity<List<Map<String, Object>>> getReferralReport() {
        return ResponseEntity.ok(userService.getReferralReport());
    }


}
