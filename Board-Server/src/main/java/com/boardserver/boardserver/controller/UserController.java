package main.java.com.boardserver.boardserver.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.extern.log4j.Log4j2;
import main.java.com.boardserver.boardserver.service.impl.UserServiceImpl;

// REST API 기반으로 만들어야 하기에 RestController을 추가
// 실제 RequestMapping 을 통해서 controller를 통한 url에 스킴을 설계
@RestController
@RequestMapping("/users")
@Log4j2
public class UserController {
    // 바로 로직을 처리 할 수 없기 때문에 서비스 단의 로직을 생성
    // userservice 는 인터페이스를 구현 할 예정임으로 imp로 작성
    private final UserServiceImp userService;
    // 컨트롤러에 생성자 추가
    @Autowired
    public UserController(UserServiceImpl userService){
        this.userService = userService;
    }

}
