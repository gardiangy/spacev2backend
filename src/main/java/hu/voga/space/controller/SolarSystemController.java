package hu.voga.space.controller;

import hu.voga.space.controller.response.Response;
import hu.voga.space.dto.converter.SolarSystemConverter;
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
    private SolarSystemConverter solarSystemConverter;


    @RequestMapping("/user/{userGuid}/discovered")
    @ResponseBody
    public Response getDiscoveredSystems(@PathVariable("userGuid") String userGuid) {
        return Response.createOKResponse(solarSystemService.findDiscoveredSystemForUser(userGuid)
                .stream()
                .map(solarSystemConverter::convertToDto)
                .collect(Collectors.toList()));
    }
}