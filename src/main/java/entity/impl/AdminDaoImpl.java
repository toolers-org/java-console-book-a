package dao.imp;

import com.mysql.cj.jdbc.ConnectionImpl;
import dao.AdminDao;
import utils.SQLconnection;

import java.sql.*;

public class AdminDaoImpl implements AdminDao{
    SQLconnection sqlConnection = new SQLconnection();
    Statement state = null;
    ResultSet resultSet = null;

    public void initial(){
        try{
            Connection conn = sqlConnection.sqlConnect();
            state = conn.createStatement();
        }catch (SQLException e){
            System.out.println("连接数据库失败！");
        }
    }
    public void close(){
        try {
            state.close();
        }catch (SQLException e){
            System.out.println("关闭数据库失败！");
        }
    }

    public void add(String userId,String passWord){
        initial();
        String sql = "insert into admin values(\'" + userId + "\',\'" + passWord + "\')";
        try{
            state.execute(sql);
        }catch (SQLException e){
            e.printStackTrace();
        }
        close();
    }
    public boolean isExist(String userId){
        initial();
        boolean isExi = false;
        String sql = "select * from admin";
        try{
            resultSet = state.executeQuery(sql);
            while(resultSet.next()){
                if(resultSet.getString("userId").equals(userId)){
                    isExi = true;
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        close();
        return isExi;
    }
    public boolean isCorrect(String userId,String passWord){
        initial();
        boolean isCorr = false;
        String sql = "select * from admin";
        try{
            resultSet = state.executeQuery(sql);
            while(resultSet.next()){
                if(resultSet.getString("userId").equals(userId) && resultSet.getString("passWord").equals(passWord)){
                    isCorr = true;
                    break;
                }
            }
            resultSet.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        close();
        return isCorr;
    }
}
