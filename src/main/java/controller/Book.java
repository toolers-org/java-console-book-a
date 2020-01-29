package controller;

import service.*;
import service.imp.*;

import java.util.Scanner;

public class Book {
    Scanner sc = new Scanner(System.in);
    BookServiceImpl bookService = new BookServiceImpl();

    public void meun(){

        System.out.println("请选择操作：");
        System.out.println("1.加入书籍");
        System.out.println("2.删除书籍");
        System.out.println("3.修改书籍");
        System.out.println("4.查询书籍");

        int choice = sc.nextInt();
        switch (choice){
            case 1:add(); break;
            case 2:delete(); break;
            case 3:update(); break;
            case 4:query(); break;
        }

    }

    public void add(){
        System.out.println("请输入要添加的书名：");
        String bookName = sc.next();
        bookService.add(bookName);
        System.out.println("添加成功！");
        Book book = new Book();
        book.meun();//返回书籍主菜单
    }

    public void delete(){
        System.out.println("请输入要删除的书名：");
        String bookName = sc.next();
        bookService.delete(bookName);
        System.out.println("删除成功！");
        Book book = new Book();
        book.meun();
    }

    public void update(){
        System.out.println("请输入要修改的书籍名称：");
        String book_Name = sc.next();
        BookInfo aBook = null;
        aBook = bookService.findOne(book_Name);

        if(aBook != null){
            System.out.println("查询到书籍：");
            aBook.showBookInfo();

            System.out.println("请选择要修改的选项：");
            System.out.println("1.修改书籍名称");
            System.out.println("2.修改借出状态");
            int updateChoice = sc.nextInt();
            switch (updateChoice){
                case 1:{
                    System.out.println("将书籍名修改为：");
                    String newBookName = sc.next();
                    bookService.update(book_Name,newBookName);
                    System.out.println("已将书籍名称修改为《" + newBookName + "》");
                    break;
                }
                case 2:{
                    bookService.update(book_Name);
                    aBook.bookState = (aBook.bookState.equals("未借出"))?("已借出"):("未借出");
                    System.out.println("已将书籍《" + aBook.bookName + "》修改为" + aBook.bookState);
                    break;
                }
                default:{
                    System.out.println("无效输入！");
                }
            }
        }else{
            System.out.println("书籍不存在！");
        }

        //返回书籍主菜单
        Book book = new Book();
        book.meun();
    }

    public void query(){
        System.out.println("请选择查询方式：");
        System.out.println("1.查看全部");
        System.out.println("2.精确查询");
        System.out.println("3.模糊查询");
        int queryChoice = sc.nextInt();
        switch (queryChoice){
            case 1:
                bookService.showAllBook();break;
            case 2: {
                System.out.println("请输入书籍名：");
                String book_Name = sc.next();
                BookInfo aBook = null;
                aBook = bookService.findOne(book_Name);
                if(aBook != null){
                    System.out.println("书籍信息如下：");
                    aBook.showBookInfo();
                }else{
                    System.out.println("书籍不存在！");
                }
                break;
            }
            case 3:{
                System.out.println("请输入关键词：");
                String keyWord = sc.next();
                bookService.vagueFind(keyWord);
                break;
            }
        }
        Book book = new Book();
        book.meun();
    }
}
