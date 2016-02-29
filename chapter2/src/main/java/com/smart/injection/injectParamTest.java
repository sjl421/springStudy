package com.smart.injection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

/**
 * Created by yunhai on 2016/2/29.
 */
public class injectParamTest {
    public ApplicationContext factory = null;

    private static String[] CONFIG_FILES = {"beans-injectParam.xml"};

    @BeforeClass
    public void setUp() throws Exception {
        factory = new ClassPathXmlApplicationContext(CONFIG_FILES);

    }

    @Test
    public void collectionTest() {
        Boss bossList = (Boss) factory.getBean("boss_list");
        System.out.println(bossList.getList());
        Boss bossMap = (Boss) factory.getBean("boss_map");
        System.out.println(bossMap.getMapWeek());
        Boss bossPro = (Boss) factory.getBean("boss_pro");
        System.out.println(bossPro.getType().toString());
    }

    @Test
    public void utilTest() {
        List bossList = (List) factory.getBean("list_util");
        System.out.println(bossList);
        Map map = (Map) factory.getBean("map_util");
        System.out.println(map);
    }

    /**
     * ⑤简化配置方式
     */
    @Test
    public void simpleTest() {
       Boss boss=(Boss) factory.getBean("boss");
        System.out.println(boss.getCar());
    }
}
