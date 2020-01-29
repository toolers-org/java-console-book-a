package service.imp;

import dao.AdminDao;
import dao.imp.*;
import service.AdminService;

public class AdminServiceImpl implements AdminService {
    AdminDao adminDao = new AdminDaoImpl();

    public void add(String id, String passWord){ adminDao.add(id, passWord); }
    public boolean isExist(String userid){return adminDao.isExist(userid);}
    public boolean isCorrect(String id,String passWord){return adminDao.isCorrect(id, passWord);}
}
