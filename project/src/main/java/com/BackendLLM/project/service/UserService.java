package com.BackendLLM.project.service;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BackendLLM.project.entity.User;
import com.BackendLLM.project.repository.UserRepository;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;

    public User registerUser(User user) {
        //  Generate a unique referral code for the new user
        user.setReferralCode(UUID.randomUUID().toString().substring(0, 6));

        //  Handle referral tracking
        if (user.getReferredBy() != null) { 
            Optional<User> referrer = userRepository.findByReferralCode(user.getReferredBy());
            referrer.ifPresent(value -> user.setReferredBy(value.getReferralCode())); //  Store referral code, NOT User object
        }
        
        return userRepository.save(user);
    }

    public boolean markProfileCompleted(Long userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            user.setProfileCompleted(true);
            userRepository.save(user);
            return true;
        }
        return false;
    }

    public List<User> getReferrals(Long userId) {
        Optional<User> referrer = userRepository.findById(userId);
        if (referrer.isPresent()) {
            String referrerCode = referrer.get().getReferralCode(); // Get the referral code
            return userRepository.findAll()
                    .stream()
                    .filter(user -> referrerCode.equals(user.getReferredBy()) && user.isProfileCompleted()) // Compare with referralCode
                    .toList();
        }
        return Collections.emptyList(); // Return empty list if referrer not found
    }
    
    //All referral report
    public List<Map<String, Object>> getReferralReport() {
        List<User> users = userRepository.findAll();
        
        return users.stream()
                .map(user -> {
                    Map<String, Object> report = new HashMap<>();
                    report.put("userId", user.getId());
                    report.put("name", user.getName());
                    report.put("email", user.getEmail());
                    report.put("referralCode", user.getReferralCode());

                    // Count successful referrals (only users who completed their profile)
                    long successfulReferrals = users.stream()
                            .filter(u -> user.getReferralCode().equals(u.getReferredBy()) && u.isProfileCompleted())
                            .count();

                    report.put("successfulReferrals", successfulReferrals);
                    return report;
                })
                .collect(Collectors.toList());
    }

}
