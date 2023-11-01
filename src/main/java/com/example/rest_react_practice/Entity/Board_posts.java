package com.example.rest_react_practice.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "Board_posts")
@DynamicInsert
@DynamicUpdate
@RequiredArgsConstructor
@Data
public class Board_posts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "type")
    private String type;

    @Column(name = "title")
    private String title;

    @Column(name = "contents")
    private String contents;

    @Column(name = "member_id")
    private Integer memberNo;

    @CreationTimestamp
    @Column(name = "created_date_time")
    private LocalDateTime  createdTime;

    @UpdateTimestamp
    @Column(name = "updated_date_time")
    private LocalDateTime updatedTime;

    @Column(columnDefinition = "integer default 0", nullable = false, name = "counts")
    private Integer counts;
}
