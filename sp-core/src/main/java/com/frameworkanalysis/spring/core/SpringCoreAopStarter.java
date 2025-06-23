package com.frameworkanalysis.spring.core;


import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.framework.ProxyFactory;

public class SpringCoreAopStarter {
    public static void main(String[] args) {
        MyService target = new MyServiceImpl();

        // Create proxy factory
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(target);
        proxyFactory.addAdvice(new LoggingInterceptor());

        // Create proxy
        MyService proxy = (MyService) proxyFactory.getProxy();

        // Call method via proxy
        proxy.doSomething();
    }
}



interface MyService {
    void doSomething();
}


class MyServiceImpl implements MyService {
    public void doSomething() {
        System.out.println("🎯 Doing actual work in MyServiceImpl...");
    }
}

class LoggingInterceptor implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.println("➡️ Before method: " + invocation.getMethod().getName());
        Object result = invocation.proceed();
        System.out.println("⬅️ After method: " + invocation.getMethod().getName());
        return result;
    }

}