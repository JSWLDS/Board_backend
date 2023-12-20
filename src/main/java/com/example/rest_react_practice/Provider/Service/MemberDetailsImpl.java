package com.example.rest_react_practice.Provider.Service;

import com.example.rest_react_practice.Entity.Member;
import com.example.rest_react_practice.Entity.UserRoleEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


@RequiredArgsConstructor
public class MemberDetailsImpl implements UserDetails {

//    private List<GrantedAuthority> authorities;
    private final Member member;



    @Override
    public String getPassword() {
        return member.getPassword();
    }

    @Override
    public String getUsername() {
        return member.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        String roles = member.getRoles();

        List<SimpleGrantedAuthority> rolesArray = Arrays.stream(roles.split(","))
                .map(SimpleGrantedAuthority :: new)
                .collect(Collectors.toList());


        Collection<GrantedAuthority> authorities = new ArrayList<>();

        authorities.add((GrantedAuthority) rolesArray);

        return authorities;
    }
}