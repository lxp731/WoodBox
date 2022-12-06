package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class DBBean {
	// 用户名和口令要改成自己的数据库对应的用户名和口令
	private String url = "jdbc:mysql://127.0.0.1/woodbox";  // 数据库信息
	private String username = "root";
	private String password = "admin";
	private String driverName = "com.mysql.cj.jdbc.Driver";
	
	private Connection con=null;  //连接对象
	private PreparedStatement pstmt = null; //语句对象 
	private ResultSet rs = null; //结果集对象
	
	/*
	 * 建立到数据库的连接
	 */
	public DBBean() throws ClassNotFoundException, SQLException{
		Class.forName(driverName);  //加载驱动程序
		con = DriverManager.getConnection(url,username,password);
	}
	
	/*
	 * sql:要执行的SQL语句
	 * params：SQL语句中需要的变量
	 * 增删改 用这个方法
	 */
	public int executeUpdate(String sql,List<Object> params) throws SQLException{
		pstmt = con.prepareStatement(sql);
		// 如果有参数，为参数赋值
		if(params!=null && params.size()>0){
			for(int i=0;i<params.size();i++){
				pstmt.setObject(i+1, params.get(i));
			}
		}
		// 返回整数，表示影响数据库中记录的个数
		return pstmt.executeUpdate();
	}
	
	/*
	 * 执行select
	 */
	public ResultSet executeQuery(String sql,List<Object> params) throws SQLException{
		// 创建语句对象，语句对象的作用是执行SQL语句
		pstmt = con.prepareStatement(sql);
		// 处理参数
		if(params!=null && params.size()>0){
			for(int i=0;i<params.size();i++){
				pstmt.setObject(i+1, params.get(i));
			}
		}
		// 
		return pstmt.executeQuery();
	}
	
	/*
	 * 释放资源
	 */
	public void close(){
		if(rs!=null){
			try{rs.close();}catch(Exception ee){}
		}
		if(pstmt!=null){
			try{pstmt.close();}catch(Exception ee){}
		}
		if(con!=null){
			try{con.close();}catch(Exception ee){}
		}
	}
}
