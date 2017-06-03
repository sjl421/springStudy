package com.smart.beanfactory;

import com.smart.Car;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by yunhai on 2016/2/23.
 */
public class BeanFactoryTest {
    public static void main(String[] args) throws Throwable {
//        ResourcePatternResolver resolver=new PathMatchingResourcePatternResolver();
//        //Resource装载Spring配置信息并启动IoC容器
//        Resource res=resolver.getResource("classpath：com/smart/beanfactory/beans.xml");
//        Resource res=new ClassPathResource("classpath：com/smart/beanfactory/beans.xml");
//        BeanFactory bf=new XmlBeanFactory(res);
        ApplicationContext factory = new ClassPathXmlApplicationContext("beans.xml"); // Maven构建的项目只能加载resources下或绝对路径的配置文件
        Car car = factory.getBean("car", Car.class); //获取Bean

        System.out.println("car bean is ready for use!");
        car.introduce();
    }
}
// 绝对路径亦能加载成功
//        ApplicationContext context = new FileSystemXmlApplicationContext("D:/beans.xml");
//        Car car=(Car)context.getBean("car");