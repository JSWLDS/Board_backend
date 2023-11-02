package com.example.rest_react_practice.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "Board_posts")
@DynamicInsert
@DynamicUpdate
@Data
public class Board_posts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "type")
    private String type;

    @Column(name = "title")
    private String title;

    @Column(name = "contents", columnDefinition = "TEXT", nullable = false)
    private String contents;

    @Column(name = "member_id")
    private Integer memberNo;

    @CreationTimestamp
    @Column(name = "created_date_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime  createdTime;

    @UpdateTimestamp
    @Column(name = "updated_date_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updatedTime;

    @Column(columnDefinition = "bigint default 0", nullable = false, name = "counts")
    @ColumnDefault("0") // java영역에서 효과 없음 : java의 lombok영역에서 값의 유무를 판단하기에 not null 조건에 위배되는 것 같다.
    private Long counts = 0L; // 그래서 기본 값을 0으로 java 영역에서 주었다.

//    @PrePersist
//    public void onPrePersist() {
//        this.createdTime = LocalDateTime.parse(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
//        this.updatedTime = this.createdTime;
//
//    }
//
//    @PreUpdate
//    public void onPreUpdate(){
//        this.updatedTime = LocalDateTime.parse(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
//    }

}
