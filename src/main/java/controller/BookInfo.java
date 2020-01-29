package controller;

public class BookInfo {
    public String bookName;
    public String bookState;
    public void showBookInfo(){
        System.out.println("书名：" + bookName);
        System.out.println("状态：" + bookState);
    }
}
