package com.hervedarritchon.rpg.services;

/**
 * Created with IntelliJ IDEA.
 * User: Hervé Darritchon
 * Date: 09/05/2014
 * Time: 18:28
 * To change this template use File | Settings | File Templates.
 */
public class GreetingServiceImpl implements GreetingService {
    @Override
    public String greet(String who) {
        return String.format("hello, %s!", who);
    }
}