package com.apinanpaska.web.htmlcontroller;

import com.apinanpaska.web.htmlcontroller.models.ConnectionClientModel;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeleteController {

    @DeleteMapping("/rest/deleteGame")
    public void deleteGame(@RequestBody ConnectionClientModel connectionClientModel){

    }
}
