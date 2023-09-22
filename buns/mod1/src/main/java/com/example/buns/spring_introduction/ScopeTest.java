package com.example.buns.spring_introduction;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ScopeTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext3.xml");

        Dog myDog = context.getBean("dog", Dog.class);
        myDog.say();


//        Dog yuorDog = context.getBean("dog", Dog.class);
//
//        System.out.println("Переменные ссылаются на один и тот же объект?" +
//                (myDog==yuorDog));
//        System.out.println(myDog);
//        System.out.println(yuorDog);

        context.close();
    }
}
