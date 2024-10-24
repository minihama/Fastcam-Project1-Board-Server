package com.mybatis.mybatis_test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

@Controller
public class TmtController {
    @Autowired
    private TmtMapper mapper;
    @RequestMapping("/tmtList.do")
    public ModelAndView tmtList(){
        ArrayList<TmtVO> list=mapper.list();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("list",list);
        return modelAndView;
    }
    @RequestMapping("/tmtSelect.do")
    public ModelAndView tmtSelect(int id){
        ModelAndView modelAndView = new ModelAndView();
        TmtVO vo = mapper.tmtSelect(id);
        modelAndView.addObject("vo",vo);
        return modelAndView;
    }
}
