package service.imp;

import controller.BookInfo;
import dao.BookDao;
import dao.imp.BookDaoImpl;

public class BookServiceImpl {
    BookDaoImpl bookDao = new BookDaoImpl();

    public void add(String bookName){bookDao.add(bookName);}
    public void delete(String bookName){bookDao.delete(bookName);}
    public void update(String oldBookName,String newBookName){bookDao.update(oldBookName,newBookName);}
    public void update(String bookName){bookDao.update(bookName);}
    public BookInfo findOne(String bookName){
        return bookDao.findOne(bookName);
    }
    public void vagueFind(String keyWord){bookDao.vagueFind(keyWord);}
    public void showAllBook(){bookDao.showAllBook();}
    public boolean isExist(String bookName){return bookDao.isExist(bookName);}
}
