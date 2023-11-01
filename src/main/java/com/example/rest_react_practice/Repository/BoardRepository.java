package com.example.rest_react_practice.Repository;

import com.example.rest_react_practice.Entity.Board_posts;
import com.example.rest_react_practice.dto.Board_posts_dto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board_posts, Integer> {
}
