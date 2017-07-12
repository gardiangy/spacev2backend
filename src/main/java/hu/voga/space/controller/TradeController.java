package hu.voga.space.controller;

import hu.voga.space.controller.response.Response;
import hu.voga.space.dto.TradeOfferDto;
import hu.voga.space.dto.converter.TradeOfferConverter;
import hu.voga.space.entity.TradeOffer;
import hu.voga.space.service.TradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

/**
 * Created by lofut on 2017. 06. 29..
 */
@RestController
@RequestMapping("/api/trade")
public class TradeController {

    @Autowired
    private TradeService tradeService;

    @Autowired
    private TradeOfferConverter tradeOfferConverter;


    @RequestMapping("/offers")
    @ResponseBody
    public Response getOffers(){
        return Response.createOKResponse(tradeService.findAllOffers()
                .stream()
                .map(tradeOfferConverter::convertToDto)
                .collect(Collectors.toList()));
    }

    @RequestMapping(value = "/solarSystem/{ssId}/offer", method = RequestMethod.POST)
    @ResponseBody
    public Response saveOffer(@RequestBody TradeOfferDto tradeOfferDto,
                              @PathVariable("ssId") Long ssId){
        final TradeOffer tradeOffer = tradeService.createOffer(
                tradeOfferDto.getFromType(),
                tradeOfferDto.getFromValue(),
                tradeOfferDto.getToType(),
                tradeOfferDto.getToValue(),
                ssId);
        return Response.createOKResponse(tradeOfferConverter.convertToDto(tradeOffer));
    }

}
