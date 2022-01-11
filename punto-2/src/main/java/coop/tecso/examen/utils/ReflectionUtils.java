package coop.tecso.examen.utils;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ReflectionUtils {
    public static  Constructor<?> getConstructorByClass(Class<?> clazz) {
        Constructor<?> ctor = null;
        try {
            assert clazz != null;
            ctor = clazz.getConstructor(String.class);

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return ctor;
    }

    public static Class<?> getClassByName(String name) {
        Class<?> clazz = null;
        try {
            clazz = Class.forName(name);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return clazz;
    }

    public static  Object getInstaceFromClassName(String name) throws InvocationTargetException, InstantiationException, IllegalAccessException {
        return getConstructorByClass(getClassByName(name)).newInstance();
    }
}
