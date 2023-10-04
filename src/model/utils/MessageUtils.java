package model.utils;
public class MessageUtils {
    public static void showMessage(String message, String variation) {
        final String RESET = "\u001B[0m";
        final String RED = "\u001B[31m";
        final String BLUE = "\u001B[34m";
        final String GREEN = "\u001B[32m";

        switch (variation) {
            case "info" -> System.out.print(BLUE + message + RESET);
            case "error" -> System.out.print(RED + message + RESET);
            case "success" -> System.out.print(GREEN + message + RESET);
        }
    }
}