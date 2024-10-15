package main.java.com.boardserver.boardserver.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserDTO {

    public enum Status{
        DEFAULT, ADMIN, DELETED
    }

    // ERD 에 작성 한 테이블 기반으로 생성
    private int id;
    private String userID;
    private String password;
    private String nickName;
    private boolean isAdmin;
    private Date createTime;
    private boolean isWithDraw;
    private Status status;
    private Date updateTime;

}
