package com.onefengma.test.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.lang.reflect.Proxy;

/**
 * @author yfchu
 * @date 2016/5/19
 */

public class ProxyDemo {

    public static void main(String[] args) {

        Subject subject = (Subject) Proxy.newProxyInstance(Subject.class.getClassLoader(), new Class<?>[] { Subject.class }, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if (method.isAnnotationPresent(ACTION.class)) {
                    String action = method.getAnnotation(ACTION.class).value();
                    System.out.println("------action:" + action);
                    Parameter[] parameters = method.getParameters();
                    for(Parameter parameter : parameters) {
                        if (parameter.isAnnotationPresent(DO.class)) {
                            boolean name = parameter.getAnnotation(DO.class).name();
                            String test = parameter.getAnnotation(DO.class).test();
                            System.out.println("------action P:" + name + "," + test);
                        }
                    }
                }
                System.out.println("------invoke:" + method);
                return null;
            }
        });

        subject.doit("good");
    }

    public interface Subject {

        void test();

        @ACTION("test")
        void doit(@DO(test = "asdf", name = true) String name);

    }

}
