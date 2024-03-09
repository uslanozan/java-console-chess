package chess;

public class King extends Piece {
    public King(int color, Square location) {
        super(color, location);
    }
    @Override
    public boolean canMove(String to) {
        Square targetLocation = location.getBoard().getSquareAt(to);
        int rowDistance = targetLocation.getRowDistance(location);
        int colDistance = targetLocation.getColDistance(location);
        if(colDistance==0 && rowDistance==0){
            return false;
        }
        if (targetLocation.getPiece()!=null && targetLocation.getPiece().getColor() == color ){
            return false;
        }
        if((rowDistance < -1 || rowDistance > 1) || (colDistance < -1 || colDistance > 1)){
            return false;
        }
        return true;
    }
    @Override
    public void move(String to) {
        Square targetLocation = location.getBoard().getSquareAt(to);
        //promoteToQueen
        targetLocation.setPiece(this);
            //clear previous location
        location.clear();
        //update current location
        location = targetLocation;
        location.getBoard().nextPlayer();
    }
    @Override
    public String toString() {

        return color == ChessBoard.WHITE ? "K" : "k";
    }
}