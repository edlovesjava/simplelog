package com.wentware.simpleapps.simplelog;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MongoApp {

    private static final Log log = LogFactory.getLog(MongoApp.class);

    public static void mainx(String[] args) throws Exception {
        ConfigurableApplicationContext context = null;
        // use @Configuration using Java:
        context = new ClassPathXmlApplicationContext("META-INF/spring/bootstrap.xml");

		// use XML application context:
        //context = new ClassPathXmlApplicationContext("META-INF/spring/applicationContext.xml");
        MongoAppTest mongoAppTest = context.getBean(MongoAppTest.class);
        mongoAppTest.run();

        System.out.println("DONE!");
    }

}
