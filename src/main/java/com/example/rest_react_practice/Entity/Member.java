package com.example.rest_react_practice.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "member")
@Data
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private long memberId;

    @Column(name = "nickname", nullable = false
    )
    private String nickname;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @CreationTimestamp
    @Column(name = "created_date_time")
    @JsonFormat(pattern = "yyyy.MM.dd HH:mm")
    private LocalDateTime createdTime;


    @CreationTimestamp
    @Column(name = "updated_date_time")
    @JsonFormat(pattern = "yyyy.MM.dd HH:mm")
    private LocalDateTime updatedTime;


    @Column(name = "roles", nullable = false)
    private String roles;

//    @ManyToOne
//    @JoinColumn(name = "member_id")
//    private BoardPosts boardPosts;

}