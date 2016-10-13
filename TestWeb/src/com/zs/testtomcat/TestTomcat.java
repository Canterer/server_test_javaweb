package com.zs.testtomcat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import com.zs.beans.Person;
import com.zs.json.JsonTools;
import com.zs.service.JsonService;

public class TestTomcat extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	class BaseConst{
		
		public static final int LOGIN = 1;
		public static final int PICK_QUERY = 2;
		public static final int PICK_CONFIRM = 3;
		public static final int DELIVERY_QUERY = 4;
		public static final int DELIVERY_CONFIRM = 5;
	}
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html;charset=utf-8");
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");


		PrintWriter out = resp.getWriter();
//				//用HTML格式给浏览器返回数据
//				out.println("<html>");
//				out.println("<head>");3
//				out.println("<title>Hello,Servlet!</title>");
//				out.println("</head>");
//				out.println("<body>");
//				out.println("Hello,First Servlet!");
//				out.println("</body>");
//				out.println("</html>");
		try {
			Connection conn = null;
			Class.forName("com.mysql.jdbc.Driver");
			//String url="jdbc:mysql://localhost:端口/数据库";
			//String dbUrl = "jdbc:mysql://localhost:3306/seeker";
			String dbUrl = "jdbc:mysql://localhost:8080/server-example";
			String dbUser = "root";
			String dbPwd = "1661092013";
			
			conn = (Connection) DriverManager.getConnection(dbUrl, dbUser, dbPwd);
			Statement st = (Statement) conn.createStatement();
			String sql = "select * from user_table";
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()){     //rs.next()   表示如果结果集rs还有下一条记录，那么返回true；否则，返回false
	            int id = rs.getInt("id");
	            String name = rs.getString(2);
	            String password = rs.getString(3);
	            //System.out.println(id+"--->"+name+"--------"+password);
            }
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("doGet");
		//out.println("Hello,第一个Tomcat!!!");
		out.close();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html;charset=utf-8");  
        req.setCharacterEncoding("utf-8");  
        resp.setCharacterEncoding("utf-8");  
        PrintWriter out = resp.getWriter();  
        
        JsonService jsonService = new JsonService();
        List<Person> listPerson =  jsonService.getListPerson(); 
		
		//String params = charReader( req );
		//int req_type = -1;
		//String result = "{\"status\":\"900\",\"msg\":\"闈炴硶璇锋眰锛乗", \"result\":{\"msg\": \"Wrong Request Type!\"}}";
		//JSONObject obj = JSON.parseObject(params);
        
        String str = null;
		//获取URL参数
		String action_flag = req.getParameter("action_flag");
		if( action_flag.equals("persons") ){
			str = JsonTools.createJsonString("persons",listPerson);
		}
		System.out.println(str);
		out.println(str);
		out.flush();
		out.close();
	}
	

	String charReader(HttpServletRequest request) throws IOException {

		BufferedReader br = request.getReader();
		String str, wholeStr = "";
		while((str = br.readLine()) != null){
			wholeStr += str;
		}

		System.out.println(wholeStr);
		return wholeStr;
	}
}
