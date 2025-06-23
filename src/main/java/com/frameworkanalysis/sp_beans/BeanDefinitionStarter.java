package com.frameworkanalysis.sp_beans;


import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;

public class BeanDefinitionStarter {
    public static void main(String[] args) {
        var factory = new DefaultListableBeanFactory();
        factory.registerBeanDefinition("itemService", new RootBeanDefinition(ItemService.class));

        // Define main bean and inject 'service'
        var userServiceDef = new RootBeanDefinition(UserService.class);
        var props = new MutablePropertyValues();
        props.add("itemService", factory.getBean("itemService"));
        userServiceDef.setPropertyValues(props);

        factory.registerBeanDefinition("userService", userServiceDef);

        // Get bean
        var userService = (UserService) factory.getBean("userService");
        userService.sayHello();


        var factory2 = new DefaultListableBeanFactory();
        var reader = new XmlBeanDefinitionReader(factory2);
        reader.loadBeanDefinitions(new ClassPathResource("spring_beans/beans.xml"));
        var userService2 = factory2.getBean("userService", UserService.class);
        userService2.sayHello();



    }
}
