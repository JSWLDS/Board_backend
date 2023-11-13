package com.example.rest_react_practice.Controller;

import com.example.rest_react_practice.Entity.Board_posts;
import com.example.rest_react_practice.Service.BoardService;
import com.example.rest_react_practice.dto.Board_posts_dto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.*;

import java.util.List;


// 원래는 이 어노테이션으로 react origin을 허용하였으나 작동되지 않아 front의 proxy 기능을 이용하여 8080포트로 변환하여 요청하게되어 deprected(더 이상 사용하지 않음)
// 사용 안하는 줄 알았으나 게시글 자세히 보기를 누를 때 에러가 나는 것이 확인 됨. 이 어노테이션을 부여하여 문제를 해결함.
// 아마 내보낼 때 필요한게 아닐까..
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class BoardRestController {


    private BoardService boardService;

    @Autowired
    public BoardRestController(BoardService boardService) {
        this.boardService = boardService;
    }


    @GetMapping("/board")
    public List<Board_posts> getAllBoards() {

        return boardService.getAllBoard();
    }

    @GetMapping("/board/{boardId}")
    public ResponseEntity<Board_posts> getOneBoards(@PathVariable Integer boardId) {
        return boardService.getSearchBoard(boardId);
    }

    @PostMapping("/board")
    public Board_posts createBoard(@RequestBody Board_posts board) {
        return boardService.createBoard(board);

    }
    @PatchMapping("/board/{boardId}")
    public void updateCount(@PathVariable Integer boardId){
        String message =  boardService.updateCount(boardId);
        System.out.println(message);

    }
}