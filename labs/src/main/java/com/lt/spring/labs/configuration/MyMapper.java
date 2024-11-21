package com.lt.spring.labs.configuration;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;

public class MyMapper {
    public <T,U> U map(T s, Class<U> d) {
        try {
            Class<?> sClass = s.getClass();
            Constructor<U> dConstructor = d.getConstructor(new Class[0]);
            U dInst = dConstructor.newInstance(new Object[0]);
            for(Method getter : Arrays.stream(sClass.getDeclaredMethods())
                    .filter(m -> m.getName().startsWith("get"))
                    .collect(Collectors.toList())) {
                        String getterName = getter.getName().substring("get".length());
                        Optional<Method> setter = Arrays.stream(d.getDeclaredMethods())
                                .filter(m ->
                                m.getName().equals("set"+getterName)) .findFirst();
                        if(setter.isPresent()) {
                            setter.get().invoke(dInst, getter.invoke(s));
                        }
            }
            return dInst;
        } catch (Exception e) {
            return null;
        }
    }
}