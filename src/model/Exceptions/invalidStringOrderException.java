package model.Exceptions;

public class invalidStringOrderException extends Exception{

    public static final  String ROW = "\n invalid move Order, the ROW value should be in range of [1-8] ?";
    public static final  String COLUMN = "\n invalid move Order, the COLUMN value should be in range of [a-h] ?";

    public invalidStringOrderException(String message){ super(message);}
}
