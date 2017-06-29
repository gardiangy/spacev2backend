package hu.voga.space.controller;

import hu.voga.space.controller.response.Response;
import hu.voga.space.dto.ConstructionDto;
import hu.voga.space.dto.converter.ConstructionConverter;
import hu.voga.space.entity.Construction;
import hu.voga.space.exception.SpaceException;
import hu.voga.space.service.ConstructionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/construction")
public class ConstructionController {

    @Autowired
    private ConstructionService constructionService;

    @Autowired
    private ConstructionConverter constructionConverter;

    @RequestMapping(value = "planet/{planetId}", method = RequestMethod.POST)
    @ResponseBody
    public Response saveConstruction(@PathVariable("planetId") Long planetId,
                                     @RequestBody ConstructionDto constructionDto) throws SpaceException {
        Construction construction = constructionService.constructBuilding(constructionDto.getBuildingType(), planetId);
        return Response.createOKResponse( constructionConverter.convertToDto(construction) );
    }

}
