package org.sysoev.task9;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

public class ProxyPattern {

    public static void main(String[] args) {
        List<Integer> list =new ArrayList<>(List.of(1, 2, 3, 4, 10, 8));

        ListAddHandler handler = new ListAddHandler(list);

        list = (List<Integer>) Proxy.newProxyInstance(
                list.getClass().getClassLoader(),
                list.getClass().getInterfaces(),
                handler);

        test(list);

        System.out.println(handler.getCount());
    }

    private static void test(List<Integer> list) {

        list.add(9);
        list.add(5);
        list.add(12);

        System.out.println(list);
    }
}

class ListAddHandler implements InvocationHandler {
    private int count = 0;
    List list;

    public ListAddHandler(List<Integer> list) {
        this.list = list;
    }

    public int getCount() {
        return count;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        if (method.getName().equals("add")) {
            count++;
        }
        return method.invoke(list, args);
    }
}
