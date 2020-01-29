package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class SQLconnection {

    String mysqlDriver = "com.mysql.cj.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/bookmanager";
    String userName = "root";
    String passWord = "123456";
    Connection conn = null;

    public Connection sqlConnect(){
        try {
            Class.forName(mysqlDriver);
            conn = DriverManager.getConnection(url,userName,passWord);
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return conn;
    }

    public void sqlClose(Statement state){
        try{
            state.close();
            System.out.println("数据库连接已关闭");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

}
