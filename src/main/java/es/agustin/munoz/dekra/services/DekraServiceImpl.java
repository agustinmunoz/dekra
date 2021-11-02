package es.agustin.munoz.dekra.services;

import com.mongodb.MongoCredential;
import com.mongodb.MongoException;
import es.agustin.munoz.dekra.exception.CustomErrorResponse;
import es.agustin.munoz.dekra.exception.CustomException;
import es.agustin.munoz.dekra.exception.CustomExceptionNotFound;
import es.agustin.munoz.dekra.model.UserDekra;
import es.agustin.munoz.dekra.repository.UserDekraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.xml.bind.DatatypeConverter;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class DekraServiceImpl implements DekraService {

    @Autowired
    CryptService cryptService;

    @Autowired
    UserDekraRepository userDekraRepository;

    @Override
    public UserDekra getUserById(String username, String password) throws Exception {

        Optional<UserDekra> userDekraOptional;
        UserDekra userDekra;
        String error;
        try {
            userDekraOptional = userDekraRepository.findById(username);

        } catch ( Exception e) {
                throw new Exception(e.getMessage());
        }

        if (userDekraOptional.isPresent() && userDekraOptional.get()!=null) {
            userDekra = userDekraOptional.get();
           // String decrypPass = cryptService.decrypt(userDekra.getPassword());
            byte[] decrypPass = DatatypeConverter.parseBase64Binary(userDekra.getPassword());

            String decrypPassUTF = new String(decrypPass, "UTF-8");
            if (decrypPassUTF.equals(password)) {
              //  userDekra.setPassword(null);
                userDekra.setCreationDate(userDekraOptional.get().getCreationDate());
                userDekra.setLastLogin(LocalDateTime.now());
                try {
                  userDekraRepository.save(userDekra);
                } catch (Exception e){
                    throw new Exception(e.getMessage());
                }

            } else {
                throw new CustomException("Error in Credential");
            }
        } else {
            throw new CustomExceptionNotFound("User not found");
        }

        return userDekra;
    }

    @Override
    public List<UserDekra> userList() throws Exception {

        List<UserDekra> userList;

        try {
            userList = userDekraRepository.findAll();

           /* for(UserDekra userDekra : userList){
                userDekra.setPassword(null);
            }*/

        } catch ( Exception e) {
            throw new Exception(e.getMessage());
        }

        return userList;
    }

    @Override
    public UserDekra addUser(UserDekra userDekra) throws Exception {
        try {
           // String encodePass = cryptService.encrypt(userDekra.getPassword());

            String encodePass = DatatypeConverter.printBase64Binary(userDekra.getPassword().getBytes(StandardCharsets.UTF_8));

            userDekra.setPassword(encodePass);
            userDekra.setCreationDate(LocalDateTime.now());
            userDekra.setLastLogin(LocalDateTime.now());
            userDekraRepository.insert(userDekra);
          //  userDekra.setPassword(null);

        } catch (Exception e){
            throw new Exception(e.getMessage());
        }


        return userDekra;
    }

    @Override
    public void deleteUser(String username) throws Exception {

        UserDekra userDekra;
        try {
            Optional<UserDekra> userDekraOptional= userDekraRepository.findById(username);
            if(userDekraOptional.isPresent() && userDekraOptional.get()!=null) {
                userDekraRepository.deleteById(username);
            } else {
                throw new CustomExceptionNotFound("Este usuario No existe");
            }


        } catch (Exception e){
            throw new Exception(e.getMessage());
        }


    }

    @Override
    public UserDekra updateUser(UserDekra userDekra) throws Exception {


        try {
            Optional<UserDekra> userDekraOptional= userDekraRepository.findById(userDekra.getUsername());
            if(userDekraOptional.isPresent() && userDekraOptional.get()!=null) {

                String encodePass = DatatypeConverter.printBase64Binary(userDekra.getPassword().getBytes(StandardCharsets.UTF_8));
                userDekra.setPassword(encodePass);
                userDekra.setCreationDate(userDekraOptional.get().getCreationDate());
                userDekra.setLastLogin(userDekraOptional.get().getLastLogin());
                userDekraRepository.save(userDekra);
            } else {
                throw new CustomExceptionNotFound("Este usuario No existe");
            }


        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
        return userDekra;
    }


}
