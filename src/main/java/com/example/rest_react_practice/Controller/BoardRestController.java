package com.example.rest_react_practice.Controller;

import com.example.rest_react_practice.Entity.BoardPosts;
import com.example.rest_react_practice.Entity.Member;
import com.example.rest_react_practice.Provider.Service.BoardService;
import com.example.rest_react_practice.Provider.Service.MemberDetailsServiceImpl;
import com.example.rest_react_practice.dto.MemberDto;
import com.example.rest_react_practice.dto.BoardPostsDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.*;

import java.util.List;


// 원래는 이 어노테이션으로 react origin을 허용하였으나 작동되지 않아 front의 proxy 기능을 이용하여 8080포트로 변환하여 요청하게되어 deprected(더 이상 사용하지 않음)
// spring security 버전때문에 적용이 안되었던 걸로 추정. configue를 설정하거나 밑의 @CrossOrigin 어노테이션 둘 중 하나만 써도 작동함.

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class BoardRestController {


    private final BoardService boardService;

    private final MemberDetailsServiceImpl memberDetailsServiceImpl;

    private final MemberDetailsServiceImpl memberDetailsService;

    private final AuthenticationManager authenticationManager;




    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome this endpoint is not secure";
    }

    @PostMapping("/addNewUser")
    public String addNewUser(@RequestBody Member userInfo) {
        return memberDetailsServiceImpl.addUser(userInfo);
    }

//    @GetMapping("/user/userProfile")
//    @PreAuthorize("hasAuthority('ROLE_USER')")
//    public String userProfile() {
//        return "Welcome to User Profile";
//    }
//
//    @GetMapping("/admin/adminProfile")
//    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
//    public String adminProfile() {
//        return "Welcome to Admin Profile";
//    }

    @PostMapping("/login")
    public String authenticateAndGetToken(@RequestBody MemberDto authRequest) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String username = authRequest.getUsername();
        String password = authRequest.getPassword();

        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, passwordEncoder.encode(password)));

        if (authentication.isAuthenticated()) {
            try {
                return memberDetailsService.login(username, password);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } else {
            throw new UsernameNotFoundException("invalid user request !");
        }
    }


    @GetMapping("/board")
    public List<BoardPosts> getAllBoard() {

        return boardService.getAllBoards();
    }


    @GetMapping("/board/type/{typeNo}")
    public List<BoardPostsDto> getAllTypeBoards(@PathVariable Long typeNo) {

        return boardService.getAllTypeBoards(typeNo);
    }

    @GetMapping("/board/{boardId}")
    public ResponseEntity<BoardPosts> getOneBoards(@PathVariable Integer boardId) {

        return boardService.getSearchBoard(boardId);
    }

    @PostMapping("/board")
    public BoardPosts createBoard(@RequestBody BoardPosts board) {
        return boardService.createBoard(board);

    }
    @PatchMapping("/board/{boardId}")
    public void updateCount(@PathVariable Integer boardId){
        String message =  boardService.updateCount(boardId);
        System.out.println(message);

    }

    @GetMapping("/getNickname/{boardId}")
    public void getBoardNickname(@PathVariable Integer boardId){



    }




}