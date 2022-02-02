package com.example.demo1210.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 张童学
 * @version 1.0
 * @date 2021/12/31 15:33
 * @describe
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginBean {

    /**
     * 登录用户名
     */
    String loginName;
    /**
     * 登录邮箱
     */
    String loginEmail;
    /**
     * 登录密码
     */
    String loginPassword;
}
