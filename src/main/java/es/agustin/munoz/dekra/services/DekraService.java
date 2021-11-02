package es.agustin.munoz.dekra.services;

import es.agustin.munoz.dekra.exception.CustomException;
import es.agustin.munoz.dekra.model.UserDekra;
import org.springframework.http.ResponseEntity;

import java.util.List;


public interface DekraService {

    public UserDekra getUserById(String username, String password) throws CustomException,Exception;

    public List<UserDekra> userList() throws Exception;

    public UserDekra addUser(UserDekra userDekra) throws Exception;

    public void deleteUser(String username) throws Exception ;

/*    public UserDekra updateUser(UserDekra userDekra) throws Exception;*/

}
