package com.songpeng.dao;

import com.songpeng.domain.User;

public interface UserDao {

	User findUserByUsernameAndPWD(User user);

}
