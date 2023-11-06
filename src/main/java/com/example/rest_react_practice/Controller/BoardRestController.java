package com.example.rest_react_practice.Controller;

import com.example.rest_react_practice.Entity.Board_posts;
import com.example.rest_react_practice.Service.BoardService;
import com.example.rest_react_practice.dto.Board_posts_dto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class BoardRestController {


    @Autowired
    private BoardService boardService;

    @GetMapping("/board")
    public List<Board_posts> getAllBoards() {

        return boardService.getAllBoard();
    }

    @GetMapping("/board/{id}")
    public ResponseEntity<Board_posts> getOneBoards(@PathVariable Integer id) {
        return boardService.getSearchBoard(id);
    }

    @PostMapping("/board")
    public Board_posts createBoard(@RequestBody Board_posts board) {
        return boardService.createBoard(board);

    }
    @PatchMapping("/board/{id}")
    public void updateCount(@PathVariable Integer id){
        String message =  boardService.updateCount(id);
        System.out.println(message);

    }
}