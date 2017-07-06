package hu.voga.space.controller;

import hu.voga.space.controller.response.Response;
import hu.voga.space.dto.converter.PlanetConverter;
import hu.voga.space.dto.converter.ResourceConverter;
import hu.voga.space.dto.converter.ShipConverter;
import hu.voga.space.dto.converter.SolarSystemConverter;
import hu.voga.space.entity.SolarSystem;
import hu.voga.space.service.ResourceService;
import hu.voga.space.service.ShipService;
import hu.voga.space.service.SolarSystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
    private SolarSystemConverter solarSystemConverter;

    @Autowired
    private PlanetConverter planetConverter;

    @Autowired
    private ShipConverter shipConverter;

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
}