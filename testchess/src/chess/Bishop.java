package chess;

import static java.lang.Math.abs;

public class Bishop extends Piece {

    public Bishop(int color, Square location) {

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
        if(abs(rowDistance)!=abs(colDistance)) {//çarpazlığını kontrol ediyor
            return false;
        }
        if (!location.getBoard().isDiagonalPathClear(location,targetLocation)){
            return false;
        }
        if (targetLocation.getPiece()==null ){//hedefin boş olup olmadığı

                return true;
        }
        if(targetLocation.getPiece().getColor()==color){//hedef aynı renk ise
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
        return color == ChessBoard.WHITE ? "B" : "b";
    }
}