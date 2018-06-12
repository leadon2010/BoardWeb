package com.springbook.biz;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {
	@Autowired
	// UserDAO dao;
	UserDAOSpring dao;

	@Override
	public List<Map<String, Object>> getUserList() {
		System.out.println("userService ===================getUserList");
		return dao.getUserList();
	}

	@Override
	public void insertUser(UserVO vo) {
		System.out.println("userService ===================insertUser");
		dao.insertUser(vo);
	}

	@Override
	public UserVO getUser(UserVO vo) {
		System.out.println("userService ===================getUser");
		return null;
	}

	@Override
	public void updateUser(UserVO vo) {
		System.out.println("userService ===================updateUser");

	}

	@Override
	public void delete(UserVO vo) {
		System.out.println("userService ===================delete");

	}

}
