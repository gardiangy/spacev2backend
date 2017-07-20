package hu.voga.space.controller;

import hu.voga.space.controller.response.Response;
import hu.voga.space.dto.FleetDto;
import hu.voga.space.dto.converter.*;
import hu.voga.space.entity.Fleet;
import hu.voga.space.entity.Ship;
import hu.voga.space.entity.SolarSystem;
import hu.voga.space.service.FleetService;
import hu.voga.space.service.ResourceService;
import hu.voga.space.service.ShipService;
import hu.voga.space.service.SolarSystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/api/solarsystem")
public class SolarSystemController {

    @Autowired
    private SolarSystemService solarSystemService;

    @Autowired
    private ResourceService resourceService;

    @Autowired
    private ShipService shipService;

    @Autowired
    private FleetService fleetService;

    @Autowired
    private SolarSystemConverter solarSystemConverter;

    @Autowired
    private PlanetConverter planetConverter;

    @Autowired
    private ShipConverter shipConverter;

    @Autowired
    private FleetConverter fleetConverter;

    @Autowired
    private ResourceConverter resourceConverter;


    @RequestMapping("/user/{uuid}/discovered")
    @ResponseBody
    public Response getDiscoveredSystems(@PathVariable("uuid") String uuid) {
        return Response.createOKResponse(solarSystemService.findDiscoveredSystemForUser(uuid)
                .stream()
                .map(solarSystemConverter::convertToDto)
                .collect(Collectors.toList()));
    }

    @RequestMapping("/{ssId}/planet")
    @ResponseBody
    public Response getPlanetsForSolarSystem(@PathVariable("ssId") Long ssId) {
        return Response.createOKResponse(solarSystemService.getOne(ssId).getPlanets()
                .stream()
                .map(planetConverter::convertToDto)
                .collect(Collectors.toList()));
    }

    @RequestMapping("/{ssId}/resource")
    @ResponseBody
    public Response getResourcesForSolarSystem(@PathVariable("ssId") Long ssId) {
        final SolarSystem solarSystem = solarSystemService.getOne(ssId);
        return Response.createOKResponse(resourceService.findResourcesBySystem(solarSystem)
                .stream()
                .map(resourceConverter::convertToDto)
                .collect(Collectors.toList()));
    }

    @RequestMapping("/{ssId}/ship")
    @ResponseBody
    public Response getShipsForSolarSystem(@PathVariable("ssId") Long ssId) {
        final SolarSystem solarSystem = solarSystemService.getOne(ssId);
        return Response.createOKResponse(shipService.findShipBySystem(solarSystem)
                .stream()
                .map(shipConverter::convertToDto)
                .collect(Collectors.toList()));
    }

    @RequestMapping("/{ssId}/fleet")
    @ResponseBody
    public Response getFleetsForSolarSystem(@PathVariable("ssId") Long ssId) {
        return Response.createOKResponse(solarSystemService.getOne(ssId).getFleets()
                .stream()
                .map(fleetConverter::convertToDto)
                .collect(Collectors.toList()));
    }

    @RequestMapping(value = "/{ssId}/fleet", method = RequestMethod.POST)
    @ResponseBody
    public Response createFleet(@PathVariable("ssId") Long ssId, @RequestBody FleetDto fleetDto) {
        Fleet fleet = fleetService.save(solarSystemService.getOne(ssId), fleetDto.getName());
        return Response.createOKResponse(fleetConverter.convertToDto(fleet));
    }

    @RequestMapping(value = "/{ssId}/fleet", method = RequestMethod.PUT)
    @ResponseBody
    public Response addShipsToFleet(@PathVariable("ssId") Long ssId, @RequestBody FleetDto fleetDto) {
        List<Ship> ships = fleetDto.getShips()
                .stream()
                .map(shipDto -> shipService.getOne(shipDto.getId()))
                .collect(Collectors.toList());
        Fleet fleet = fleetService.addShipsToFleet(fleetDto.getId(),ships);
        return Response.createOKResponse(fleetConverter.convertToDto(fleet));
    }
}