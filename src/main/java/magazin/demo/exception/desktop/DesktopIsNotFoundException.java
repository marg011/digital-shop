package magazin.demo.exception.desktop;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class DesktopIsNotFoundException extends RuntimeException {
    public DesktopIsNotFoundException(String message) {
        super(message);
    }
}
