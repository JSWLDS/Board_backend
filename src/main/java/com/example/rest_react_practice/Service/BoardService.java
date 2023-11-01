package com.example.rest_react_practice.Controller;

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
}
