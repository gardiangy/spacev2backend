package hu.voga.space.controller;

import hu.voga.space.controller.response.Response;
import hu.voga.space.dto.PlanetDto;
import hu.voga.space.dto.converter.BuildingConverter;
import hu.voga.space.dto.converter.PlanetConverter;
import hu.voga.space.service.BuildingService;
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

    @RequestMapping("/{bldId}")
    @ResponseBody
    public Response getBuildingById(@PathVariable("bldId") Long bldId){
        return Response.createOKResponse( buildingConverter.convertToDto( buildingService.getOne(bldId) ) );
    }

}
