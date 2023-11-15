package com.example.rest_react_practice.Service;

import com.example.rest_react_practice.Entity.BoardPosts;
import com.example.rest_react_practice.Repository.BoardRepository;
import com.example.rest_react_practice.dto.BoardPostsDto;
import com.example.rest_react_practice.exception.ResourceNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Transactional
@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;

    public List<BoardPosts> getAllBoards() {
        return boardRepository.findAll();
    }

    public List<BoardPostsDto> getAllTypeBoards(Long typeNo) {

        List<BoardPosts> boardPosts = boardRepository.findByType(typeNo);

        // BoardPosts를 BoardPostsDto로 변환
        List<BoardPostsDto> boardPostsDtos = boardPosts.stream()
                .map(boardPostsEntity -> {
                    return BoardPostsDto.builder()
                            .boardId(boardPostsEntity.getBoardId())
                            .typeNo(boardPostsEntity.getTypeNo())
                            .title(boardPostsEntity.getTitle())
                            .contents(boardPostsEntity.getContents())
                            .userId(boardPostsEntity.getUserId())
                            .createdTime(boardPostsEntity.getCreatedTime())
                            .updatedTime(boardPostsEntity.getUpdatedTime())
                            .counts(boardPostsEntity.getCounts())
                            .build();
                })
                .collect(Collectors.toList());
        return boardPostsDtos;
    }
    public BoardPosts createBoard(BoardPosts board) {
        return boardRepository.save(board);
    }

    public ResponseEntity<BoardPosts> getSearchBoard(Integer boardId) {
        BoardPosts board_posts = boardRepository.findById(boardId).orElseThrow(()-> new ResourceNotFoundException("Not exits Board Data by no : ["+ boardId +"]"));
        return ResponseEntity.ok(board_posts);
    }
    
    //조회수 증가
    public String updateCount(Integer boardId) {
        BoardPosts board_posts = getSearchBoard(boardId).getBody(); // 조회수를 증가시킬 게시글을 찾아서 객체로 저장.
        long newCount = board_posts.getCounts()+1; // 찾은 객체의 조회수를 1높인 수를 저장.
        board_posts.setCounts(newCount); // 1 높인 조회수를 찾은 객체 조회수에 저장.

        boardRepository.save(board_posts); // 조회수가 업데이트된 객체를 저장(덮어쓰기)
        return "update count successful";
    }
}
