package com.BMSX.model.dao;

import com.BMSX.modelbean.User;

public interface UserDao extends BaseDao{
	public User searchone(String name);
}
