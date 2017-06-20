package com.ldd.test;

import com.ldd.pojo.User;
import com.ldd.util.XmlUtil;

import java.util.List;

/**
 * time: 2017/6/20 author:ldd
 *  XmlUtil测试类
 */
public class XmlTest {

    public static void main(String[] args) throws Exception {
        XmlUtil xmlUtil = new XmlUtil();
//        User user = new User();
//        user.setName("黄加洋");
//        user.setAge(250);
//        xmlUtil.addUserToXml(user);

        List<User> users = xmlUtil.readXml();
        users.forEach(System.out::println);
    }
}
