package hu.voga.space.controller;

import hu.voga.space.controller.response.Response;
import hu.voga.space.dto.PlanetDto;
import hu.voga.space.dto.converter.PlanetConverter;
import hu.voga.space.entity.Planet;
import hu.voga.space.service.PlanetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by lofut on 2017. 06. 29..
 */
@RestController
@RequestMapping("/api/planet")
public class PlanetController {

    @Autowired
    private PlanetService planetService;

    @Autowired
    private PlanetConverter planetConverter;

    @RequestMapping("/{planetId}")
    @ResponseBody
    public Response getPlanetById(@PathVariable("planetId") Long planetId){
        return Response.createOKResponse( planetConverter.convertToDto( planetService.getOne(planetId) ) );
    }

    @RequestMapping( value = "/save", method = RequestMethod.POST)
    public Response savePlanet(@RequestBody PlanetDto planet){
        return Response.createOKResponse(
                planetConverter.convertToDto( planetService.save( planetConverter.convertToEntity( planet )) )
        );
    }

}
