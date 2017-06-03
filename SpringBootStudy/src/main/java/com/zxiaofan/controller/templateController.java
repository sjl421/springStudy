package com.zxiaofan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * thymeleaf模板加载html，主流前后端分离的开发方式，不建议使用模板.
 * <p>
 * Created by xiaofan on 2017/3/26.
 */
@Controller
// @ResponseBody
public class templateController {
    @RequestMapping(value = "/hiHtml",method = RequestMethod.GET)
    public String hiHtml() {
        return "index";
    }
}
