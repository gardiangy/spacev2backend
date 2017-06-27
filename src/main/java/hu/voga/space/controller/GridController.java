package hu.voga.space.controller;

import hu.voga.space.controller.response.Response;
import hu.voga.space.dto.converter.GridConverter;
import hu.voga.space.entity.QGrid;
import hu.voga.space.service.GridService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/grid")
public class GridController {

    @Autowired
    private GridService gridService;

    @Autowired
    private GridConverter gridConverter;

    @RequestMapping()
    @ResponseBody
    public Response getGrid() {

        return Response.createOKResponse(gridService.findAllForStarMap()
                .stream()
                .collect(Collectors.toList()));
    }
}