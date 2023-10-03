package model;

import model.Location;
import model.Piece;

public class Move {
    private Location from;
    private Location to;
    public Move(Piece piece,Location from, Location to){

        this.from = from;
        this.to = to;
    }

    public Location getFrom() {
        return from;
    }

    public void setFrom(Location from) {
        this.from = from;
    }

    public Location getTo() {
        return to;
    }

    public void setTo(Location to) {
        this.to = to;
    }
}
