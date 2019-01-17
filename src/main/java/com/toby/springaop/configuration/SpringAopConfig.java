package com.toby.springaop.configuration;

import com.toby.springaop.aspect.LoggingAspect;
import com.toby.springaop.model.Circle;
import com.toby.springaop.model.Triangle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages = "com.toby.springaop")
public class SpringAopConfig {

	@Bean
    public Circle circle() {
	    Circle circle = new Circle();
	    circle.setName("Circle name");
	    return circle;
    }

    @Bean
    public Triangle triangle() {
	    Triangle triangle = new Triangle();
	    triangle.setName("Triangle name");
	    return triangle;
    }

    @Bean
    public LoggingAspect loggingAspect() {
	    return new LoggingAspect();
    }
}

