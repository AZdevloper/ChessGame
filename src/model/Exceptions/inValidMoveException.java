package model.Exceptions;

public class inValidMoveException extends Exception{

    public static final  String PAWN = "\n pawn piece can move just one piece ?";

    public inValidMoveException(String message){super(message);}
}
