package es.agustin.munoz.dekra.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class CustomGlobalExceptionHandler extends ResponseEntityExceptionHandler {



    @ExceptionHandler(CustomException.class)
    public ResponseEntity<Object> customException(CustomException ex) {
        CustomErrorResponse errors = new CustomErrorResponse();
        errors.setTimestamp(LocalDateTime.now());
        errors.setError(ex.getMessage());


        return new ResponseEntity<>(errors, HttpStatus.UNAUTHORIZED);
    }


    @ExceptionHandler(CustomExceptionNotFound.class)
    public ResponseEntity<Object> customExceptionNotFound(CustomExceptionNotFound ex) {
        CustomErrorResponse errors = new CustomErrorResponse();
        errors.setTimestamp(LocalDateTime.now());
        errors.setError(ex.getMessage());


        return new ResponseEntity<>(errors, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> exception(Exception ex) {
        CustomErrorResponse errors = new CustomErrorResponse();
        errors.setTimestamp(LocalDateTime.now());
        errors.setError(ex.getMessage());


        return new ResponseEntity<>(errors, HttpStatus.INTERNAL_SERVER_ERROR);
    }



    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
      //  return this.handleExceptionInternal(ex, (Object)null, headers, status, request);

        CustomErrorResponse errors = new CustomErrorResponse();
        errors.setTimestamp(LocalDateTime.now());
        errors.setError(ex.getMessage());

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);

    }

    @Override
    protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
      //  return this.handleExceptionInternal(ex, (Object)null, headers, status, request);

        CustomErrorResponse errors = new CustomErrorResponse();
        errors.setTimestamp(LocalDateTime.now());
        errors.setError(ex.getMessage());


        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }


    /*@ExceptionHandler(EmptyParamException.class)
    public ResponseEntity<com.todoregalosoriginales.productloaderservice.exception.CustomErrorResponse> emptyParam(Exception ex) {

      // logger.info(response);
        logger.info(ex);
      //  response.sendError(HttpStatus.NOT_FOUND.value());
       // return "wwwww";

        com.todoregalosoriginales.productloaderservice.exception.CustomErrorResponse errors = new com.todoregalosoriginales.productloaderservice.exception.CustomErrorResponse();
        errors.setTimestamp(LocalDateTime.now());
        errors.setError(ex.getMessage());
        errors.setStatus(HttpStatus.BAD_REQUEST.value());

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);


    }


    @ExceptionHandler(DuplicateParamException.class)
    public ResponseEntity<com.todoregalosoriginales.productloaderservice.exception.CustomErrorResponse> duplicateParam(Exception ex) {

        // logger.info(response);
        logger.info(ex);
        //  response.sendError(HttpStatus.NOT_FOUND.value());
        // return "wwwww";

        com.todoregalosoriginales.productloaderservice.exception.CustomErrorResponse errors = new com.todoregalosoriginales.productloaderservice.exception.CustomErrorResponse();
        errors.setTimestamp(LocalDateTime.now());
        errors.setError(ex.getMessage());
        errors.setStatus(HttpStatus.BAD_REQUEST.value());

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);


    }

*/
}
