package com.zxiaofan.skills;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;
import java.util.Properties;

/**
 * Created by xiaofan on 2017/6/13.
 */
public class injectPropertiesStudy {
    public ApplicationContext factory = null;

    private static String[] CONFIG_FILES = {"beans-injectProp.xml"};

    @Before
    public void setUp() throws Exception {
        factory = new ClassPathXmlApplicationContext(CONFIG_FILES);
        System.out.println("Spring注入完毕===");
    }

    @Test
    public void propertyInjectTest() {
        Properties properties = (Properties) factory.getBean("propParam");
        if (null != properties) {
            for (Map.Entry entry :
                    properties.entrySet()) {
                System.out.println(entry.getKey() + "=" + entry.getValue());
            }
        }
    }
}
