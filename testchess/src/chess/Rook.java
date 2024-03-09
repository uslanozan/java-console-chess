package chess;

import java.util.Locale;

public class Rook extends Piece {

    public Rook(int color, Square location) {

        super(color, location);
    }
    @Override
    public boolean canMove(String to) {
        Square targetLocation=location.getBoard().getSquareAt(to);
        int rowDistance = targetLocation.getRowDistance(location);
        int colDistance = targetLocation.getColDistance(location);
        if(colDistance==0 && rowDistance==0){
            return false;
        }

        if(location.isAtSameColumn(targetLocation) || location.isAtSameRow(targetLocation)){
           if((rowDistance>1 || colDistance>1) || (rowDistance<-1 || colDistance<-1)){
               Square[] between=location.getBoard().getSquaresBetween(location,targetLocation);
               for (Square s:between){
                   if(s.getPiece()!=null){
                       return false;
                   }
               }
           }
           if (targetLocation.getPiece()==null ){
               return true;
           }
           else {
               if(targetLocation.getPiece().getColor()==color){
                   return false;
               }
               else{
                   return true;
               }
           }
        }
        else {
            return false;
        }
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
        return color == ChessBoard.WHITE ? "R" : "r";
    }
}