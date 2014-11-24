package services;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import dao.OfferDao;
import dto.OfferDto;
import ma.glasnost.orika.impl.ConfigurableMapper;
import models.Offer;
import services.mappers.OfferDtoToModelMapper;

import java.util.Date;

@Singleton
public class ProducerService {
    @Inject
    private OfferDao offerDao;
    private ConfigurableMapper offerMapper;

    public ProducerService() {
        offerMapper = new OfferDtoToModelMapper();
    }

    public boolean save(OfferDto offerDto) {
        Offer offer = offerMapper.map(offerDto, Offer.class);
        offer.setCreationDate(new Date());
        return offerDao.save(offer);
    }
}
