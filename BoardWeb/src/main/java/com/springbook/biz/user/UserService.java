package com.springbook.biz.user;

import java.util.List;
import java.util.Map;

public interface UserService {

	public List<Map<String, Object>> getUserList();

	public UserVO getUser(UserVO vo);

	public void insertUser(UserVO vo);

	public void updateUser(UserVO vo);

	public void delete(UserVO vo);

}
