package com.mybatis.mybatis_test;

import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;

@Mapper
public interface TmtMapper {
    ArrayList<TmtVO> list();
    TmtVO tmtSelect(int id);
}
