package dao;

import controller.BookInfo;

public interface BookDao {
    public void add(String bookName);//新加入一本书籍
    public void delete(String bookName);//删除书籍
    public void update(String newBookName);//修改书籍名称
    public void update();//修改书籍信息（借出或未借出）
    public BookInfo findOne(String bookName);//精确查找
    public void vagueFind(String keyWord);//模糊查找
    public void showAllBook();//展示所有书籍
    public boolean isExist(String id);//判断账书籍是否存在
}
