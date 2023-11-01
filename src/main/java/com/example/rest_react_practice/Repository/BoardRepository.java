package com.example.rest_react_practice.Service;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board_posts, Integer> {
}
