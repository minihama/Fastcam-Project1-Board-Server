package main.java.com.boardserver.boardserver.service;

import com.boardserver.boardserver.dto.UserDTO;

public class UserService {
    // userservice 는 메서드의 시그니처만 작성하고 메서드 내용은 작성 안함

    // user의 회원가입
    void register(UserDTO userProfile);
    // 로그인
    UserDTO login(String id, String password);
    // 중복
    boolean idDuplicatedID(String id);
    // 정보
    UserDTO getUserInfo(String userId);
    // 패스워드 변경
    void updatePassword(String id, Sting beforePassword, String afterPassword);
    // 삭제
    void deleteId(String id, String password);
}
