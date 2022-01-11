package coop.tecso.examen.utils.converters.nongeneric;

import coop.tecso.examen.model.movimiento.tipo.TipoMovimiento;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.lang.reflect.InvocationTargetException;

import static coop.tecso.examen.utils.ReflectionUtils.getTipomovInstaceFromClassName;

@Converter
public class TipoMovimientoConverter implements AttributeConverter<TipoMovimiento, String> {

    @Override
    public String convertToDatabaseColumn(TipoMovimiento mov) {
        if (mov == null) {
            return null;
        }
        return mov.getClass().getSimpleName();
    }

    @Override
    public TipoMovimiento convertToEntityAttribute(String name) {
        TipoMovimiento object = null;
        if (!(name == null || name.isEmpty())) {
            try {
                object = getTipomovInstaceFromClassName(name);
            } catch (InvocationTargetException | InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return object;
    }

}