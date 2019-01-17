package com.toby.springaop.configuration;

import com.toby.springaop.model.Circle;
import com.toby.springaop.model.Triangle;
import com.toby.springaop.service.ShapeService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
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

    @Bean ShapeService shapeService() {
	    return new ShapeService(circle(), triangle());
    }
}

