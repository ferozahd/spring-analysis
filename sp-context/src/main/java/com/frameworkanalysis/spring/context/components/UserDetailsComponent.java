package com.frameworkanalysis.spring.context.components;

import org.springframework.stereotype.Component;

@Component
public class UserDetailsComponent {

    public String getMessage(){
        return "this is :"+this.getClass().descriptorString();
    }
}
