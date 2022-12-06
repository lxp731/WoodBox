package dao;

import util.DBBean;
import java.sql.ResultSet;
import java.util.*;
import bean.Userinfo;


public class UserDao {
	public boolean login(String username,String userpass) {
		DBBean bean=null;
		try {
			bean = new DBBean();
			String sql = "select count(*) from user "+ "where username=? and userpass=?";
			List<Object> params = new ArrayList<Object>();
			params.add(username);
			params.add(userpass);
			
			ResultSet rs = bean.executeQuery(sql, params);
			
			if(rs.next()) {
				int count = rs.getInt(1);
				return count==1;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			bean.close();
		}
		return false;
	}
	
//	测试登录的方法
//	public static void main(String argr[]) {
//		UserDao dao = new UserDao();
//		System.out.println(dao.login("lxp","123"));
//		System.out.println(dao.login("syc","456"));
//		System.out.println(dao.login("liu@qq.com","123456"));
//	}
	
	public boolean reg(Userinfo user) {
		DBBean bean = null;
		try {
			bean = new DBBean();
			String sql = "insert into user values(?,?)";
			List<Object> params = new ArrayList<Object>();
			params.add(user.getUsername());
			params.add(user.getUserpass());
//			params.add(user.getTelephone());
//			params.add(user.getQq());
//			params.add(user.getWechat());
//			params.add(user.getMail());
			return bean.executeUpdate(sql, params)>0;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			bean.close();
		}
		return false;
	}
	
//	测试注册的方法
//	public static void main(String argr[]) {
//		UserDao dao = new UserDao();
//		Userinfo user = new Userinfo();
//		user.setUsername("wanggang@dl.cn");
//		user.setUserpass("afdsa");
////		user.setTelephone("123");
////		user.setQq("111111");
////		user.setWechat("12039");
////		user.setMail("ahjds");
//		System.out.println(dao.reg(user));
//	}
}


