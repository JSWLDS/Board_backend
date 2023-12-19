package com.example.rest_react_practice.Provider.Service;

import com.example.rest_react_practice.Config.Configure.PasswordEncoderConfig;
import com.example.rest_react_practice.Entity.Member;
import com.example.rest_react_practice.Provider.JwtAuthenticationProvider;
import com.example.rest_react_practice.Repository.MemberDetailRepository;
import jakarta.transaction.Transactional;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Transactional
@RequiredArgsConstructor
@Service
public class MemberDetailsServiceImpl implements UserDetailsService {

    private final MemberDetailRepository memberDetailRepository;

    private final JwtAuthenticationProvider jwtAuthenticationProvider;

    private final BCryptPasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<Member> userDetail = memberDetailRepository.findMemberByUsername(username);

        // Converting userDetail to UserDetails
        return userDetail.map(MemberDetailsImpl::new)
                .orElseThrow(() -> new UsernameNotFoundException("User not found " + username));
    }

    public String addUser(Member userInfo) {
        String username = userInfo.getUsername();

        // 중복된 사용자 ID 체크
        Optional<Member> found = memberDetailRepository.findMemberByUsername(username);
        if (found.isPresent()) {
            throw new IllegalArgumentException("중복된 사용자 ID가 존재합니다.");
        }

        // 비밀번호가 null이면 예외 처리 또는 기본값 설정
        if (userInfo.getPassword() == null) {
            // 여기서는 예외를 던지도록 했지만, 실제로는 상황에 따라 다르게 처리 가능
            throw new IllegalArgumentException("비밀번호는 null일 수 없습니다.");
        }

        // 비밀번호 해시화
        userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
        System.out.println(userInfo.getPassword());

        // 저장
        memberDetailRepository.save(userInfo);

        return "User Added Successfully";
    }

    public String login(String username, String password) throws Exception {
        Optional<Member> found = memberDetailRepository.findMemberByUsername(username);
        MemberDetailsImpl memberDetails = found.map(MemberDetailsImpl::new)
                .orElseThrow(()-> new UsernameNotFoundException("User not found " + username));
        if(!passwordEncoder.matches(password, memberDetails.getPassword())){

            throw new UsernameNotFoundException("Invalid password for user " + username);

        }else {

            return jwtAuthenticationProvider.generateToken(username);
        }

    }


}
