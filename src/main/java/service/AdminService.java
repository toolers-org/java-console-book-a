package service;

public interface AdminService {
    public void add(String id,String psw);//新建一个账户
    public boolean isExist(String userId);//判断用户名是否已注册
    public boolean isCorrect(String id,String passWord);//判断账号密码是否正确
}
