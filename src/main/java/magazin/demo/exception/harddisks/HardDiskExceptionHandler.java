package magazin.demo.exception.harddisks;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class HardDiskExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(HardDiskAlreadyExistsException.class)
    public ResponseEntity<Object> handleHardDiskAlreadyExistsException(
            HardDiskAlreadyExistsException ex, WebRequest request) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(HardDiskNotFoundException.class)
    public ResponseEntity<Object> handleHardDiskNotFoundException(
            HardDiskNotFoundException ex, WebRequest request) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
}