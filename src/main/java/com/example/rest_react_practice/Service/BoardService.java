package com.example.rest_react_practice.Service;

import com.example.rest_react_practice.Entity.Board_posts;
import com.example.rest_react_practice.Repository.BoardRepository;
import com.example.rest_react_practice.dto.Board_posts_dto;
import org.springframework.beans.factory.annotation.Autowired;
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
}
