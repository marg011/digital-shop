package magazin.demo.exception.harddisks;

public class HardDiskAlreadyExistsException extends Exception {
    public HardDiskAlreadyExistsException(String message) {
        super(message);
    }
}