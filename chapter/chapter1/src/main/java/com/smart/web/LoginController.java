package com.smart.web;

import com.smart.domain.User;
import com.smart.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * Created by yunhai on 2016/2/19.
 * 处理登录请求，完成登陆业务。决定转向欢迎或失败页面。
 * 一个控制器可拥有多个对应不同请求路径的处理方法，通过@Requestmapping指定方法如何映射请求路径，如②。
 */
@Controller //标注为一个Spring MVC的Controller
@RequestMapping(value = "/admin")
public class LoginController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login.html") // ②负责处理/login.html的请求
    public String loginPage() {
        return "login";
    }

    @RequestMapping(value = "/loginCheck.html")
    public ModelAndView loginCheck(HttpServletRequest request, LoginCommand loginCommand) {
        boolean isValidUser = userService.hasMatchUser(loginCommand.getUserName(), loginCommand.getPassword());
        if (!isValidUser) {
            return new ModelAndView("login", "error", "用户名或密码错误");
        } else {
            User user = userService.findUserByUserName(loginCommand.getUserName());
            user.setLastIp(request.getRemoteAddr()); //取客户端的IP地址。
            //如果使用了反向代理软件，将http://192.168.1.110:2046/ 的URL反向代理为http://www.xxx.com/ 的URL时，
            //用request.getRemoteAddr() 方法获取的IP地址是：127.0.0.1　或　192.168.1.110 ，而并不是客户端的真实ＩＰ。
            //Note:request.getRemoteAddr返回的是0:0:0:0:0:0:0:1，而不是127.0.0.1.解决方案：访问路径localhost:8080修改为127.0.0.1:8080。
            user.setLastVisit(new Date());
            userService.loginSuccess(user);
            //用户登陆成功后服务器将用户的信息绑定到session对象上，之后你的每一个请求服务器都要去查看这个绑定的session是否存在，
            // 如果存在证明是登陆成功可以访问，如果不存在证明是没有登录的用户，踢回登录页面。
            request.getSession().setAttribute("user", user);
            //返回一个模型视图，里面包含两个部分，一个是逻辑数据(页面上需要显示的数据），另一个就是这个逻辑视图的名字
            return new ModelAndView("main");
        }
    }
}
/**
 * ModelAndView() 常用来页面跳转.
 * 参数：（视图逻辑名，数据模型名称，数据模型对象）；
 * ModelAndview(String viewName)  跳转到viewName.suffix页面，可以使用addObject(Object obj)来添加对象
 * ModelandView(View view) 返回一个视图页面：return new ModelAndView(new InternalResourceView("/WEB-INF/web/show.jsp"))，这样就无需配置ViewResolver了
 * ModelAndView(String viewName, Map model) 返回一个视图，并将Map值显示在视图上
 * Modelandview(View view, Map model)
 * ModelAndView(String viewName, String modelName, Object modelObject) 跳转到viewName.jsp页面，并将modelObject对象封装到modelName中，引用${modelName}就可以直接引用userName了。
 * ModelAndView(View view, String modelName, Object modelobject)
 */