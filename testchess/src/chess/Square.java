package chess;


import java.util.Locale;

public class Square {

    private Piece piece=null;
    public ChessBoard board=null;
    public int Column=0;
    public int Row=0;
    public ChessBoard getBoard() {

        return board;
    }

    public int getRowDistance(Square location) {
        int rowdistance=this.Row-location.Row;
        return rowdistance;
    }

    public boolean isAtSameColumn(Square targetLocation) {

        return (targetLocation.Column == Column);
    }
    public boolean isAtSameRow(Square targetLocation) {

        return (targetLocation.Row == Row);
    }
    public boolean isEmpty() {
        return (piece==null);
    }

    public boolean isNeighborColumn(Square targetLocation) {
        return (targetLocation.Column == Column+1 || targetLocation.Column == Column-1  );
    }

    public Piece getPiece() {
        return piece;
    }

    public boolean isAtLastRow(int color) {
        if(color==ChessBoard.WHITE && Row==7) //7 diye düzeltilebilir
            return true;
        if (color==ChessBoard.BLACK && Row==0) // 0 diye düzeltilebilir
            return true;
        return false;
    }

    public void putNewQueen(int color) {
        if (color==1){ //beyaz
            setPiece(new Queen(ChessBoard.WHITE,this));
        }
        else {
            setPiece(new Queen(ChessBoard.BLACK,this));
        }

    }

    public void setPiece(Piece piecevariable) {
        piece=piecevariable;
    }

    public void clear() {
        piece=null;
    }

    public int getColDistance(Square location) {
        int colDistance=this.Column-location.Column;
        return colDistance;
    }
}
