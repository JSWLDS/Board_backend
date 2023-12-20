package com.example.rest_react_practice.dto;


import com.example.rest_react_practice.Entity.UserRoleEnum;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class MemberAuthorityDto {

    String username;

    @Enumerated(value = EnumType.STRING)
    UserRoleEnum role;
}
