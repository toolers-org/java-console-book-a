package dao;

public interface AdminDao {
    public void add(String userId,String passWord);//新建账户
    public boolean isExist(String userId);//判断用户名是否已注册
    public boolean isCorrect(String userId,String passWord);//判断账号密码是否正确
}
