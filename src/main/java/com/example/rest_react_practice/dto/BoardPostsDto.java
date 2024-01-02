package com.example.rest_react_practice.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@Getter
public class BoardPostsDto {

    private Long boardId;

    private Long typeNo;

    private String title;

    private String contents;

    private Long memberId;

    @JsonFormat(pattern = "yyyy.MM.dd HH:mm")
    private LocalDateTime  createdTime;

    @JsonFormat(pattern = "yyyy.MM.dd HH:mm")
    private LocalDateTime updatedTime;

    private Long counts;


}
