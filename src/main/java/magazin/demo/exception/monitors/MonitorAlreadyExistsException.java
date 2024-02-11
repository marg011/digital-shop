package magazin.demo.exception.monitors;

public class MonitorAlreadyExistsException extends Throwable {
    public MonitorAlreadyExistsException(String message) {
        super(message);
    }
}