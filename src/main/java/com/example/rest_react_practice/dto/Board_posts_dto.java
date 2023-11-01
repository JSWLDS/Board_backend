package com.example.rest_react_practice.dto;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Builder
@Data
public class Board_posts_dto {

    private Integer id;

    private String type;

    private String title;

    private String contents;

    private Integer memberNo;

    private LocalDateTime  createdTime;

    private LocalDateTime updatedTime;

    private Integer counts;
}
