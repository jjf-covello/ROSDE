package coop.tecso.examen.utils.converters.nongeneric;

import coop.tecso.examen.model.cc.moneda.Moneda;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import static coop.tecso.examen.utils.ReflectionUtils.*;

@Converter
public class MonedaConverter implements AttributeConverter<Moneda, String> {

    @Override
    public String convertToDatabaseColumn(Moneda mov) {
        if (mov == null) {
            return null;
        }
        return mov.getClass().getSimpleName();
    }

    @Override
    public Moneda convertToEntityAttribute(String name) {
        Moneda object = null;
        if (!(name == null || name.isEmpty())) {
            try {
                object = getMonedaInstaceFromClassName(name);
            } catch (InvocationTargetException | InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        return object;
    }

}
