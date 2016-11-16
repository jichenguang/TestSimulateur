package Webq.Case;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.testng.annotations.Test;




@Test
public class CaseJdbc {	
	
    //数据库的连接驱动，一般是不需要变的
    private static final String DRIVER="com.microsoft.jdbc.sqlserver.SQLServerDriver";
    //数据库连接的URL,1433为默认的数据库端口号，test为当前你要操作的数据库名
    private static final String URL="jdbc:microsoft:sqlserver://192.168.188.11:1433;DatabaseName=700Store.Order";
    //登录账户
    private static final String DBNAME="sa";
    //登录的密码
    private static final String DBPASS="700Bike520";

    public void test() throws SQLException{
     Connection con=null;    
     PreparedStatement psm=null;
     ResultSet rs=null;
     try{    
         Class.forName(DRIVER);
         con = DriverManager.getConnection(URL,DBNAME,DBPASS);
         System.out.println("链接成功！");
         String sql="select* from admin where id=1";
         psm=con.prepareStatement(sql);
         rs=psm.executeQuery();
         while(rs.next()){
            System.out.println(rs.getString("aPassword"));
         }
     }catch(Exception e){
         con.close();
         rs.close();
         psm.close();
         e.printStackTrace();
     }
  }

}

