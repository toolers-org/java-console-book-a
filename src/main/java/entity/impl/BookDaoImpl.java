package dao.imp;

import com.mysql.cj.protocol.Resultset;
import utils.SQLconnection;
import controller.*;

import javax.crypto.spec.PBEKeySpec;
import java.sql.*;

public class BookDaoImpl {
    SQLconnection sqlConnection = new SQLconnection();
    private Statement state = null;
    private ResultSet resultSet = null;

    public void initial(){
        try{
            Connection conn = sqlConnection.sqlConnect();
            state = conn.createStatement();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public void close(){
        try {
            state.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public void add(String bookName){
        initial();
        String sql = "insert into book values(\'" + bookName + "\','未借出')";
        try{
            state.execute(sql);
        }catch (SQLException e){
            e.printStackTrace();
        }
        close();
    }
    public void delete(String bookName){
        initial();
        String sql = "delete from book where bookName=\'" + bookName + "\'";
        try{
            state.execute(sql);
        }catch (SQLException e){
            e.printStackTrace();
        }
        close();
    }
    public void update(String oldBookName, String newBookName){
        initial();
        String sql = "update book set bookName=\'" + newBookName + "\' where bookName=\'" + oldBookName + "\'";
        try{
            state.execute(sql);
        }catch (SQLException e){
            e.printStackTrace();
        }
        close();
    }
    public void update(String bookName){
        initial();
        String sql;
        try{
            sql = "select * from book";
            resultSet = state.executeQuery(sql);
            while (resultSet.next()){
                if(resultSet.getString("bookName").equals(bookName)){
                String bookState = resultSet.getString("bookState").equals("已借出")?("未借出"):("已借出");
                sql = "update book set bookState=\'" + bookState + "\' where bookName=\'" + bookName + "\'";
                }
            }
            state.execute(sql);
            resultSet.close();
            close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public BookInfo findOne(String bookName){
        initial();
        String sql = "select * from book";
        BookInfo aBook = null;
        try{
            resultSet = state.executeQuery(sql);
            while (resultSet.next()){
                if(resultSet.getString("bookName").equals(bookName)){
                    aBook = new BookInfo();
                    aBook.bookName = resultSet.getString("bookName");
                    aBook.bookState = resultSet.getString("bookState");
                }
            }
            resultSet.close();
            close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return aBook;
    }
    public void vagueFind(String keyWord){
        initial();
        String sql = "select * from book where bookName like \'%" + keyWord + "%\'";
        try {
            resultSet = state.executeQuery(sql);
            System.out.println("书名\t\t状态");
            while (resultSet.next()){
                System.out.println(resultSet.getString("bookName") + "\t\t" + resultSet.getString("bookState"));
            }
            resultSet.close();
            close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public void showAllBook(){
        initial();
        String sql = "select * from book";
        try {
            resultSet = state.executeQuery(sql);
            System.out.println("书名\t\t状态");
            while (resultSet.next()){
                System.out.println(resultSet.getString("bookName") + "\t\t" + resultSet.getString("bookState"));
            }
            resultSet.close();
            close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public boolean isExist(String bookName){
        initial();
        Integer id = null;
        String sql = "selete * from book";
        try {
            resultSet = state.executeQuery(sql);
            while (resultSet.next()){
                if(bookName == resultSet.getString("boookName")){
                    id = resultSet.getInt("bookName");
                }
            }
            resultSet.close();
            close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return (id==null)?(false):(true);
    }
}
