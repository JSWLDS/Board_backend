package com.example.rest_react_practice.Controller;

import com.example.rest_react_practice.Entity.BoardPosts;
import com.example.rest_react_practice.Entity.Member;
import com.example.rest_react_practice.Provider.JwtAuthenticationProvider;
import com.example.rest_react_practice.Provider.Service.MemberDetailsServiceImpl;
import com.example.rest_react_practice.dto.MemberDto;
import com.example.rest_react_practice.exception.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
            String jwt = memberDetailsServiceImpl.login(username, password);
            
            System.out.println(jwt+"-----------------------------------jwt");
            
            return jwt;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }



    @GetMapping("/getMemberId/{jwt}")
    public ResponseEntity<Long> extractJwt(@PathVariable String jwt) {
        if (!memberDetailsServiceImpl.isTokenExpired(jwt)) {
            // 토큰이 만료되지 않았을 경우에만 memberId를 추출하고 응답함.
            Long memberId = memberDetailsServiceImpl.jwtExtractMemberId(jwt);
            return ResponseEntity.ok(memberId);
        } else {
            // 토큰이 만료되었을 경우 403 Forbidden 상태로 응답함.
            System.out.println(jwt + "---토큰 만료됨.");
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
    }

    @GetMapping("/getNickname/{memberId}")
    public String getBoardNickname(@PathVariable Integer memberId) {
        String nickname = memberDetailsServiceImpl.findByIdOfNickname(memberId);
        return nickname;
    }


//    @GetMapping("/getNickname/{jwt}")
//    public ResponseEntity<String> extractJwtNickname(@PathVariable String jwt) {
//        if (!memberDetailsServiceImpl.isTokenExpired(jwt)) {
//            // 토큰이 만료되지 않았을 경우에만 memberId를 추출하고 응답함.
//            String nickname = memberDetailsServiceImpl.jwtExtractNickname(jwt);
//            return ResponseEntity.ok(nickname);
//        } else {
//            // 토큰이 만료되었을 경우 403 Forbidden 상태로 응답함.
//            System.out.println(jwt + "---토큰 만료됨.");
//            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
//        }
//    }

    @GetMapping("/isTokenExpired/{jwt}")
    public boolean isTokenExpired(@PathVariable String jwt) {
       return memberDetailsServiceImpl.isTokenExpired(jwt);
    }


}