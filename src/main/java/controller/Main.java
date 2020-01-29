package controller;


import java.util.*;


public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        User user = new User();

        System.out.println("请选择操作：");
        System.out.println("1.用户登录");
        System.out.println("2.用户注册");

        int choice = scanner.nextInt();
        switch (choice){
            case 1:
                user.login();
                break;
            case 2:
                user.register();
                break;
        }
    }
}
