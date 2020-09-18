package cn.ylw.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 代理对象
 *
 * @author yanluwei
 * @date 2020/9/18
 */
public class SimpleProxy implements InvocationHandler {

    private Object target;

    public SimpleProxy(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before");
        Object invoke = method.invoke(target, args);
        System.out.println("after");
        return invoke;
    }
}
