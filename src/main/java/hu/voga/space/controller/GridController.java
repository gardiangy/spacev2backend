package hu.voga.space.controller;

import hu.voga.space.controller.response.Response;
import hu.voga.space.service.GridService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api/grid")
public class GridController {

    @Autowired
    private GridService gridService;


    @RequestMapping()
    @ResponseBody
    public Response getGrid() {
        return Response.createOKResponse(gridService.findAllForStarMap());
    }
}