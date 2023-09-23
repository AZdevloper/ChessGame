package model.utils;

public enum Color {
    BLACK, WHITE;
    public Color nextColor(Color color){

        return color.equals(BLACK) ? BLACK : WHITE;
    }

}
