package service;

import dao.UserDao;
import bean.Userinfo;

public class UserService {
	public boolean login(String username,String userpass) {

		return new UserDao().login(username, userpass);
	}
	public void reg(Userinfo user) {

		new UserDao().reg(user);
	}
}
