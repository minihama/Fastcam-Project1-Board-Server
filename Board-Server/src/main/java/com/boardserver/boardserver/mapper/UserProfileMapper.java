package com.boardserver.boardserver.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.boardserver.boardserver.dto.UserDTO;

@Mapper
public interface UserProfileMapper {
    public UserDTO getUserProfile(@Param("id") String id); 

    int insertUserProfile(@Param("userId") String userId ,@Param("password") String password ,@Param("nickName") String nickName ,@Param("isWithDraw") String isWithDraw ,@Param("status") String status ,@Param("createTime") String createTime ,@Param("updateTime") String updateTime);
    int deleteUserProfile(@Param("id") String id);

    public UserDTO findByIdAndPassword(@Param("id") String id, @Param("password") String password);

    int idCheck(@Param("id") String id);

    public int updatePassword(UserDTO userId);
    public int updateAddress(UserDTO userId);

    int register(UserDTO userProfile);
}

