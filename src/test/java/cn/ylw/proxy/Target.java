package cn.ylw.proxy;

import java.lang.reflect.Proxy;

/**
 * 目标对象
 *
 * @author yanluwei
 * @date 2020/9/18
 */
public class Target implements TargetInterface {
    public void method1() {
        System.out.println("method1");
    }

    public void method2() {
        System.out.println("method2");
    }

    public static void main(String[] args) {
        TargetInterface o = (TargetInterface) Proxy.newProxyInstance(Target.class.getClassLoader(),
            Target.class.getInterfaces(), new SimpleProxy(new Target()));
        o.method1();
    }
}
