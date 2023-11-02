package com.example.rest_react_practice.Service;

import com.example.rest_react_practice.Entity.Board_posts;
import com.example.rest_react_practice.Repository.BoardRepository;
import com.example.rest_react_practice.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

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

    public ResponseEntity<Board_posts> getSearchBoard(Integer id) {
        Board_posts board_posts = boardRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Not exits Board Data by no : ["+ id +"]"));
        return ResponseEntity.ok(board_posts);
    }
}
