package com.example.rest_react_practice.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class MemberIdDto {
    Long memberId;
    String nickname;

}
