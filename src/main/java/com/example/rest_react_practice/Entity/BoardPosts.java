package com.example.rest_react_practice.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "board_posts")
@DynamicInsert
@DynamicUpdate
@RequiredArgsConstructor
@Data
public class BoardPosts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_id")
    private Long boardId;

    @Column(name = "type_number")
    private Long typeNo;

    @Column(name = "title")
    private String title;

    @Column(name = "contents", columnDefinition = "TEXT", nullable = false)
    private String contents;

    @Column(name = "member_id")
    private Long memberId;

    @CreationTimestamp
    @Column(name = "created_date_time")
    @JsonFormat(pattern = "yyyy.MM.dd HH:mm")
    private LocalDateTime  createdTime;


    @CreationTimestamp
    @Column(name = "updated_date_time")
    @JsonFormat(pattern = "yyyy.MM.dd HH:mm")
    private LocalDateTime updatedTime;

    @Column(columnDefinition = "bigint default 0", nullable = false, name = "counts")
    @ColumnDefault("0") // java영역에서 효과 없음 : java의 lombok영역에서 값의 유무를 판단하기에 not null 조건에 위배되는 것 같다.
    private Long counts = 0L; // 그래서 기본 값을 0으로 java 영역에서 주었다.

//    @OneToMany(mappedBy = "member_id") // 양방향 관계 설정
//    private List<Member> members = new ArrayList<>();


//    @PrePersist //전에 처리
//    public void onPrePersist() {
//        this.createdTime = LocalDateTime.parse(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
//        this.updatedTime = this.createdTime;
//
//    }
//
//    @PreUpdate // 업데이트 후 처리
//    public void onPreUpdate(){
//        this.updatedTime = LocalDateTime.parse(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
//    }

}
