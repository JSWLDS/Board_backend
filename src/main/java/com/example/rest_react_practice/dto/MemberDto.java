package com.example.rest_react_practice.dto;

import com.example.rest_react_practice.Entity.Member;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberDto extends Member {

    private String username;
    private String password;

}