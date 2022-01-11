package coop.tecso.examen.utils.converters.nongeneric;

import coop.tecso.examen.model.cc.moneda.Moneda;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import static coop.tecso.examen.utils.ReflectionUtils.getClassByName;
import static coop.tecso.examen.utils.ReflectionUtils.getConstructorByClass;

@Converter
public class MonedaConverter implements AttributeConverter<Moneda, String> {

    @Override
    public String convertToDatabaseColumn(Moneda mov) {
        if (mov == null) {
            return null;
        }
        return mov.getClass().getName();
    }

    @Override
    public Moneda convertToEntityAttribute(String movName) {
        Moneda object = null;
        if (!(movName == null || movName.isEmpty())) {
            Class<?> clazz = getClassByName(movName);
            Constructor<?> ctor = getConstructorByClass(clazz);
            try {
                assert ctor != null;
                object = (Moneda) ctor.newInstance();
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }

        return object;
    }

}
