package chess;

import static java.lang.Math.abs;

public class Knight extends Piece {

    public Knight(int color, Square location) {

        super(color, location);
    }
    @Override
    public boolean canMove(String to) {
        Square targetLocation=location.getBoard().getSquareAt(to);
        int rowDistance = targetLocation.getRowDistance(location);
        int colDistance = targetLocation.getColDistance(location);
        if(colDistance==0 && rowDistance==0){//olduğu yere gidemez
            return false;
        }

        if (!(abs(colDistance)==2 && abs(rowDistance)==1)){
            if (!(abs(colDistance)==1 && abs(rowDistance)==2)){
                return false;
            }
        }

        if (targetLocation.getPiece()==null ){//hedefin boş olup olmadığı (elleme)

            return true;
        }
        if(targetLocation.getPiece().getColor()==color){//hedef aynı renk ise (elleme)
            return false;
        }
        return true;
    }
    @Override public void move(String to) {
        Square targetLocation = location.getBoard().getSquareAt(to);
        targetLocation.setPiece(this);
        //clear previous location
        location.clear();
        //update current location
        location = targetLocation;
        location.getBoard().nextPlayer();
    }
    @Override
    public String toString() {
        return color == ChessBoard.WHITE ? "N" : "n";
    }
}