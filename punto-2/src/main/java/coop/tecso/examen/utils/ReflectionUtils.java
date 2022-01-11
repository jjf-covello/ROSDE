package coop.tecso.examen.utils;

import java.lang.reflect.Constructor;

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

    public static Class<?> getClassByName(String movName) {
        Class<?> clazz = null;
        try {
            clazz = Class.forName(movName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return clazz;
    }
}
