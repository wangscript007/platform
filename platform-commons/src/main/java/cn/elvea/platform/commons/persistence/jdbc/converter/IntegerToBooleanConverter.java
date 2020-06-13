package cn.elvea.platform.commons.persistence.jdbc.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;

/**
 * IntegerToBooleanConverter
 *
 * @author elvea
 */
@ReadingConverter
public class IntegerToBooleanConverter implements Converter<Integer, Boolean> {

    /**
     * @see Converter#convert(Object)
     */
    @Override
    public Boolean convert(Integer source) {
        return (source != null && source > 0) ? Boolean.TRUE : Boolean.FALSE;
    }

}