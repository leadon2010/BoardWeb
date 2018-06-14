package com.springbook.biz;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml", "classpath:transactionContext.xml" })
public class UserClientSpring {

	@Autowired
	UserService userService;

	@Test
	public void insertUserTest() {

		UserVO vo = new UserVO();

		vo.setId("spring5");
		vo.setPassword("spring5");
		vo.setName("spring5");
		vo.setRole("user");

		// userService.insertUser(vo);

		List<Map<String, Object>> userList = userService.getUserList();

		for (Map<?, ?> map : userList) {
			System.out.println(map.get("id") + " / " + map.get("password") + " / " + map.get("name"));
		}

	}

}
