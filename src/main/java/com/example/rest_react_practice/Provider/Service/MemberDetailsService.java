package com.example.rest_react_practice.Provider.Service;

import com.example.rest_react_practice.Entity.Member;
import com.example.rest_react_practice.Repository.BoardRepository;
import com.example.rest_react_practice.Repository.MemberDetailRepository;
import jakarta.transaction.Transactional;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Transactional
@NoArgsConstructor
@Service
public class MemberDetailsService implements UserDetailsService {

    private MemberDetailRepository repository;


    private PasswordEncoder encoder;


    @Autowired
    public MemberDetailsService(MemberDetailRepository repository, PasswordEncoder encoder) {
        this.repository = repository;
        this.encoder = encoder;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<Member> userDetail = repository.findMemberByUsername(username);

        // Converting userDetail to UserDetails
        return userDetail.map(MemberDetailsImpl::new)
                .orElseThrow(() -> new UsernameNotFoundException("User not found " + username));
    }

    public String addUser(Member userInfo) {
        userInfo.setPassword(encoder.encode(userInfo.getPassword()));
        System.out.println(userInfo.getPassword());
        repository.save(userInfo);
        return "User Added Successfully";
    }


}
