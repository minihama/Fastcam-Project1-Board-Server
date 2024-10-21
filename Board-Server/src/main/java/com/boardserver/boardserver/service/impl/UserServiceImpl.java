package com.boardserver.boardserver.service.impl;

import com.boardserver.boardserver.dto.UserDTO;
import com.boardserver.boardserver.exception.DuplicateIdException;
import com.boardserver.boardserver.mapper.UserProfileMapper;
import com.boardserver.boardserver.service.UserService;

import lombok.extern.log4j.Log4j2;

import static com.boardserver.boardserver.utils.SHA256Util.encryptSHA256;

import org.apache.ibatis.jdbc.RuntimeSqlException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class UserServiceImpl implements UserService {

    @Autowired
    private UserProfileMapper userProfileMapper;
    public UserServiceImpl(UserProfileMapper userProfileMapper){
        this.userProfileMapper = userProfileMapper;
    }

    @Override
    public void register(UserDTO userProfile){
        boolean duplIdResult = isDuplicatiedId(userProfile.getUserId());
        if (duplIdResult) {
            throw new DuplicateIdException("중복된 아이디입니다.");
        }
        userProfile.setCreateTime(new java.util.Date());
        userProfile.setPassword(encryptSHA256(userProfile.getPassword()));
        int insertCount = userProfileMapper.register(userProfile);
        if (insertCount != 1){
            log.error("insertMember ERROR! {}",userProfile);
            throw new RuntimeException(
                "insertUser ERROR! 회원가입 메서드를 확인해주세요\n" + "Params : " + userProfile);
        }
    }
    @Override
    public UserDTO login(String id, String password){
        String cryptoPassword = encryptSHA256(password);
        UserDTO memberInfo = userProfileMapper.findByIdAndPassword(id,cryptoPassword);
        return memberInfo;
    }
    @Override
    public boolean isDuplicatiedId(String id){
        return userProfileMapper.idCheck(id) ==1 ;
    }
    @Override
    public UserDTO getUserInfo(String userId){
        return null;
    }
    @Override
    public void updatePassword(String id, String beforePassword, String afterPassword){
        String cryptoPassword = encryptSHA256(beforePassword);
        UserDTO memberInfo = userProfileMapper.findByIdAndPassword(id, cryptoPassword);
        if(memberInfo!= null){
            memberInfo.setPassword(encryptSHA256(afterPassword));
            int insertCount = userProfileMapper.updatePassword(memberInfo);
        } else {
            log.error("updatePassword ERROR! {}", memberInfo);
            throw new RuntimeException("비밀번호가 일치하지 않습니다.");
        }
    }
    @Override
    public void deleteId(String id, String password){
        String cryptoPassword = encryptSHA256(password);
        UserDTO memberInfo = userProfileMapper.findByIdAndPassword(id, cryptoPassword);
        if (memberInfo != null) {
            int deleteCount = userProfileMapper.deleteUserProfile(id);
        } else {
            log.error("deleteId ERROR! {}", memberInfo);
            throw new RuntimeException("비밀번호가 일치하지 않습니다.");
        }
    }

}
