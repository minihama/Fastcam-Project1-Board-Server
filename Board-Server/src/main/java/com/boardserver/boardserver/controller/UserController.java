package com.boardserver.boardserver.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.extern.log4j.Log4j2;

import com.boardserver.boardserver.dto.UserDTO;
import com.boardserver.boardserver.dto.request.*;
import com.boardserver.boardserver.dto.response.*;
import com.boardserver.boardserver.service.impl.UserServiceImpl;
import com.boardserver.boardserver.utils.SessionUtil;

import jakarta.servlet.http.HttpSession;

// REST API 기반으로 만들어야 하기에 RestController을 추가
// 실제 RequestMapping 을 통해서 controller를 통한 url에 스킴을 설계
@RestController
@RequestMapping("/users")
@Log4j2
public class UserController {
    // 바로 로직을 처리 할 수 없기 때문에 서비스 단의 로직을 생성
    // userservice 는 인터페이스를 구현 할 예정임으로 imp로 작성
    private final UserServiceImpl userService;
    private static LoginResponse loginResponse;
    // 컨트롤러에 생성자 추가
    @Autowired
    public UserController(UserServiceImpl userService){
        this.userService = userService;
    }


    @PostMapping("sign-up")
    @ResponseStatus(HttpStatus.CREATED)
    public void singUp(@RequestBody UserDTO userDTO){
        if (UserDTO.hashNullDataBeforeRegister(userDTO)){
            throw new RuntimeException("회원가입 정보를 확인해 주세요.");
        }
        userService.register(userDTO);
    }

    @PostMapping("sign-in")
    public HttpStatus login(@RequestBody UserLoginRequest userLoginRequest, HttpSession session) {
        ResponseEntity<LoginResponse> responseEntity = null;
        String id = userLoginRequest.getUserId();
        String password = userLoginRequest.getPassword();

        UserDTO userInfo = userService.login(id,password);
        if (userInfo == null){
            return HttpStatus.NOT_FOUND;
        }else if(userInfo != null){
            loginResponse = LoginResponse.success(userInfo);
            if (userInfo.getStatus() == (UserDTO.Status.ADMIN))
                SessionUtil.setLoginAdminId(session,id);
                else 
                    SessionUtil.setLoginMemberId(session,id);

                    responseEntity = new ResponseEntity<LoginResponse>(loginResponse, HttpStatus.OK);
        } else {
            throw new RuntimeException("Lonin Error!  유저 정보가 없거나 지원되지 않는 유저 입니다.");
        }
        return HttpStatus.OK;
    }

    @GetMapping("my-info")
    public UserInfoResponse memperInfo(HttpSession session){
        String id = SessionUtil.getLoginMemberId(session);
        if (id == null) id = SessionUtil.getLoginAdminId(session);
        UserDTO memberInfo = userService.getUserInfo(id);
        return new UserInfoResponse(memberInfo);
    }

    @PutMapping("logout")
    public void logout(HttpSession session){
        SessionUtil.clear(session);
    }

    @PatchMapping("password")
    public ResponseEntity<LoginResponse> updateUserPassword(@RequestBody UserUpdatePasswordRequest userUpdatePasswordRequest, HttpSession session) {
        ResponseEntity<LoginResponse> responseEntity = null;

        String id = SessionUtil.getLoginMemberId(session);
        String beforePassword = userUpdatePasswordRequest.getBeforePassword();
        String afterPassword = userUpdatePasswordRequest.getAfterPassword();

        try {
            userService.updatePassword(id, beforePassword, afterPassword);
            ResponseEntity.ok(new ResponseEntity<LoginResponse>(loginResponse, HttpStatus.OK));
        } catch (IllegalArgumentException e) {
            log.error("updatePassword 실패",e);
            responseEntity = new ResponseEntity<LoginResponse>(HttpStatus.BAD_REQUEST);
        }
        return responseEntity;
    }

    @DeleteMapping
    public ResponseEntity<LoginResponse> deleteId(@RequestBody UserDeleteId userDeleteId, HttpSession session){
        ResponseEntity<LoginResponse> responseEntity = null;
        String id = SessionUtil.getLoginMemberId(session);

        try {
            userService.deleteId(id,userDeleteId.getPassword());
            responseEntity = new ResponseEntity<LoginResponse>(loginResponse, HttpStatus.OK);
        } catch (RuntimeException e){
            log.error("deleteId 실패");
            responseEntity = new ResponseEntity<LoginResponse>(HttpStatus.BAD_REQUEST);
        }
        return responseEntity;
    }
}
