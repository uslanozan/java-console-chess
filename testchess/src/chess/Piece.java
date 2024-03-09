package chess;

public class Piece {
    public Square location=null;
    public int color;
    public Piece(int color, Square location) {
        this.color=color;
        this.location=location;
    }

    public int getColor() {

        return color;
    }

    public boolean canMove(String to) {

        return false;
    }

    public void move(String to) {
    }
}
