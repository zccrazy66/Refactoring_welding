package com.springboot_vue.js.Config;

public class test {


//    {
//        a = 5;
//    }
//
//
//    private int a = 1;
//
//
//    public int getA(){
//        return a;
//    }
//
//    public static void main(String[] args) {
//        test a = new test();
//        System.out.println(a.getA());
//    }

    public static void main(String[] args)
    {
        staticFunction();
    }

    static test book = new test();

    static
    {
        System.out.println("书的静态代码块");
    }

    {
        System.out.println("书的普通代码块");
    }

    test()
    {
        System.out.println("书的构造方法");
        System.out.println("price=" + price +",amount=" + amount);
    }

    public static void staticFunction(){
        System.out.println("书的静态方法");
    }

    int price = 110;
    static int amount = 112;



}
