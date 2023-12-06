package com.example.rest_react_practice.Repository;

import com.example.rest_react_practice.Entity.BoardPosts;
import com.example.rest_react_practice.Entity.Member;
import com.example.rest_react_practice.dto.BoardPostsDto;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface BoardRepository extends JpaRepository<BoardPosts, Integer> {

    @Query("SELECT b FROM BoardPosts b WHERE b.typeNo = :typeNo ORDER BY b.boardId DESC")
    List<BoardPosts> findByType(@Param("typeNo") Long typeNo);

    @Query("SELECT b FROM BoardPosts b ORDER BY b.boardId DESC ")
    List<BoardPosts> findAllBoards();

}
