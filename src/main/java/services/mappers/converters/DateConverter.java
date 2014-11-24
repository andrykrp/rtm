package services.mappers.converters;

import ma.glasnost.orika.converter.BidirectionalConverter;
import ma.glasnost.orika.metadata.Type;
import utils.DateUtil;

import java.util.Date;

public class DateConverter extends BidirectionalConverter<Date, String> {
    @Override
    public String convertTo(Date source, Type<String> destinationType) {
        return DateUtil.dateToString(source, DateUtil.FULL_DATE_FORMAT);
    }

    @Override
    public Date convertFrom(String source, Type<Date> destinationType) {
        return (source != null && !source.isEmpty()) ? DateUtil.stringToDate(source, DateUtil.FULL_DATE_FORMAT) : null;
    }
}