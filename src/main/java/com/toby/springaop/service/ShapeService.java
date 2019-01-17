package com.toby.springaop.service;

import com.toby.springaop.model.Circle;
import com.toby.springaop.model.Triangle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShapeService {

    private Circle circle;

    private Triangle triangle;

    public ShapeService(Circle circle, Triangle triangle) {
        this.circle = circle;
        this.triangle = triangle;
    }

    public void printNames() {
        System.out.println(circle.getName());
        System.out.println(triangle.getName());
    }
    public Circle getCircle() {
        return circle;
    }

    public void setCircle(Circle circle) {
        this.circle = circle;
    }

    public Triangle getTriangle() {
        return triangle;
    }

    public void setTriangle(Triangle triangle) {
        this.triangle = triangle;
    }

}
