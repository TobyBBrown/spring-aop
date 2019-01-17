package com.toby.springaop;

import com.toby.springaop.configuration.SpringAopConfig;
import com.toby.springaop.service.ShapeService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AopMain {

    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringAopConfig.class);
        ShapeService shapeService = ctx.getBean(ShapeService.class);
        shapeService.printNames();
        shapeService.getTriangle().setName("Jimmy");
        shapeService.getCircle();
    }
}
