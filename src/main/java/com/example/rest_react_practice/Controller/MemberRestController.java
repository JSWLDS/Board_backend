package com.example.rest_react_practice.Controller;

import com.example.rest_react_practice.Entity.Member;
import com.example.rest_react_practice.Provider.JwtAuthenticationProvider;
import com.example.rest_react_practice.Provider.Service.MemberDetailsServiceImpl;
import com.example.rest_react_practice.dto.MemberDto;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class MemberRestController {

    private MemberDetailsServiceImpl memberDetailsServiceImpl;



    private AuthenticationManager authenticationManager;

    @PostMapping("/addNewUser")
    public String addNewUser(@RequestBody Member userInfo) {
        System.out.println("success adNewUSer");
        return memberDetailsServiceImpl.addUser(userInfo);
    }

    @PostMapping("/login")
    public String authenticateAndGetToken(@RequestBody MemberDto memberDto) {
//        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(memberDto.getUsername(), memberDto.getPassword()));
//        if (authentication.isAuthenticated()) {
//            return jwtAuthProvider.generateToken(memberDto.getUsername());
//        } else {
//            throw new UsernameNotFoundException("invalid user request !");
//        }
        String username = memberDto.getUsername();
        String password = memberDto.getPassword();
        try {
            return memberDetailsServiceImpl.login(username, password);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }



}