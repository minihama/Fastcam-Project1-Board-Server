package com.boardserver.boardserver.dto.response;

import com.boardserver.boardserver.dto.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserInfoResponse {
    private UserDTO userDTO;
}
