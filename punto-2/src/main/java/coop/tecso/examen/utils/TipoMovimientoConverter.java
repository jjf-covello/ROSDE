package coop.tecso.examen.utils;

import coop.tecso.examen.model.movimiento.tipos.TipoMovimiento;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import static coop.tecso.examen.utils.ReflectionUtils.getClassByName;
import static coop.tecso.examen.utils.ReflectionUtils.getConstructorByClass;

@Converter
public class TipoMovimientoConverter implements AttributeConverter<TipoMovimiento, String> {


    @Override
    public String convertToDatabaseColumn(TipoMovimiento mov) {
        if (mov == null) {
            return null;
        }
      return mov.getClass().getName();
    }

    @Override
    public TipoMovimiento convertToEntityAttribute(String movName) {
        TipoMovimiento mov = null;
        if (!(movName == null || movName.isEmpty())) {
            Class<?> clazz = getClassByName(movName);
            Constructor<?> ctor = getConstructorByClass(clazz);
            try {
                assert ctor != null;
                mov = (TipoMovimiento) ctor.newInstance();
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }

        return mov;
    }
}
