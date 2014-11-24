package services.mappers;

import dto.OfferDto;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.converter.ConverterFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;
import models.Offer;
import services.mappers.converters.DateConverter;

public class OfferDtoToModelMapper extends ConfigurableMapper {
    @Override
    protected void configure(MapperFactory factory) {
        ConverterFactory converterFactory = factory.getConverterFactory();
        converterFactory.registerConverter("dateConverter", new DateConverter());

        factory.classMap(OfferDto.class, Offer.class)
                .field("category", "category.id")
                .field("producer", "producer.id")
                .fieldMap("startDate", "startDate").converter("dateConverter").add()
                .fieldMap("endDate", "endDate").converter("dateConverter").add()
                .byDefault()
                .register();
    }
}
