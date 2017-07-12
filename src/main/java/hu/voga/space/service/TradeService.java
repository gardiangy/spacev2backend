package hu.voga.space.service;

import hu.voga.space.entity.SolarSystem;
import hu.voga.space.entity.TradeOffer;
import hu.voga.space.enums.ResourceType;
import hu.voga.space.repository.TradeOfferRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TradeService {

    private static final Logger logger = LoggerFactory.getLogger(TradeService.class);

    @Autowired
    private TradeOfferRepository tradeOfferRepository;

    @Autowired
    private SolarSystemService solarSystemService;

    public TradeOffer createOffer(ResourceType fromType, Long fromValue,
                                ResourceType toType, Long toValue,
                                Long solarSystemId){
        TradeOffer tradeOffer = new TradeOffer();
        tradeOffer.setTroFromType(fromType);
        tradeOffer.setTroFromValue(fromValue);
        tradeOffer.setTroToType(toType);
        tradeOffer.setTroToValue(toValue);
        SolarSystem solarSystem = solarSystemService.getOne(solarSystemId);
        tradeOffer.setSolarSystem(solarSystem);
        return tradeOfferRepository.save(tradeOffer);
    }

    public List<TradeOffer> findAllOffers(){
        return tradeOfferRepository.findAll();
    }

}
