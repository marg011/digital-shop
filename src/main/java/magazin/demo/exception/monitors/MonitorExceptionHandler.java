package magazin.demo.exception.monitors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class MonitorExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(MonitorAlreadyExistsException.class)
    public ResponseEntity<Object> handleMonitorAlreadyExistsException(
            MonitorAlreadyExistsException ex, WebRequest request) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(MonitorNotFoundException.class)
    public ResponseEntity<Object> handleMonitorNotFoundException(
            MonitorNotFoundException ex, WebRequest request) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
}
