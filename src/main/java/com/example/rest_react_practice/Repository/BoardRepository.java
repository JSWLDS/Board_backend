package com.example.rest_react_practice.Repository;

import com.example.rest_react_practice.Entity.BoardPosts;
import com.example.rest_react_practice.dto.BoardPostsDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BoardRepository extends JpaRepository<BoardPosts, Integer> {

    @Query("SELECT b FROM BoardPosts b WHERE b.typeNo    = :typeNo")
    List<BoardPosts> findByType(@Param("typeNo") Long typeNo);

}
