import java.util.*;
import java.io.*;

public class InsufficientFundException extends Exception {
    public InsufficientFundException(String message) {
        super(message);
    }
}