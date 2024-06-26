package com.camellia.reflect.method;

public class UserService {

    /**
     * 登录系统的方法
     * @param username 用户名
     * @param password 密码
     * @return true表示登录成功，false表示失败
     */
    public boolean login(String username, String password){
        return "admin".equals(username) && "123456".equals(password);
    }

    public String concat(String s1, String s2, String s3){
        return s1 + s2 + s3;
    }

    /**
     * 退出系统的方法
     */
    public void logout(){
        System.out.println("系统已安全退出！");
    }
}
