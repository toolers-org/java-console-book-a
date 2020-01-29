package controller;

import controller.*;
import service.AdminService;
import service.imp.AdminServiceImpl;

import java.util.Scanner;

public class User {
    AdminService adminService = new AdminServiceImpl();

    public void login(){
        Scanner sc = new Scanner(System.in);
        String id,passWord;

        System.out.println("请输入账号：");
        id = sc.next();
        System.out.println("请输入密码：");
        passWord = sc.next();

        if(adminService.isCorrect(id,passWord)){
            System.out.println("登录成功！");
            Book book = new Book();
            book.meun();
        }else{
            System.out.println("用户不存在或账号密码不正确！");
            controller.Main.main(null);
        }
    }


    public void register(){
        Scanner sc = new Scanner(System.in);
        String id,passWord;

        System.out.println("请输入账号：");
        id = sc.next();
        System.out.println("请输入密码：");
        passWord = sc.next();

        if(adminService.isExist(id)){
            System.out.println("账号已存在！");
            controller.Main.main(null);
        }else{
            adminService.add(id,passWord);
            System.out.println("注册成功！请前往登录");
            controller.Main.main(null);
        }

    }
}
