package coop.tecso.examen.utils.converters;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import static coop.tecso.examen.utils.ReflectionUtils.getClassByName;
import static coop.tecso.examen.utils.ReflectionUtils.getConstructorByClass;

@Converter
public class ClazzConverter<T> implements AttributeConverter<T, String> {


    @Override
    public String convertToDatabaseColumn(T mov) {
        if (mov == null) {
            return null;
        }
      return mov.getClass().getName();
    }

    @Override
    public T convertToEntityAttribute(String movName) {
        T object = null;
        if (!(movName == null || movName.isEmpty())) {
            Class<?> clazz = getClassByName(movName);
            Constructor<?> ctor = getConstructorByClass(clazz);
            try {
                assert ctor != null;
                object = (T) ctor.newInstance();
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }

        return object;
    }
}
