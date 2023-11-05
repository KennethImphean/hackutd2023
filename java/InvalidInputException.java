public class InvalidInputException extends Exception{
    protected String invalidString = "";

    public InvalidInputException(String s)
    {
        super("Invalid user input " + s);
        this.invalidString = s;
    }

    public String getInvalidString()
    {
        return invalidString;
    }
    
    public String getMessage()
    {
        return "Invalid user input " + this.invalidString;
    }
}
