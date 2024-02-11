package magazin.demo.exception.laptop;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class LaptopIsNotFoundException extends RuntimeException {
    public LaptopIsNotFoundException(String message) {
        super(message);
    }
}
