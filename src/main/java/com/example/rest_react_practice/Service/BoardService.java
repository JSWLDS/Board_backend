package com.example.rest_react_practice.Service;

import com.example.rest_react_practice.Entity.Board_posts;
import com.example.rest_react_practice.Repository.BoardRepository;
import com.example.rest_react_practice.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;

    public List<Board_posts> getAllBoard() {
        return boardRepository.findAll();
    }
    public Board_posts createBoard(Board_posts board) {
        return boardRepository.save(board);
    }

    public ResponseEntity<Board_posts> getSearchBoard(Integer boardId) {
        Board_posts board_posts = boardRepository.findById(boardId).orElseThrow(()-> new ResourceNotFoundException("Not exits Board Data by no : ["+ boardId +"]"));
        return ResponseEntity.ok(board_posts);
    }
    
    //조회수 증가
    public String updateCount(Integer boardId) {
        Board_posts board_posts = getSearchBoard(boardId).getBody(); // 조회수를 증가시킬 게시글을 찾아서 객체로 저장.
        long newCount = board_posts.getCounts()+1; // 찾은 객체의 조회수를 1높인 수를 저장.
        board_posts.setCounts(newCount); // 1 높인 조회수를 찾은 객체 조회수에 저장.

        boardRepository.save(board_posts); // 조회수가 업데이트된 객체를 저장(덮어쓰기)
        return "update count successful";
    }
}
