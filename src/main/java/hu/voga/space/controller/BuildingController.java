package hu.voga.space.controller;

import hu.voga.space.controller.response.Response;
import hu.voga.space.dto.PlanetDto;
import hu.voga.space.dto.converter.BuildingConverter;
import hu.voga.space.dto.converter.ConstructionConverter;
import hu.voga.space.dto.converter.PlanetConverter;
import hu.voga.space.entity.Building;
import hu.voga.space.exception.SpaceException;
import hu.voga.space.service.BuildingService;
import hu.voga.space.service.ConstructionService;
import hu.voga.space.service.PlanetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/building")
public class BuildingController {

    @Autowired
    private BuildingService buildingService;

    @Autowired
    private BuildingConverter buildingConverter;

    @Autowired
    private ConstructionService constructionService;

    @Autowired
    private ConstructionConverter constructionConverter;

    @RequestMapping("/{bldId}")
    @ResponseBody
    public Response getBuildingById(@PathVariable("bldId") Long bldId){
        return Response.createOKResponse( buildingConverter.convertToDto( buildingService.getOne(bldId) ) );
    }

    @RequestMapping("/{bldId}/upgrade")
    @ResponseBody
    public Response upgradeBuilding(@PathVariable("bldId") Long bldId) throws SpaceException {
        final Building building = buildingService.getOne(bldId);
        return Response.createOKResponse( constructionConverter.convertToDto( constructionService.upgradeBuilding(building) ) );
    }

}
