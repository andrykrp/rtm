package controllers;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import dto.OfferDto;
import ninja.Result;
import ninja.Results;
import ninja.params.PathParam;
import services.ProducerService;

@Singleton
public class OfferController {
    @Inject
    private ProducerService producerService;

    public Result create(OfferDto offerDto, @PathParam("producerId") String producerId) {
        offerDto.setProducer(producerId);
        producerService.save(offerDto);

        System.out.println();

        return Results.ok();
    }
}
