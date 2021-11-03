package es.agustin.munoz.dekra.controller;

import es.agustin.munoz.dekra.model.UserDekra;;
import es.agustin.munoz.dekra.services.DekraService;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin()
@RestController
@Api(description = "Dekra Api Rest Controller Technical Text")
public class DekraController {


    private static Logger logger = LoggerFactory.getLogger(DekraController.class);




    @Autowired
    DekraService dekraService;

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK. El recurso se obtiene correctamente", response = UserDekra.class ),
            @ApiResponse(code = 400, message = "Bad Request.Esta vez cambiamos el tipo de dato de la respuesta (String)", response = String.class),
            @ApiResponse(code = 500, message = "Error inesperado del sistema") })
    @ApiOperation(value="Get All Dekra Users")
    @GetMapping("/dekra/users")
    public List<UserDekra> getUsers() throws Exception {

        List<UserDekra> userList = dekraService.userList();
        return userList;
    }

    @ApiOperation(value = "Get User By Id And Pass")
    @GetMapping("/dekra/user")
    public UserDekra getUserById(

            @ApiParam(
                    value = "Username String")
            @RequestParam("username") String username,
            @ApiParam(
                    value = "Password String")
            @RequestParam("password") String password

    ) throws Exception {

        UserDekra userDekra = dekraService.getUserById(username,password);
        return userDekra;

    }

     @PostMapping("dekra/user")
    public UserDekra addUser(
       @Validated @RequestBody UserDekra userDekra) throws Exception {
          UserDekra response = dekraService.addUser(userDekra);

          return response;
     }

    @DeleteMapping("dekra/user")
    public void deleteUser(
            @RequestParam("username") String username) throws Exception {

        dekraService.deleteUser(username);

    }


    @PutMapping("dekra/user")
    public UserDekra updateUser(@Validated @RequestBody UserDekra userDekra) throws Exception {


        UserDekra response = dekraService.updateUser(userDekra);
        return response;
    }




    }






