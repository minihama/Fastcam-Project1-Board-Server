package com.boardserver.boardserver.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class UserDTO {

    // Getter와 Setter 메서드
    public static boolean hashNullDataBeforeRegister(UserDTO userDTO){
        return userDTO.getUserId() == null || userDTO.getPassword() == null || userDTO.getNickName() == null;
    }

    public enum Status{
        DEFAULT, ADMIN, DELETED
    }
    // private 를 사용한 캡슐화
    // ERD 에 작성 한 테이블 기반으로 생성
    private int id;
    private String userId;
    private String password;
    private String nickName;
    private boolean isAdmin;
    private Date createTime;
    private boolean isWithDraw;
    private Status status;
    private Date updateTime;

}
