package com.smart.injection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by yunhai on 2016/2/24.
 */
public class InjectionTest {
    public ApplicationContext factory = null;

    private static String[] CONFIG_FILES = { "beans-injection.xml" };

    @BeforeClass
    public void setUp() throws Exception {
        factory = new ClassPathXmlApplicationContext(CONFIG_FILES);

    }
    @Test
    public void propertyInjectTest(){
        Car car=(Car)factory.getBean("car");
        System.out.println(car);
    }
    @Test
    public void ConstructorInjectTest(){
        Car car=(Car)factory.getBean("car1");
        System.out.println(car);
    }
}
