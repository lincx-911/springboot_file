package com.myJdbc.springboot4;

import java.sql.Connection;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MyJdbcApplicationTests {
	
	@Resource
	DataSource dataSource;

	@Test
	void contextLoads() {
		System.out.println(dataSource.getClass());
		Connection connection;
		try {
			connection = dataSource.getConnection();
			System.out.println(connection);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
