package com.smart.service;

import com.smart.dao.LoginLogDao;
import com.smart.dao.UserDao;
import com.smart.domain.LoginLog;
import com.smart.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by yunhai on 2016/2/19.
 * 业务层
 */

// 将UserService标注为一个服务层的Bean
// 需要在配置文件中装配Service
@Service
public class UserService {
    // 注入UserDao这个Dao层的Bean
    @Autowired
    private UserDao userDao;
    @Autowired
    private LoginLogDao loginLogDao;

    public boolean hasMatchUser(String userName, String password) {
        int matchCount = userDao.getMatchCount(userName, password);
        return matchCount > 0;
    }

    public User findUserByUserName(String userName) {
        return userDao.findUserByUserName(userName);
    }

    /**
     * 插入登录成功日志
     *
     * @param user
     */
    public void loginSuccess(User user) {
        LoginLog loginLog = new LoginLog();
        loginLog.setUserId(user.getUserId());
        loginLog.setIp(user.getLastIp());
        loginLog.setLoginDate(user.getLastVisit());
        loginLogDao.insertLoginLog(loginLog);
    }
}
/**
 * 密码一般加密存储；或者保存密码的MD5摘要（字符串同摘要也相同，且摘要不可逆）；加入图片验证码防止爆破。
 **/