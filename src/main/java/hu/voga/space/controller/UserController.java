package hu.voga.space.controller;

import hu.voga.space.controller.response.Response;
import hu.voga.space.dto.ConstructionDto;
import hu.voga.space.dto.converter.ConstructionConverter;
import hu.voga.space.dto.converter.UserConverter;
import hu.voga.space.entity.Construction;
import hu.voga.space.entity.User;
import hu.voga.space.exception.SpaceException;
import hu.voga.space.service.ConstructionService;
import hu.voga.space.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserConverter userConverter;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseBody
    public Response getAllUser() throws SpaceException {
        List<User> users = userService.finAll();
        return Response.createOKResponse( users
                .stream()
                .map(userConverter::convertToDto)
                .collect(Collectors.toList())
        );
    }

    @RequestMapping(value = "/{userUuid}", method = RequestMethod.GET)
    @ResponseBody
    public Response getUserByUUID(@PathVariable("userUuid") String userUuid) throws SpaceException {
        return Response.createOKResponse( userConverter.convertToDto( userService.getOne(userUuid) ) );
    }

}
