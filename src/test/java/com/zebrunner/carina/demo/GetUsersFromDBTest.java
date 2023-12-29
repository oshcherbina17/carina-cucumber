package com.zebrunner.carina.demo;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.demo.db.mappers.UserMapper;
import com.zebrunner.carina.demo.db.mappers.UserOrderMapper;
import com.zebrunner.carina.demo.db.models.User;
import com.zebrunner.carina.demo.db.models.UserOrder;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.core.config.Order;
import org.testng.annotations.Test;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

public class GetUsersFromDBTest implements IAbstractTest {
    @Test
    public void getUserIdTest() {
        try (SqlSession session = ConnectionFactory.getSqlSessionFactory().openSession(true)) {
            UserMapper userMapper = session.getMapper(UserMapper.class);
            User user = userMapper.findById(1);
            System.out.println("Username: " + user.getUsername() + " password: " + user.getPassword());
            UserOrderMapper userOrderMapper = session.getMapper(UserOrderMapper.class);
            List<UserOrder> userOrder = userOrderMapper.findOrdersByUserId(1);
            System.out.println(userOrder.size());
            for (UserOrder a: userOrder) {
                System.out.println(a.getProductName());
            }
        }
    }
}
