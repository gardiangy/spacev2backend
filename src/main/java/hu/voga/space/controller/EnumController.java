package hu.voga.space.controller;

import hu.voga.space.controller.response.Response;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/enum")
public class EnumController {

    @GetMapping("/{enumName}")
    @ResponseBody
    public Response getEnumValues(@PathVariable String enumName) {
        Class<?> c;
        try {
            c = Class.forName("hu.voga.space.enums." + enumName);
        }
        catch (ClassNotFoundException e) {
            return Response.createErrorResponse(e);
        }
        return Response.createOKResponse( c.getEnumConstants() );
    }

}
