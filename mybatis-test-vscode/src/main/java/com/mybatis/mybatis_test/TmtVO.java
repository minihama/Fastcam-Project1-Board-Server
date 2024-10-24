package com.mybatis.mybatis_test;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TmtVO {
    private int id;
    private String name;
    private int status;
    private Date startdate;
}
