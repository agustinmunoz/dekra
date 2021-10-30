package es.agustin.munoz.dekra.controller;

import es.agustin.munoz.dekra.model.UserDekra;
import es.agustin.munoz.dekra.repository.UserDekraRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DekraController {


    private static Logger logger = LoggerFactory.getLogger(DekraController.class);

    @Autowired
    UserDekraRepository userDekraRepository;


    @GetMapping("/dekra/getusers")
    public String getUsers(



    ) {
        return "Hola";
    }


    @PostMapping("dekra/user")
    public String addUser(
            @RequestBody UserDekra userDekra
            ){

        userDekraRepository.insert(userDekra);
        return "ok";

    }
}
