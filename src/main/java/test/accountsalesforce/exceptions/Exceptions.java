package test.accountsalesforce.exceptions;

public class Exceptions extends AssertionError{

    public static final String THE_ELEMENT_IS_NOT_VISIBLE= "The element is not visible";
    public static final String THE_TEXT_IS_NOT_EQUAL= "The text does not match";
    public static final String THE_TEXT_DOES_NOT_STRING= "The text does not contain string";

    public Exceptions(String message, Throwable cause){
        super(message, cause);
    }

    public Exceptions(String message){
        super(message);
    }
}
