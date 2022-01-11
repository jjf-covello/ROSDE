package coop.tecso.examen.utils;

import coop.tecso.examen.model.cc.moneda.Moneda;
import coop.tecso.examen.model.movimiento.tipo.TipoMovimiento;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ReflectionUtils {
    public static  Constructor<?> getConstructorByClass(Class<?> clazz) {
        Constructor<?> ctor = null;
        try {
            assert clazz != null;
            ctor = clazz.getConstructor();

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return ctor;
    }

    public static Class<?> getClassByName(String prefix, String name) {
        Class<?> clazz = null;
        try {
            clazz = Class.forName(prefix + name);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return clazz;
    }

    public static Moneda getMonedaInstaceFromClassName(String name) throws InvocationTargetException, InstantiationException, IllegalAccessException {
        return (Moneda) getConstructorByClass(getClassByName("coop.tecso.examen.model.cc.moneda.",name)).newInstance();
    }
    public static TipoMovimiento getTipomovInstaceFromClassName(String name) throws InvocationTargetException, InstantiationException, IllegalAccessException {
        return (TipoMovimiento) getConstructorByClass(getClassByName("coop.tecso.examen.model.movimiento.tipo.",name)).newInstance();
    }
}
